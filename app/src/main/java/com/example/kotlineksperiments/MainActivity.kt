package com.example.kotlineksperiments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = generateDummyData(0)

        recycler_view.adapter = ExampleAdapter(data)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
        recycler_view.setEmptyView(empty_view)

        fab_add.setOnClickListener {
            data.add(ExampleItem())
            (recycler_view.adapter as ExampleAdapter).notifyDataSetChanged()
        }

        fab_delete.setOnClickListener {
            if (data.isNotEmpty()) data.removeAt(data.lastIndex)
            (recycler_view.adapter as ExampleAdapter).notifyDataSetChanged()
        }
    }

    private fun generateDummyData(size : Int = 10) : ArrayList<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size){
            val item = ExampleItem("headline $i", "subtitle $i")
            list += item
        }
        return list
    }
}