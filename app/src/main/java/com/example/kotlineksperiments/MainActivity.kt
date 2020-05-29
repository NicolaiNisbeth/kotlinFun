package com.example.kotlineksperiments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = generateData(10)
        val adapter = ExampleAdapter(data)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

        adapter.setOnItemClickListener(object : ExampleAdapter.OnItemClickListener{
            val sheet = BottomSheet()
            override fun onItemClick(item: ExampleItem) {
                sheet.item = item
                sheet.show(supportFragmentManager, "dialog")
            }
        })
    }

    private fun generateData(size: Int): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size){
            list += ExampleItem("Headline $i", "Subtile $i")
        }
        return list
    }
}