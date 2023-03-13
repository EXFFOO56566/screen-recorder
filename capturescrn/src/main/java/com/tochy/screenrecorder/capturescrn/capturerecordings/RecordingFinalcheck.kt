
package com.tochy.screenrecorder.capturescrn.capturerecordings

import android.app.Application
import android.media.MediaScannerConnection.scanFile
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.io.File
import timber.log.Timber.d as log

typealias RecordingCallback = ((Recording) -> Unit)?


interface RecordingScanner {

  /** A global callback observable that emits whenever a file is scanned. */
  fun onScan(): Observable<Recording>

  /**
   * Tells the system to scan a file and add it to the media content provider, optionally
   * invoking a callback when it's finished.
   */
  fun scan(
    file: File,
    cb: RecordingCallback = null
  )
}


class RealRecordingScanner(
  private val app: Application,
  private val recordingManager: RecordingManager
) : RecordingScanner {

  private var onScanSubject = PublishSubject.create<Recording>()

  override fun onScan(): Observable<Recording> = onScanSubject

  override fun scan(
    file: File,
    cb: RecordingCallback
  ) {
    log("Scanning $file...")
    scanFile(app, arrayOf(file.toString()), null) { _, resultUri ->
      val recording = recordingManager.getRecording(resultUri)
      if (recording == null) {
        log("Scanned uri: $resultUri, but unable to get the associated Recording!")
        return@scanFile
      }

      log("Scanned uri: $resultUri, recording = $recording")
      cb?.invoke(recording)
      onScanSubject.onNext(recording)
    }
  }
}
