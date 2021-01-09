package com.akexorcist.snaptimepicker.extension

import android.os.Parcel
import android.os.Parcelable

data class TimePickedEvent(val hour: Int, val minute: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(hour)
        parcel.writeInt(minute)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TimePickedEvent> {
        override fun createFromParcel(parcel: Parcel): TimePickedEvent {
            return TimePickedEvent(parcel)
        }

        override fun newArray(size: Int): Array<TimePickedEvent?> {
            return arrayOfNulls(size)
        }
    }
}
