
package com.tochy.screenrecorder.capturescrn.capturerecordings

import android.annotation.SuppressLint
import android.app.Application
import android.net.Uri
import android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
import com.afollestad.rxkprefs.Pref
import java.io.File

/**
 * Handles loading and deleting recordings.
 *
 * (@tochy)
 */
interface RecordingManager {

  /**
   * Gets a single recording from its content provider URI.
   */
  fun getRecording(uri: Uri): Recording?

  /**
   * Gets a list of saved recordings from the set recordings folder.
   */
  fun getRecordings(): List<Recording>

  /**
   * Deletes a recording's file and deletes the entry from the system content provider.
   */
  fun deleteRecording(recording: Recording)
}


@SuppressLint("Recycle")
class RealRecordingManager(
  app: Application,
  recordingsFolderPref: Pref<String>
) : RecordingManager {

  private val contentResolver = app.contentResolver
  private val recordingsBucket = File(recordingsFolderPref.get()).name

  override fun getRecording(uri: Uri): Recording? {
    val cursor = contentResolver.query(
        uri,
        null, // projection
        null, // selection
        null, // selectionArgs
        null // sortOrder
    ) ?: throw IllegalStateException()

    var result: Recording? = null
    if (cursor.moveToFirst()) {
      result = Recording.pull(cursor)
    }

    cursor.close()
    return result
  }

  override fun getRecordings(): List<Recording> {
    val cursor = contentResolver.query(
        EXTERNAL_CONTENT_URI, // uri
        null, // projection
        "bucket_display_name = ?", // selection
        arrayOf(recordingsBucket), // selectionArgs
        "date_added DESC" // sortOrder
    ) ?: throw RecordingManagerException("Unable to access $EXTERNAL_CONTENT_URI :(")

    return mutableListOf<Recording>().also { list ->
      if (cursor.moveToFirst()) {
        do {
          list.add(Recording.pull(cursor))
        } while (cursor.moveToNext())
      }
      cursor.close()
    }
  }

  override fun deleteRecording(recording: Recording) {
    File(recording.path).delete()
    contentResolver.delete(recording.toUri(), null, null)
  }
}

private class RecordingManagerException(msg: String) : Exception(msg)
