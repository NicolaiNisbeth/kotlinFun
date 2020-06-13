package com.example.kotlineksperiments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipient.*

/**
 * A simple [Fragment] subclass.
 */
class ChooseRecipientFragment : Fragment() {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        next_btn.setOnClickListener { chooseRecipientElseToast() }
        cancel_btn.setOnClickListener { activity?.onBackPressed() }
    }

    private fun chooseRecipientElseToast() {
        val recipient = input_recipient.text.toString()
        if (recipient.isNotEmpty()){
            val bundle = bundleOf("recipient" to recipient)
            navController.navigate(R.id.specifyAmountFragment, bundle)
        } else {
            Toast.makeText(activity, "Enter an recipient", Toast.LENGTH_SHORT).show()
        }
    }
}
