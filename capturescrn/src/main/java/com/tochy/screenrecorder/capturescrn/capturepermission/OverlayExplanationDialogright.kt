
package com.tochy.screenrecorder.capturescrn.capturepermission

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.callbacks.onCancel
import com.afollestad.materialdialogs.callbacks.onDismiss
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.tochy.screenrecorder.capturescrn.R
import java.lang.reflect.InvocationTargetException

interface OverlayExplanationCallback {

  fun onShouldAskForOverlayPermission()
}


class OverlayExplanationDialog : DialogFragment() {

  companion object {
    private const val TAG = "[OverlayExplanationDialog]"

    fun <T> show(context: T) where T : FragmentActivity, T : OverlayExplanationCallback {
      val dialog = OverlayExplanationDialog()
      try {
        dialog.show(context.supportFragmentManager, TAG)
      } catch (_: java.lang.IllegalStateException) {
          FirebaseCrashlytics.getInstance().log("Not showing OverlayExplanationDialog due to IllegalStateException.")

      }
    }

    fun <T> show(context: T) where T : Fragment, T : OverlayExplanationCallback {
      val dialog = OverlayExplanationDialog()
      try {
        dialog.show(context.childFragmentManager, TAG)
      } catch (_: java.lang.IllegalStateException) {
          FirebaseCrashlytics.getInstance().log("Not showing OverlayExplanationDialog due to IllegalStateException.")
      }
    }
  }

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    val context = activity ?: throw IllegalStateException("Oh no!")
    var callback = context as? OverlayExplanationCallback
    if (callback == null) {
      callback = parentFragment as? OverlayExplanationCallback ?: throw IllegalStateException(
          "Couldn't find callback from Activity or parent Fragment."
      )
    }

    try {
      return MaterialDialog(context)
          .title(R.string.overlay_permission_prompt_capture)
          .message(R.string.overlay_permission_prompt__dcapture)
          .cancelOnTouchOutside(false)
          .positiveButton(R.string.okay) {
            dismiss()
            callback.onShouldAskForOverlayPermission()
          }
          .onDismiss { dismiss() }
          .onCancel { dismiss() }
    } catch (e: InvocationTargetException) {
      // Workaround for Samsung/Huawei bug with AndroidX font retrieval.
      return AlertDialog.Builder(context)
          .setTitle(R.string.overlay_permission_prompt_capture)
          .setMessage(R.string.overlay_permission_prompt__dcapture)
          .setPositiveButton(R.string.okay) { _, _ ->
            dismiss()
            callback.onShouldAskForOverlayPermission()
          }
          .setOnCancelListener { dismiss() }
          .setOnDismissListener { dismiss() }
          .create()
    }
  }

  override fun onCancel(dialog: DialogInterface?) {
    super.onCancel(dialog)
    val callback = activity as? OverlayExplanationCallback ?: return
    callback.onShouldAskForOverlayPermission()
  }
}
