
package com.tochy.screenrecorder.main

import com.tochy.screenrecorder.utilcmnuse.Qualifiers.IO_DISPATCHER
import com.tochy.screenrecorder.utilcmnuse.Qualifiers.MAIN_DISPATCHER
import com.tochy.screenrecorder.utilcmnuse.prefrencies.PrefNames.PREF_ALWAYS_SHOW_CONTROLS
import com.tochy.screenrecorder.uiterfacec.mainactivities.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val viewModelModule = module {
  viewModel {
    MainViewModel(
        get(named(MAIN_DISPATCHER)),
        get(named(IO_DISPATCHER)),
        get(),
        get(),
        get(),
        get(),
        get(),
        get(),
        get(),
        get(named(PREF_ALWAYS_SHOW_CONTROLS))
    )
  }
}
