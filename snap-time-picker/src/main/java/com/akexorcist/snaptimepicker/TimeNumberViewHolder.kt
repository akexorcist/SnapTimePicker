package com.akexorcist.snaptimepicker

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_snap_time_picker_number_item.*

class TimeNumberViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun setNumber(number: String?) {
        textViewNumber?.text = number ?: "-"
    }
}