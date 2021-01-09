package com.akexorcist.snaptimepicker

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

abstract class BaseSnapTimePickerDialogFragment : DialogFragment() {

    lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let { bundle ->
            restoreInstanceState(bundle)
        } ?: run {
            restoreArgument(arguments)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val view = setupLayoutView()
        rootView = view
        builder.setView(view)
        val dialog = builder.create()
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        prepare()
        savedInstanceState?.let {
            restore()
        } ?: run {
            initialize()
        }
        setup()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveInstanceState(outState)
    }

    abstract fun setupLayoutView(): View

    abstract fun prepare()

    abstract fun restoreArgument(bundle: Bundle?)

    abstract fun initialize()

    abstract fun restoreInstanceState(savedInstanceState: Bundle?)

    abstract fun restore()

    abstract fun saveInstanceState(outState: Bundle?)

    abstract fun setup()
}
