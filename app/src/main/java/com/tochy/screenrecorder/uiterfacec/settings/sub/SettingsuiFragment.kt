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
import androidx.preference.SwitchPreference
import com.tochy.screenrecorder.R
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_DARK_MODE
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_DARK_MODE_AUTOMATIC
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_DARK_MODE_END
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_DARK_MODE_START
import com.tochy.screenrecorder.utilcmnuse.rxdata.attachLifecycle
import com.tochy.screenrecorder.uifile.splitTime
import com.tochy.screenrecorder.uiterfacec.settings.basesetting.MainBaseSettingsFragment
import com.tochy.screenrecorder.uiterfacec.settings.dialogsbox.TimeCallback
import com.tochy.screenrecorder.uiterfacec.settings.dialogsbox.TimePickerDialog
import com.afollestad.rxkprefs.Pref
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import java.text.DateFormat
import java.util.Calendar
import java.util.Calendar.HOUR_OF_DAY
import java.util.Calendar.MINUTE
import java.util.Locale


class SettingsUiFragment : MainBaseSettingsFragment(), TimeCallback {

  private val darkModePref by inject<Pref<Boolean>>(named(PREF_DARK_MODE))
  private val darkModeAutoPref by inject<Pref<Boolean>>(named(PREF_DARK_MODE_AUTOMATIC))
  private val darkModeStartPref by inject<Pref<String>>(named(PREF_DARK_MODE_START))
  private val darkModeEndPref by inject<Pref<String>>(named(PREF_DARK_MODE_END))

  override fun onCreatePreferences(
    savedInstanceState: Bundle?,
    rootKey: String?
  ) {
    setPreferencesFromResource(R.xml.settings_uinterface, rootKey)

    // Dark Mode
    val darkModeEntry = findPreference(PREF_DARK_MODE) as SwitchPreference
    darkModeEntry.setOnPreferenceChangeListener { _, newValue ->
      darkModePref.set(newValue as Boolean)
      settingsActivity.recreate()
      true
    }
    darkModePref.observe()
        .distinctUntilChanged()
        .subscribe { darkModeEntry.isChecked = it }
        .attachLifecycle(this)

    // Automatic
    val darkModeStartEntry = findPreference(PREF_DARK_MODE_START)
    val darkModeEndEntry = findPreference(PREF_DARK_MODE_END)

    val darkModeAutomaticEntry = findPreference(PREF_DARK_MODE_AUTOMATIC) as SwitchPreference
    darkModeAutomaticEntry.setOnPreferenceChangeListener { _, newValue ->
      if (newValue as Boolean) {
        darkModeEntry.isChecked = true
        darkModeEntry.isEnabled = false
      } else {
        darkModeEntry.isEnabled = true
      }
      darkModeAutoPref.set(newValue)
      true
    }
    darkModeAutoPref.observe()
        .distinctUntilChanged()
        .subscribe {
          darkModeAutomaticEntry.isChecked = it
          darkModeStartEntry.isVisible = it
          darkModeEndEntry.isVisible = it
        }
        .attachLifecycle(this)

    darkModeStartEntry.setOnPreferenceClickListener {
      TimePickerDialog.show(this, it.key, it.title)
      true
    }
    darkModeStartPref.observe()
        .subscribe {
          val formattedTime = timeFormatter().format(currentDateWithTime(it))
          darkModeStartEntry.summary =
            getString(R.string.setting_dark_mode_automatic_start_desc_setting, formattedTime)
        }
        .attachLifecycle(this)

    darkModeEndEntry.setOnPreferenceClickListener {
      TimePickerDialog.show(this, it.key, it.title)
      true
    }
    darkModeEndPref.observe()
        .subscribe {
          val formattedTime = timeFormatter().format(currentDateWithTime(it))
          darkModeEndEntry.summary =
            getString(R.string.setting_dark_mode_automatic_end_desc_setting, formattedTime)
        }
        .attachLifecycle(this)
  }

  override fun onTimeSelected(
    key: String,
    hour: Int,
    minute: Int
  ) {
    val pref by inject<Pref<String>>(named(key))
    pref.set("$hour:$minute")
  }
}

private fun currentDateWithTime(time: String) = Calendar.getInstance()
    .apply {
      val splitPref = time.splitTime()
      set(HOUR_OF_DAY, splitPref[0])
      set(MINUTE, splitPref[1])
    }.time

private fun timeFormatter() = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault())
