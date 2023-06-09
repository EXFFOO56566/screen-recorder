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
package com.tochy.screenrecorder.capturescrn.capturepermission

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.assent.Permission.WRITE_EXTERNAL_STORAGE
import com.afollestad.assent.askForPermissions
import com.tochy.screenrecorder.utilcmnuse.forwords.toast
import com.tochy.screenrecorder.capturescrn.R
import com.tochy.screenrecorder.capturescrn.captureservice.BackgroundService.Companion.PERMISSION_DENIED
import com.tochy.screenrecorder.capturescrn.captureservice.ServiceController
import org.koin.android.ext.android.inject


class StoragePermissionActivity : AppCompatActivity() {
  companion object {
    const val STORAGE_REQUEST = 98
  }

  private val serviceController by inject<ServiceController>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    askForPermissions(
        WRITE_EXTERNAL_STORAGE,
        requestCode = STORAGE_REQUEST,
        rationaleHandler = SCRationaleHandlera(this)
    ) { res ->
      if (!res.isAllGranted(WRITE_EXTERNAL_STORAGE)) {
        sendBroadcast(Intent(PERMISSION_DENIED))
        toast(R.string.permission_denied_note_capture)
      } else {
        serviceController.startRecording()
      }
      finish()
    }
  }
}
