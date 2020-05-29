package com.example.kotlineksperiments

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle

import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_dialog.view.*
import kotlinx.android.synthetic.main.bottom_sheet_dialog.view.close_btn

class BottomSheet(private val item: ExampleItem) : BottomSheetDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        val view = View.inflate(context, R.layout.bottom_sheet_dialog, null)
        view.headline.text = item.headline
        view.subtitle.text = item.subtitle
        dialog.setContentView(view)

        view.root.layoutParams.height = getScreenHeight()

        val behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.peekHeight = getScreenHeight()

        view.close_btn.setOnClickListener{ behavior.state = BottomSheetBehavior.STATE_HIDDEN }

        return dialog
    }

    private fun getScreenHeight() =
        (Resources.getSystem().displayMetrics.heightPixels * 0.9).toInt()
}