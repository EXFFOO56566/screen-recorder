
package com.tochy.screenrecorder.main

import com.tochy.screenrecorder.capturescrn.captureservice.BackgroundService.Companion.MAIN_ACTIVITY_CLASS
import com.tochy.screenrecorder.uiterfacec.mainactivities.MainActivity
import org.koin.core.qualifier.named
import org.koin.dsl.module


val mainModule = module {

  single<Class<*>>(named(MAIN_ACTIVITY_CLASS)) { MainActivity::class.java }
}
