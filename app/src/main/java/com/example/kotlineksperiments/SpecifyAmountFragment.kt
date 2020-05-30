package com.example.kotlineksperiments

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_choose_recipient.cancel_btn
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal

@Parcelize
data class Money (val amount: BigDecimal) : Parcelable

class SpecifyAmountFragment : Fragment() {

    lateinit var navController: NavController
    private lateinit var recipientName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipientName = arguments?.getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val message = "Sending money to $recipientName"
        recipient.text = message

        send_btn.setOnClickListener { sendMoneyElseToast() }
        cancel_btn.setOnClickListener { activity?.onBackPressed() }
    }

    private fun sendMoneyElseToast() {
        val amount = input_amount.text.toString()
        if (amount.isNotEmpty()){
            val bundle = bundleOf(
                "recipient" to recipientName,
                "amount" to Money(BigDecimal(amount))
            )
            navController.navigate(R.id.confirmationFragment, bundle)
        } else {
            Toast.makeText(activity, "Enter an amount", Toast.LENGTH_SHORT).show()
        }
    }
}


