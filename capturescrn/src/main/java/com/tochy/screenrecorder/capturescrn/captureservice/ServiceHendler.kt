
package com.tochy.screenrecorder.capturescrn.captureservice

import android.app.Application
import android.content.Intent
import com.tochy.screenrecorder.notifictn.EXTRA_STOP_FOREGROUND
import com.tochy.screenrecorder.notifictn.RECORD_ACTION
import com.tochy.screenrecorder.notifictn.STOP_ACTION

/** (tochy) */
interface ServiceController {

  /**
   * Starts the background service and brings it into the foreground (show
   * a persistent notification which keeps it open).
   */
  fun startService()

  /**
   * Tells the service to start screen capture. If the service isn't already
   * running, it is started as well.
   */
  fun startRecording()

  /**
   * Tells the service to stop screen capture. If [stopService] is true,
   * the service is also stopped and brought out of the foreground.
   */
  fun stopRecording(stopService: Boolean = false)

  /**
   * Tells the service to exit, bringing it out of the foreground as well. Any active
   * capture will stop.
   */
  fun stopService()
}

/** (rdbrain) */
class RealServiceController(
  private val app: Application
) : ServiceController {

  override fun startService() {
    app.startService(Intent(app, BackgroundService::class.java))
  }

  override fun startRecording() {
    app.startService(Intent(app, BackgroundService::class.java).apply {
      action = RECORD_ACTION
    })
  }

  override fun stopRecording(stopService: Boolean) {
    app.sendBroadcast(Intent(STOP_ACTION).apply {
      putExtra(EXTRA_STOP_FOREGROUND, stopService)
    })
  }

  override fun stopService() = stopRecording(true)
}
