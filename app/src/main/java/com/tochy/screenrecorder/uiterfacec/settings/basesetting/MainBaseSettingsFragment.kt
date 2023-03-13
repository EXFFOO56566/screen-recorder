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
package com.tochy.screenrecorder.uiterfacec.settings.basesetting

import android.os.Bundle
import android.view.View
import androidx.preference.PreferenceFragmentCompat
import com.afollestad.materialdialogs.utils.MDUtil.resolveColor
import com.tochy.screenrecorder.utilcmnuse.view.onScroll
import com.tochy.screenrecorder.uiterfacec.settings.SettingsActivitymain


abstract class MainBaseSettingsFragment : PreferenceFragmentCompat() {

  protected val settingsActivity: SettingsActivitymain
    get() {
      return activity as? SettingsActivitymain ?: throw IllegalStateException("Not attached!")
    }
  open val isRoot: Boolean = false

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    view.setBackgroundColor(resolveColor(settingsActivity, attr = android.R.attr.windowBackground))

    settingsActivity.setIsInRoot(isRoot)
    listView.onScroll { settingsActivity.invalidateToolbarElevation(it) }
  }

  override fun onResume() {
    super.onResume()
    settingsActivity.run {
      setIsInRoot(isRoot)
      invalidateToolbarElevation(listView.computeVerticalScrollOffset())
    }
  }
}
