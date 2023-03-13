
package com.tochy.screenrecorder.capturescrn.captureengine

class FileSystemException(base: Exception) :
    Exception(
        "Screen Recorder was unable to access your file system. You may need to change your " +
            "recording folder in Screen Recorder's settings. ${base.displayMessage()}",
        base
    )

class PrepareFailedException(base: Throwable) :
    Exception(
        "Screen Recorder was unable to prepare for recording. ${base.displayMessage()}",
        base
    )

class StartRecordingException(base: Exception) :
    Exception(
        "Screen Recorder was unable to begin recording. ${base.displayMessage()}",
        base
    )

internal fun Throwable.displayMessage(): String {
  return if (!this.message.isNullOrBlank()) {
    this.message!!
  } else {
    "$this"
  }
}
