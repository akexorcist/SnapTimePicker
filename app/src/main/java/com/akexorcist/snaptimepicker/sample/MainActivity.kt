package com.akexorcist.snaptimepicker.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.akexorcist.snaptimepicker.SnapTimePickerDialog
import com.akexorcist.snaptimepicker.TimeRange
import com.akexorcist.snaptimepicker.TimeValue
import com.akexorcist.snaptimepicker.extension.SnapTimePickerUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNoCustomTimePicker.setOnClickListener {
            // No custom time picker
            SnapTimePickerDialog.Builder().apply {
                setTitle(R.string.title)
                setTitleColor(R.color.colorWhite)}.build().apply {
                setListener { hour, minute -> onTimePicked(hour, minute) }
            }.show(supportFragmentManager, SnapTimePickerDialog.TAG)
        }

        buttonFullCustomTimePicker.setOnClickListener {
            // Custom text and color
            SnapTimePickerDialog.Builder().apply {
                setTitle(R.string.title)
                setPrefix(R.string.time_prefix)
                setSuffix(R.string.time_suffix)
                setThemeColor(R.color.colorAccent)
                setTitleColor(R.color.colorWhite)
            }.build().apply {
                setListener { hour, minute -> onTimePicked(hour, minute) }
            }.show(supportFragmentManager, SnapTimePickerDialog.TAG)
        }

        buttonPreselectedTime.setOnClickListener {
            // Set pre-selected time
            SnapTimePickerDialog.Builder().apply {
                setPreselectedTime(TimeValue(2, 15))
            }.build().apply {
                setListener { hour, minute -> onTimePicked(hour, minute) }
            }.show(supportFragmentManager, SnapTimePickerDialog.TAG)
        }

        buttonTimeRange.setOnClickListener {
            // Set selectable time range
            SnapTimePickerDialog.Builder().apply {
                val start = TimeValue(2, 15)
                val end = TimeValue(14, 30)
                setSelectableTimeRange(TimeRange(start, end))
            }.build().apply {
                setListener { hour, minute -> onTimePicked(hour, minute) }
            }.show(supportFragmentManager, SnapTimePickerDialog.TAG)
        }

        buttonTimeInterval.setOnClickListener {
            SnapTimePickerDialog.Builder().apply {
                setTimeInterval(7)
                setTitle(R.string.title)
                setTitleColor(R.color.colorWhite)}.build().apply {
                setListener { hour, minute -> onTimePicked(hour, minute) }
            }.show(supportFragmentManager, SnapTimePickerDialog.TAG)
        }

        buttonViewModelCallback.setOnClickListener {
            // Get event callback from ViewModel observing. No need listener
            //
            // This very useful when you use ViewModel. Although user do
            // something that make configuration changes occur, you still get
            // event callback from LiveData.
            //
            // See how can you get event callback from ViewModel at line 73.
            SnapTimePickerDialog.Builder().apply {
                useViewModel()
            }.build().show(supportFragmentManager, SnapTimePickerDialog.TAG)
        }

        // This code is work with `useViewModel()` at line 68
        SnapTimePickerUtil.observe(this) { selectedHour: Int, selectedMinute: Int ->
            onTimePicked(selectedHour, selectedMinute)
        }
    }

    private fun onTimePicked(selectedHour: Int, selectedMinute: Int) {
        val hour = selectedHour.toString().padStart(2, '0')
        val minute = selectedMinute.toString().padStart(2, '0')
        textViewTime.text = String.format(getString(R.string.selected_time_format, hour, minute))
    }
}
