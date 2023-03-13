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
package com.tochy.screenrecorder.utilcmnuse

import com.afollestad.rxkprefs.RxkPrefs
import com.afollestad.rxkprefs.rxkPrefs
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_ALWAYS_SHOW_CONTROLS
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_AUDIO_BIT_RATE
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_COUNTDOWN
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_DARK_MODE
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_DARK_MODE_AUTOMATIC
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_DARK_MODE_END
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_DARK_MODE_START
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_FRAME_RATE
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_RECORDINGS_FOLDER
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_RECORD_AUDIO
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_RESOLUTION_HEIGHT
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_RESOLUTION_WIDTH
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_STOP_ON_SCREEN_OFF
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_STOP_ON_SHAKE
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_VIDEO_BIT_RATE
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.io.*



val prefModule = module {

    single { rxkPrefs(get(), "settings") }

    // UI
    factory(named(PREF_DARK_MODE)) {
        get<RxkPrefs>().boolean(PREF_DARK_MODE, false)
    }

    factory(named(PREF_DARK_MODE_AUTOMATIC)) {
        get<RxkPrefs>().boolean(PREF_DARK_MODE_AUTOMATIC, false)
    }

    factory(named(PREF_DARK_MODE_START)) {
        get<RxkPrefs>().string(PREF_DARK_MODE_START, "20:00")
    }

    factory(named(PREF_DARK_MODE_END)) {
        get<RxkPrefs>().string(PREF_DARK_MODE_END, "8:00")
    }

    // Quality
    factory(named(PREF_FRAME_RATE)) {
        get<RxkPrefs>().integer(PREF_FRAME_RATE, 30)
    }

    factory(named(PREF_RESOLUTION_WIDTH)) {
        get<RxkPrefs>().integer(PREF_RESOLUTION_WIDTH, 0)
    }

    factory(named(PREF_RESOLUTION_HEIGHT)) {
        get<RxkPrefs>().integer(PREF_RESOLUTION_HEIGHT, 0)
    }

    factory(named(PREF_VIDEO_BIT_RATE)) {
        get<RxkPrefs>().integer(PREF_VIDEO_BIT_RATE, 8_000_000)
    }

    factory(named(PREF_AUDIO_BIT_RATE)) {
        get<RxkPrefs>().integer(PREF_AUDIO_BIT_RATE, 128_000)
    }

    // Recording
    factory(named(PREF_COUNTDOWN)) {
        get<RxkPrefs>().integer(PREF_COUNTDOWN, 3)
    }

    factory(named(PREF_RECORDINGS_FOLDER)) {
        val dcim = File("/sdcard/SC/")
//        dcim.mkdirs()
//        val dcim = getExternalStoragePublicDirectory(DIRECTORY_DCIM)
        val default = File(dcim, "SC")
        default.mkdir()
        get<RxkPrefs>().string(PREF_RECORDINGS_FOLDER, default.absolutePath)
    }

    factory(named(PREF_RECORD_AUDIO)) {
        get<RxkPrefs>().boolean(PREF_RECORD_AUDIO, false)
    }

    // Controls
    factory(named(PREF_STOP_ON_SCREEN_OFF)) {
        get<RxkPrefs>().boolean(PREF_STOP_ON_SCREEN_OFF, true)
    }

    factory(named(PREF_ALWAYS_SHOW_CONTROLS)) {
        get<RxkPrefs>().boolean(PREF_ALWAYS_SHOW_CONTROLS, false)
    }

    factory(named(PREF_STOP_ON_SHAKE)) {
        get<RxkPrefs>().boolean(PREF_STOP_ON_SHAKE, true)
    }
}

