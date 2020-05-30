package com.example.kotlineksperiments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view_transactions_btn.setOnClickListener{ navController.navigate(R.id.viewTransactionFragment) }
        send_money_btn.setOnClickListener { navController.navigate(R.id.chooseRecipientFragment) }
        view_balance_btn.setOnClickListener { navController.navigate(R.id.viewBalanceFragment) }
    }

}
