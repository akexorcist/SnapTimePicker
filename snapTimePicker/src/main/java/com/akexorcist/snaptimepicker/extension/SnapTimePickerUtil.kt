package com.akexorcist.snaptimepicker.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

object SnapTimePickerUtil {
    fun observe(activity: FragmentActivity, onPickedEvent: (hour: Int, minute: Int) -> Unit): Unit =
        ViewModelProviders.of(activity).get(SnapTimePickerViewModel::class.java).timePickedEvent.observe(
            activity,
            Observer { event: TimePickedEvent ->
                onPickedEvent(
                    event.hour, event.minute
                )
            })

    fun observe(fragment: Fragment, onPickedEvent: (hour: Int, minute: Int) -> Unit): Unit =
        ViewModelProviders.of(fragment).get(SnapTimePickerViewModel::class.java).timePickedEvent.observe(
            fragment,
            Observer { event: TimePickedEvent ->
                onPickedEvent(
                    event.hour, event.minute
                )
            })
}