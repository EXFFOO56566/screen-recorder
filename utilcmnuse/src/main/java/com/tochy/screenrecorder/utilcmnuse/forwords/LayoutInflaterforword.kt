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
package com.tochy.screenrecorder.utilcmnuse.forwords

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/** Inflates a layout and casts it to [T]. */
@Suppress("UNCHECKED_CAST")
fun <T : View> LayoutInflater.inflateAs(@LayoutRes res: Int, parent: ViewGroup? = null): T {
  return inflate(res, parent, false) as T
}
