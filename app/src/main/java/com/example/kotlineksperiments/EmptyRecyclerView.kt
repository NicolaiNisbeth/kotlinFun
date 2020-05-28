package com.example.kotlineksperiments

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class EmptyRecyclerView : RecyclerView {
    private var emptyView : View? = null

    constructor(context: Context?) : super(context!!)
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context!!, attrs, defStyle)

    fun adjustView() {
        emptyView?.visibility = if (adapter?.itemCount == 0) View.VISIBLE else View.GONE
    }

    fun setEmptyView(emptyView: View?) {
        this.emptyView = emptyView
        adjustView()
    }

    private val observer: AdapterDataObserver = object : AdapterDataObserver() {
        override fun onChanged() {
            super.onChanged()
            adjustView()
        }
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        val oldAdapter = getAdapter()
        oldAdapter?.unregisterAdapterDataObserver(observer)
        super.setAdapter(adapter)
        adapter?.registerAdapterDataObserver(observer)
    }

    override fun swapAdapter(adapter: Adapter<*>?, removeAndRecycleExistingViews: Boolean) {
        val oldAdapter = getAdapter()
        oldAdapter?.unregisterAdapterDataObserver(observer)
        adapter?.registerAdapterDataObserver(observer)
        super.swapAdapter(adapter, removeAndRecycleExistingViews)
        adjustView()
    }
}
