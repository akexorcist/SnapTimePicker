package com.akexorcist.snaptimepicker

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.snaptimepicker.databinding.LayoutSnapTimePickerNumberItemBinding

class TimeNumberViewHolder(
    private val binding: LayoutSnapTimePickerNumberItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun setNumber(number: String?) {
        binding.textViewNumber.text = number ?: "-"
    }
}
