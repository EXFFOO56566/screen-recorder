
package com.tochy.screenrecorder.capturescrn.captureoverlay

import android.annotation.SuppressLint
import android.graphics.PixelFormat.TRANSLUCENT
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.WindowManager
import android.view.WindowManager.LayoutParams
import android.view.WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
import android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
import android.view.WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
import android.view.WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY
import android.widget.TextView
import com.tochy.screenrecorder.utilcmnuse.forwords.inflateAs
import com.tochy.screenrecorder.utilcmnuse.provider.SdkProvider
import com.tochy.screenrecorder.capturescrn.R
import com.afollestad.rxkprefs.Pref

/** (@tochy) **/
interface OverlayManager {

  /**
   * Returns true if a countdown is in progress.
   */
  fun isCountingDown(): Boolean

  /**
   * Returns true if a countdown is configured when recording starts.
   */
  fun willCountdown(): Boolean

  /**
   * Counts down starting at the value of the countdown preference, showing a red number in the
   * middle of the screen for each second. The given [finished] callback is invoked when we reach 0.
   */
  fun countdown(finished: () -> Unit)
}

/** (@tochy) **/
class RealOverlayManager(
  private val windowManager: WindowManager,
  private val layoutInflater: LayoutInflater,
  private val countdownPref: Pref<Int>,
  private val sdkProvider: SdkProvider
) : OverlayManager {
  companion object {
    private const val SECOND = 1000L
  }

  private var isCountingDown: Boolean = false

  override fun isCountingDown() = isCountingDown

  override fun willCountdown() = countdownPref.get() > 0

  override fun countdown(finished: () -> Unit) {
    isCountingDown = true
    val time = countdownPref.get()
    if (time <= 0) {
      isCountingDown = false
      finished()
      return
    }

    val textView: TextView = layoutInflater.inflateAs(R.layout.countdown_now)
    textView.text = "$time"

    @Suppress("DEPRECATION")
    @SuppressLint("InlinedApi")
    val type = if (sdkProvider.hasAndroidO()) {
      TYPE_APPLICATION_OVERLAY
    } else {
      TYPE_SYSTEM_OVERLAY
    }
    val params = LayoutParams(
        WRAP_CONTENT, // width
        WRAP_CONTENT, // height
        type,
        FLAG_NOT_FOCUSABLE or FLAG_NOT_TOUCH_MODAL, // flags
        TRANSLUCENT // format
    )
    windowManager.addView(textView, params)

    nextCountdown(textView, time, finished)
  }

  private fun nextCountdown(
    view: TextView,
    nextSecond: Int,
    finished: () -> Unit
  ) {
    view.text = "$nextSecond"
    if (nextSecond == 0) {
      windowManager.removeView(view)
      isCountingDown = false
      finished()
      return
    }
    view.postDelayed({
      nextCountdown(view, nextSecond - 1, finished)
    }, SECOND)
  }
}
