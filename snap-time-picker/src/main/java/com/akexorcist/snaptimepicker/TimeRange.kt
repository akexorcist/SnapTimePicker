package com.akexorcist.snaptimepicker

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TimeRange(
    var start: TimeValue?,
    var end: TimeValue?
) : Parcelable
