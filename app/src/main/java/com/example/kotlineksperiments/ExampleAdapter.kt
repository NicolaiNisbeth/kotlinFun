package com.example.kotlineksperiments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*

class ExampleAdapter(private val exampleList : List<ExampleItem>) : RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {

    private var listener: OnItemClickListener? = null

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val headline: TextView = itemView.item_headline
        val subtitle: TextView = itemView.item_subtitle
        init {
            itemView.setOnClickListener{
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION)
                    listener?.onItemClick(exampleList[position])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.example_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = exampleList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.headline.text = currentItem.headline
        holder.subtitle.text = currentItem.subtitle
    }

    interface OnItemClickListener {
        fun onItemClick(item : ExampleItem)
    }

    fun setOnItemClickListener(listener : OnItemClickListener){
        this.listener = listener
    }
}

data class ExampleItem(val headline : String="default headline", val subtitle : String="default subtitle")