package com.akexorcist.snaptimepicker

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TimeValue(
    var hour: Int,
    var minute: Int
) : Parcelable