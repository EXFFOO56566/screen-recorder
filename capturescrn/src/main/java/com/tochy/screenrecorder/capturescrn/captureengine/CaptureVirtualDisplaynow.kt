
package com.tochy.screenrecorder.capturescrn.captureengine

import android.content.Context
import android.hardware.display.DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR
import android.hardware.display.VirtualDisplay
import timber.log.Timber

internal fun RealCaptureEngine.createVirtualDisplayAndStart(context: Context) {
  display = createVirtualDisplay(context)

  // Tiny delay so we don't record the cast "start now" dialog.
  handler.postDelayed({
    try {
      log("createVirtualDisplayAndStart - recorder = $recorder")
      recorder?.start() ?: throw Exception(
          "Recorder is unexpectedly null, this appears to be a device-specific issue."
      )
    } catch (e: RuntimeException) {
      isStarted = false
      onCancel.onNext(Unit)
      onError.onNext(StartRecordingException(e))
    }
  }, 150)

  isStarted = true
  onStart.onNext(Unit)
  log("Media recorder started")
}

internal fun RealCaptureEngine.createVirtualDisplay(context: Context): VirtualDisplay {
  val recordingInfo = getRecordingInfo(context)
  log("createVirtualDisplay - recorder = $recorder")
  val engineRecorder = recorder ?: throw Exception(
      "Recorder is unexpectedly null, this appears to be a device-specific issue."
  )
  val surface = engineRecorder.surface ?: throw Exception(
      "Recorder Surface is unexpectedly null."
  )
  val width = recordingInfo.width
  val height = recordingInfo.height
  log("Virtual display dimensions: $width x $height")
  return projection?.createVirtualDisplay(
      "Screen RecorderCaptureEngine",
      width,
      height,
      recordingInfo.density,
      VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
      surface,
      null,
      null
  ) ?: throw Exception(
      "Projection unexpectedly null, this appears to be a device-specific issue."
  )
}

private fun log(message: String) {
  Timber.tag("CaptureVirtualDisplay")
  Timber.d(message)
}
