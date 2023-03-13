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
package com.tochy.screenrecorder.uiterfacec.settings.sub

import android.os.Bundle
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import com.tochy.screenrecorder.R
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_AUDIO_BIT_RATE
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_FRAME_RATE
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_RECORD_AUDIO
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_VIDEO_BIT_RATE
import com.tochy.screenrecorder.utilcmnuse.rxdata.attachLifecycle
import com.tochy.screenrecorder.uiterfacec.settings.basesetting.MainBaseSettingsFragment
import com.tochy.screenrecorder.uiterfacec.settings.bitRateString
import com.afollestad.rxkprefs.Pref
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named


class SettingsQualitysFragment : MainBaseSettingsFragment() {

    private val frameRatePref by inject<Pref<Int>>(named(PREF_FRAME_RATE))

    // private val resolutionWidthPref by inject<Pref<Int>>(named(PREF_RESOLUTION_WIDTH))
    // private val resolutionHeightPref by inject<Pref<Int>>(named(PREF_RESOLUTION_HEIGHT))
    private val videoBitRatePref by inject<Pref<Int>>(named(PREF_VIDEO_BIT_RATE))
    private val audioBitRatePref by inject<Pref<Int>>(named(PREF_AUDIO_BIT_RATE))
    private val recordAudioPref by inject<Pref<Boolean>>(named(PREF_RECORD_AUDIO))

    override fun onCreatePreferences(
        savedInstanceState: Bundle?,
        rootKey: String?
    ) {
        setPreferencesFromResource(R.xml.settings_qualitya, rootKey)

        setupFrameRatePref()
        setupResolutionPref()
        setupVideoBitRatePref()
        setupAudioBitRatePref()
    }

    private fun setupFrameRatePref() {
        val frameRateEntry = findPreference(PREF_FRAME_RATE)
        frameRateEntry.setOnPreferenceClickListener {
            val rawValues = resources.getIntArray(R.array.frame_rate_values_in)
            val currentValue = frameRatePref.get()
            val defaultIndex = rawValues.indexOf(currentValue)

            MaterialDialog(settingsActivity).show {
                title(R.string.setting_framerate_q)
                listItemsSingleChoice(
                    res = R.array.frame_rate_options_infps,
                    initialSelection = defaultIndex
                ) { _, which, _ ->
                    frameRatePref.set(rawValues[which])
                }
                positiveButton(R.string.select)
            }
            true
        }
        frameRatePref.observe()
            .distinctUntilChanged()
            .subscribe {
                frameRateEntry.summary = getString(R.string.setting_framerate_desc_q, it)
            }
            .attachLifecycle(this)
    }

    private fun setupResolutionPref() {
        val resolutionEntry = findPreference("resolution")
        resolutionEntry.isEnabled = false
        resolutionEntry.summary =
            ""

        /*
        resolutionEntry.setOnPreferenceClickListener {
          val context = activity ?: return@setOnPreferenceClickListener true
          val options = windowManager.resolutionSettings(context)
              .map { size -> size.toString() }
              .toMutableList()
              .apply { add(0, getString(R.string.use_screen_resolution)) }

          val currentXByY = "${resolutionWidthPref.get()}x${resolutionHeightPref.get()}"
          val defaultIndex = options.indexOf(currentXByY)
              .otherwise(-1, 0)

          MaterialDialog(context).show {
            title(R.string.setting_resolution)
            listItemsSingleChoice(
                items = options,
                initialSelection = defaultIndex
            ) { _, which, text ->
              if (which == 0) {
                resolutionWidthPref.delete()
                resolutionHeightPref.delete()
              } else {
                val splitRes = text.split('x')
                resolutionWidthPref.set(splitRes[0].toInt())
                resolutionHeightPref.set(splitRes[1].toInt())
              }
            }
            positiveButton(R.string.select)
          }
          true
        }
        zip(resolutionWidthPref.observe(), resolutionHeightPref.observe(),
            BiFunction<Int, Int, Pair<Int, Int>> { w, h -> Pair(w, h) })
            .subscribe {
              if (it.first == 0 || it.second == 0) {
                resolutionEntry.summary =
                    resources.getString(R.string.setting_resolution_current_screen)
              } else {
                resolutionEntry.summary = resources.getString(
                    R.string.setting_resolution_desc, it.first, it.second
                )
              }
            }
            .attachLifecycle(this)
        */
    }

    private fun setupVideoBitRatePref() {
        val videoBitRateEntry = findPreference(PREF_VIDEO_BIT_RATE)
        videoBitRateEntry.setOnPreferenceClickListener {
            val rawValues = resources.getIntArray(R.array.bit_rate_values_sa)
            val currentValue = videoBitRatePref.get()
            val defaultIndex = rawValues.indexOf(currentValue)

            MaterialDialog(settingsActivity).show {
                title(R.string.setting_bitrate_q)
                listItemsSingleChoice(
                    res = R.array.bit_rate_options_sa,
                    initialSelection = defaultIndex
                ) { _, which, _ ->
                    videoBitRatePref.set(rawValues[which])
                }
                positiveButton(R.string.select)
            }
            true
        }
        videoBitRatePref.observe()
            .distinctUntilChanged()
            .subscribe {
                videoBitRateEntry.summary =
                    getString(R.string.setting_bitrate_desc_q, it.bitRateString())
            }
            .attachLifecycle(this)
    }

    private fun setupAudioBitRatePref() {
        val audioBitRateEntry = findPreference(PREF_AUDIO_BIT_RATE)
        audioBitRateEntry.isVisible = recordAudioPref.get()

        audioBitRateEntry.setOnPreferenceClickListener {
            val context = activity ?: return@setOnPreferenceClickListener false
            val rawValues = resources.getIntArray(R.array.audio_bit_rate_values_sa)
            val currentValue = audioBitRatePref.get()
            val defaultIndex = rawValues.indexOf(currentValue)

            MaterialDialog(context).show {
                title(R.string.setting_audio_bitrate_q)
                listItemsSingleChoice(
                    res = R.array.audio_bit_rate_options_sa,
                    initialSelection = defaultIndex
                ) { _, which, _ ->
                    audioBitRatePref.set(rawValues[which])
                }
                positiveButton(R.string.select)
            }
            true
        }
        audioBitRatePref.observe()
            .distinctUntilChanged()
            .subscribe {
                audioBitRateEntry.summary =
                    getString(R.string.setting_audio_bitrate_desc_q, it.bitRateString())
            }
            .attachLifecycle(this)
    }
}
