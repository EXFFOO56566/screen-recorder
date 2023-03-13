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
@file:Suppress("unused")

package com.tochy.screenrecorder

import android.app.Application
import com.tochy.screenrecorder.BuildConfig.DEBUG
import com.tochy.screenrecorder.utilcmnuse.commonModule
import com.tochy.screenrecorder.utilcmnuse.prefModule
import com.tochy.screenrecorder.main.mainModule
import com.tochy.screenrecorder.main.viewModelModule
import com.tochy.screenrecorder.capturescrn.engineModule
import com.tochy.screenrecorder.lng.FabricLng
import com.tochy.screenrecorder.notifictn.Notifications
import com.tochy.screenrecorder.notifictn.notificationsModule
import com.google.android.gms.ads.MobileAds
import com.google.firebase.analytics.FirebaseAnalytics
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree


class SCApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (DEBUG) {
            Timber.plant(DebugTree())
        }

        FirebaseAnalytics.getInstance(this);
        Timber.plant(FabricLng())
        MobileAds.initialize(this) {}

        startKoin {
            //            listOf(
//                commonModule,
//                notificationsModule,
//                prefModule,
//                engineModule,
//                mainModule,
//                viewModelModule
//            )
            modules(
                listOf(
                    commonModule,
                    notificationsModule,
                    prefModule,
                    engineModule,
                    mainModule,
                    viewModelModule
                )
            )
            androidLogger()
            androidContext(this@SCApp)

        }

        val notifications by inject<Notifications>()
        notifications.createChannels()
    }

}
