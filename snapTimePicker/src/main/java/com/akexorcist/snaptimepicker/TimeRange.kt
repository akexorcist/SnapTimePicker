package com.akexorcist.snaptimepicker

import android.os.Parcel
import android.os.Parcelable

data class TimeRange(var start: TimeValue?, var end: TimeValue?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readParcelable(TimeValue::class.java.classLoader),
            parcel.readParcelable(TimeValue::class.java.classLoader))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(start, flags)
        parcel.writeParcelable(end, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TimeRange> {
        override fun createFromParcel(parcel: Parcel): TimeRange {
            return TimeRange(parcel)
        }

        override fun newArray(size: Int): Array<TimeRange?> {
            return arrayOfNulls(size)
        }
    }
}