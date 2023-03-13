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
package com.tochy.screenrecorder.uiterfacec.mainactivities

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.content.Intent.ACTION_VIEW
import android.content.Intent.EXTRA_STREAM
import android.os.Bundle
import android.provider.Settings.ACTION_MANAGE_OVERLAY_PERMISSION
import androidx.lifecycle.Observer
import com.afollestad.assent.Permission.WRITE_EXTERNAL_STORAGE
import com.afollestad.assent.askForPermissions
import com.afollestad.inlineactivityresult.startActivityForResult
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.callbacks.onCancel
import com.afollestad.materialdialogs.callbacks.onDismiss
import com.tochy.screenrecorder.R
import com.tochy.screenrecorder.utilcmnuse.intents.UrlLauncher
import com.tochy.screenrecorder.utilcmnuse.forwords.startActivity
import com.tochy.screenrecorder.utilcmnuse.forwords.toUri
import com.tochy.screenrecorder.utilcmnuse.forwords.toast
import com.tochy.screenrecorder.utilcmnuse.rxdata.attachLifecycle
import com.tochy.screenrecorder.capturescrn.capturepermission.SCRationaleHandlera
import com.tochy.screenrecorder.capturescrn.capturepermission.OverlayExplanationCallback
import com.tochy.screenrecorder.capturescrn.capturepermission.OverlayExplanationDialog
import com.tochy.screenrecorder.capturescrn.capturerecordings.Recording
import com.tochy.screenrecorder.capturescrn.captureservice.BackgroundService.Companion.PERMISSION_DENIED
import com.tochy.screenrecorder.capturescrn.captureservice.ErrorDialogActivity
import com.tochy.screenrecorder.uifile.DarkModeSwitchActivity
import com.tochy.screenrecorder.uiterfacec.settings.SettingsActivitymain
import com.tochy.screenrecorder.views.asBackgroundTint
import com.tochy.screenrecorder.views.asEnabled
import com.tochy.screenrecorder.views.asIcon
import com.afollestad.recyclical.datasource.emptySelectableDataSourceTyped
import com.afollestad.recyclical.setup
import com.afollestad.recyclical.viewholder.hasSelection
import com.afollestad.recyclical.viewholder.isSelected
import com.afollestad.recyclical.withItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.tochy.screenrecorder.utilcmnuse.view.*
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import kotlinx.android.synthetic.main.activity_main.empty_view
import kotlinx.android.synthetic.main.activity_main.fab
import kotlinx.android.synthetic.main.activity_main.list
import kotlinx.android.synthetic.main.include_appbar.toolbar
import kotlinx.android.synthetic.main.item_recording.view.thumbnail
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import timber.log.Timber
import kotlinx.android.synthetic.main.include_appbar.app_toolbar as appToolbar
import kotlinx.android.synthetic.main.include_appbar.toolbar_title as toolbarTitle

/** (tochy) */
class MainActivity : DarkModeSwitchActivity(), OverlayExplanationCallback {

    private val viewModel by viewModel<MainViewModel>()
    private val urlLauncher by inject<UrlLauncher> { parametersOf(this) }
    lateinit var mAdView: AdView

