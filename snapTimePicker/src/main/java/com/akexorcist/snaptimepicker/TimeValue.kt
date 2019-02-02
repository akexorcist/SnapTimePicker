package com.akexorcist.snaptimepicker

import android.os.Parcel
import android.os.Parcelable

data class TimeValue(var hour: Int, var minute: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(hour)
        parcel.writeInt(minute)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TimeValue> {
        override fun createFromParcel(parcel: Parcel): TimeValue {
            return TimeValue(parcel)
        }

        override fun newArray(size: Int): Array<TimeValue?> {
            return arrayOfNulls(size)
        }
    }
}