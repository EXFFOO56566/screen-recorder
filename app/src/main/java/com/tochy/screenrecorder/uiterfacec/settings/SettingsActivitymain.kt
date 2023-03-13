/**
 * (@rdbrain)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tochy.screenrecorder.uiterfacec.settings

import android.content.Intent
import android.os.Bundle
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.tochy.screenrecorder.R
import com.tochy.screenrecorder.uifile.DarkModeSwitchActivity
import com.tochy.screenrecorder.uiterfacec.mainactivities.MainActivity
import com.tochy.screenrecorder.utilcmnuse.view.show
import kotlinx.android.synthetic.main.include_appbar.*
import timber.log.Timber
import kotlinx.android.synthetic.main.include_appbar.app_toolbar as appToolbar
import kotlinx.android.synthetic.main.include_appbar.toolbar_title as toolbarTitle

/** (rdbrain) */
class SettingsActivitymain : DarkModeSwitchActivity() {
    lateinit var mAdView: AdView
    private lateinit var mInterstitialAd: InterstitialAd
    private var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        admobAds()
        toolbarTitle.setText(R.string.settings)
        setIsInRoot(true)
        toolbar.setNavigationOnClickListener {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()
            } else {
                navigateUpTo(Intent(this, MainActivity::class.java))
            }
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SettingsFragment())
                .commit()
        }
    }


    fun setIsInRoot(root: Boolean) {
        if (root) {
            toolbar.navigationIcon = getDrawable(R.drawable.ic_close_black_24dp)
        } else {
            toolbar.navigationIcon = getDrawable(R.drawable.ic_back_black_24dp)
        }
    }

    fun invalidateToolbarElevation(scrollY: Int) {
        if (scrollY > (toolbar.measuredHeight / 2)) {
            appToolbar.elevation = resources.getDimension(R.dimen.raised_toolbar_elevation_indp)
        } else {
            appToolbar.elevation = 0f
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
            interAds();
        }
    }

    override fun onStart() {
        super.onStart()
        isRunning = true
    }

    override fun onStop() {
        super.onStop()
        isRunning = false
    }

    private fun admobAds() {
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        mAdView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                mAdView.show()
                Timber.i("admobbanner = load");
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
                Timber.i("admobbanner =$errorCode");

            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Timber.i("admobbanner =opn");

            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Timber.i("admobbanner =clk");

            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Timber.i("admobbanner =app_left");

            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Timber.i("admobbanner =close");

            }
        }
    }

    private fun interAds() {
        mInterstitialAd = InterstitialAd(this)

        mInterstitialAd.adUnitId = getString(R.string.interstitial)
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        mInterstitialAd.adListener = object : AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                if (isRunning && mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
                Timber.d("The interstitial wasn't loaded yet.$errorCode")
            }

            override fun onAdOpened() {
                // Code to be executed when the ad is displayed.
                Timber.d("The interstitial wasn't loaded yet.onAdOpened")
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.

            }

            override fun onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
            }
        }
    }

}

