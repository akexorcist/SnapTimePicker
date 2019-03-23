package com.akexorcist.snaptimepicker.extension

import androidx.lifecycle.ViewModel

class SnapTimePickerViewModel : ViewModel() {
    val timePickedEvent =
        TimePickedLiveData<TimePickedEvent>()

    fun onTimePicked(hour: Int, minute: Int) {
        timePickedEvent.value = TimePickedEvent(hour, minute)
    }
}