    private val dataSource =
        emptySelectableDataSourceTyped<Recording>().apply {
            onSelectionChange {
                if (it.hasSelection()) {
                    if (toolbar.navigationIcon == null) {
                        toolbar.run {
                            setNavigationIcon(R.drawable.ic_close_black_24dp)
                            menu.clear()
                            inflateMenu(R.menu.edit_mode_s_d)
                        }
                    }
                    toolbarTitle.text =
                        getString(R.string.app_name_short_withNumber_str, it.getSelectionCount())
                    toolbar.menu.run {
                        findItem(R.id.share).isVisible = it.getSelectionCount() == 1
                        findItem(R.id.delete).isEnabled = it.getSelectionCount() > 0
                    }
                } else {
                    toolbar.run {
                        navigationIcon = null
                        menu.clear()
                        inflateMenu(R.menu.main)
                    }
                    toolbarTitle.text = getString(R.string.app_name_short)
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()
        setupGrid()
        admobAds();
        fab.onDebouncedClick { viewModel.fabClicked() }
        lifecycle.addObserver(viewModel)

        viewModel.onRecordings()
            .observe(this, Observer {
                dataSource.set(
                    newItems = it,
                    areTheSame = Recording.Companion::areTheSame,
                    areContentsTheSame = Recording.Companion::areContentsTheSame
                )
            })
        viewModel.onFabColorRes()
            .asBackgroundTint(this, fab)
        viewModel.onFabIconRes()
            .asIcon(this, fab)
//    viewModel.onFabTextRes()
//        .asText(this, fab)
        viewModel.onFabEnabled()
            .asEnabled(this, fab)

        viewModel.onNeedOverlayPermission()
            .observeOn(mainThread())
            .subscribe { OverlayExplanationDialog.show(this) }
            .attachLifecycle(this)
        viewModel.onNeedStoragePermission()
            .observeOn(mainThread())
            .subscribe { onShouldAskForStoragePermission() }
            .attachLifecycle(this)
        viewModel.onError()
            .observeOn(mainThread())
            .subscribe { ErrorDialogActivity.show(this, it) }
            .attachLifecycle(this)

        checkForMediaProjectionAvailability()
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

    override fun onResume() {
        super.onResume()
        invalidateToolbarElevation(list.computeVerticalScrollOffset())
    }

    override fun onBackPressed() {
        if (dataSource.hasSelection()) {
            dataSource.deselectAll()
        } else {
            super.onBackPressed()
        }
    }

    override fun onShouldAskForOverlayPermission() {
        val intent = Intent(
            ACTION_MANAGE_OVERLAY_PERMISSION,
            "package:$packageName".toUri()
        )
        startActivityForResult(
            intent = intent,
            requestCode = DRAW_OVER_OTHER_APP_PERMISSION
        ) { _, _ ->
            viewModel.permissionGranted()
        }
    }

    private fun onShouldAskForStoragePermission() {
        askForPermissions(
            WRITE_EXTERNAL_STORAGE,
            requestCode = STORAGE_PERMISSION,
            rationaleHandler = SCRationaleHandlera(this)
        ) { res ->
            if (!res.isAllGranted(WRITE_EXTERNAL_STORAGE)) {
                sendBroadcast(Intent(PERMISSION_DENIED))
                toast(R.string.permission_denied_note_capture)
            } else {
                viewModel.permissionGranted()
            }
        }
    }

    private fun setupToolbar() = toolbar.run {
        inflateMenu(R.menu.main)
        setNavigationOnClickListener { dataSource.deselectAll() }
        setOnMenuItemDebouncedClickListener { item ->
            when (item.itemId) {
                R.id.settings -> startActivity<SettingsActivitymain>()
                R.id.share -> shareRecording(dataSource.getSelectedItems().single())
                R.id.delete -> {
                    viewModel.deleteRecordings(dataSource.getSelectedItems())
                    dataSource.deselectAll()
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupGrid() {
        list.setup {
            withDataSource(dataSource)
            withEmptyView(empty_view)
            withItem<Recording, RecordingViewHolder>(R.layout.item_recording) {
                onBind(::RecordingViewHolder) { _, item ->
                    Glide.with(thumbnail)
                        .asBitmap()
                        .apply(RequestOptions().frame(0))
                        .load(item.toUri())
                        .into(itemView.thumbnail)
                    name.text = item.name
                    details.text = "${item.sizeString()} – ${item.timestampString()}"
                    checkBox.showOrHide(hasSelection())
                    checkBox.isChecked = isSelected()
                }
                onClick {
                    if (hasSelection()) {
                        toggleSelection()
                    } else {
                        onRecordingClicked(item)
                    }
                }
                onLongClick {
                    toggleSelection()
                }
            }
        }
        list.onScroll { invalidateToolbarElevation(it) }
    }

    private fun onRecordingClicked(recording: Recording) {
        try {
            startActivity(Intent(ACTION_VIEW).apply {
                setDataAndType(recording.toUri(), "video/*")
            })
        } catch (_: ActivityNotFoundException) {
            toast(R.string.install_video_viewer_in)
        }
    }

    private fun invalidateToolbarElevation(scrollY: Int) {
        if (scrollY > (toolbar.measuredHeight / 2)) {
            appToolbar.elevation = resources.getDimension(R.dimen.raised_toolbar_elevation_indp)
        } else {
            appToolbar.elevation = 0f
        }
    }

    private fun shareRecording(recording: Recording) {
        val uri = recording.toUri()
        startActivity(Intent(ACTION_SEND).apply {
            setDataAndType(uri, "video/*")
            putExtra(EXTRA_STREAM, uri)
        })
    }

    private fun checkForMediaProjectionAvailability() {
        try {
            Class.forName("android.media.projection.MediaProjectionManager")
        } catch (e: ClassNotFoundException) {
            MaterialDialog(this).show {
                title(text = "Device Unsupported")
                message(
                    text = "Your device lacks support for MediaProjectionManager. Either the manufacturer " +
                            "of your device left it out, or you are using an emulator."
                )
                positiveButton(android.R.string.ok) { finish() }
                cancelOnTouchOutside(false)
                cancelable(false)
                onCancel { finish() }
                onDismiss { finish() }
            }
        }
    }

    private companion object {
        private const val DRAW_OVER_OTHER_APP_PERMISSION = 68
        private const val STORAGE_PERMISSION = 64
    }
}
