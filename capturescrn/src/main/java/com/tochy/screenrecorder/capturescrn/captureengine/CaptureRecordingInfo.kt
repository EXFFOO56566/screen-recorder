
package com.tochy.screenrecorder.capturescrn.captureengine

import android.content.Context
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import com.tochy.screenrecorder.utilcmnuse.forwords.displayInfo
import com.tochy.screenrecorder.utilcmnuse.forwords.otherwise
import timber.log.Timber

internal data class RecordingInfo(
  val width: Int,
  val height: Int,
  val density: Int
)

internal fun RealCaptureEngine.getRecordingInfo(context: Context): RecordingInfo {
  val displayInfo = windowManager.displayInfo()
  val displayWidth = displayInfo.width
  val displayHeight = displayInfo.height

  val configuration = context.resources.configuration
  val isLandscape = configuration.orientation == ORIENTATION_LANDSCAPE
  log("Display: $displayWidth x $displayHeight, landscape: $isLandscape")

  val widthSetting = resolutionWidthPref.get()
      .otherwise(shouldReturn = displayWidth)
  val heightSetting = resolutionHeightPref.get()
      .otherwise(shouldReturn = displayHeight)
  log("Resolution setting: $widthSetting x $heightSetting")

  val frameWidth = if (isLandscape) heightSetting else widthSetting
  val frameHeight = if (isLandscape) widthSetting else heightSetting

  log("Final recording info: $frameWidth x $frameHeight @ ${displayInfo.density}")
  return RecordingInfo(
      width = frameWidth,
      height = frameHeight,
      density = displayInfo.density
  )
}

private fun log(message: String) {
  Timber.tag("CaptureRecordingInfo")
  Timber.d(message)
}
