
package com.tochy.screenrecorder.capturescrn.captureservice

import android.app.Dialog
import android.content.Context
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.callbacks.onCancel
import com.afollestad.materialdialogs.callbacks.onDismiss
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.tochy.screenrecorder.utilcmnuse.forwords.startActivity

const val KEY_ERROR = "error"


class ErrorDialog : DialogFragment() {

  companion object {
    private const val TAG = "[ErrorDialog]"

    fun show(
      context: FragmentActivity,
      error: Exception
    ) {
      val dialog = ErrorDialog()
      dialog.arguments = Bundle().apply { putSerializable(KEY_ERROR, error) }
      try {
        dialog.show(context.supportFragmentManager, TAG)
      } catch (e: IllegalStateException) {
        FirebaseCrashlytics.getInstance().log("Not showing ErrorDialog due to IllegalStateException.")
      }
    }
  }

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    val context = activity ?: blowUp()
    val error = arguments?.getSerializable(KEY_ERROR) as? java.lang.Exception ?: blowUp()
    val message = if (error.message.isNullOrEmpty()) "$error" else error.message

    return MaterialDialog(context)
        .title(text = "Error")
        .message(text = message)
        .positiveButton(android.R.string.ok)
        .onDismiss { dismiss() }
        .onCancel { dismiss() }
  }
}


class ErrorDialogActivity : AppCompatActivity() {
  companion object {
    fun show(
      context: Context,
      error: java.lang.Exception
    ) {
      FirebaseCrashlytics.getInstance().log("Showing ErrorDialogActivity for $error")
      if (error !is FileSystemException) {
        FirebaseCrashlytics.getInstance().log(error.toString())
      }
      context.startActivity<ErrorDialogActivity>(
          flags = FLAG_ACTIVITY_NEW_TASK,
          extras = Bundle().apply { putSerializable(KEY_ERROR, error) }
      )
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val exception = intent.getSerializableExtra(KEY_ERROR) as? java.lang.Exception ?: blowUp()
    ErrorDialog.show(this, exception)
  }
}

private fun <T> blowUp(): T {
  throw IllegalStateException("Oh no!")
}
