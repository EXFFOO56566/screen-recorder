
package com.tochy.screenrecorder.views

import android.content.res.ColorStateList.valueOf
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.tochy.screenrecorder.utilcmnuse.livedata.distinct
import com.tochy.screenrecorder.utilcmnuse.view.showOrHide
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Emissions from the receiving LiveData are set as the [view]'s icon.
 */
fun LiveData<Int>.asIcon(
    owner: LifecycleOwner,
    view: FloatingActionButton
) = distinct().observe(owner, Observer { view.setImageResource(it) })


/**
 * Emissions from the receiving LiveData are set as the [view]'s background tint.
 */
fun LiveData<Int>.asBackgroundTint(
    owner: LifecycleOwner,
    view: FloatingActionButton
) = distinct().observe(owner, Observer {
    val actualColor = ContextCompat.getColor(view.context, it)
    view.backgroundTintList = valueOf(actualColor)
})

/**
 * Emissions from the receiving LiveData are set as the [view]'s text.
 */
fun LiveData<Int>.asText(
    owner: LifecycleOwner
//    view: FloatingActionButton
) = distinct().observe(owner, Observer {
//  view.setText(it)
}
)

/**
 * Emissions from the receiving LiveData are set as the [view]'s enabled state.
 */
fun LiveData<Boolean>.asEnabled(
    owner: LifecycleOwner,
    view: View
) = distinct().observe(owner, Observer { view.isEnabled = it })

/**
 * Emissions from the receiving LiveData are set as the [view]'s visibility (visible or gone).
 */
fun LiveData<Boolean>.asVisibility(
    owner: LifecycleOwner,
    view: View
) = distinct().observe(owner, Observer { view.showOrHide(it) })
