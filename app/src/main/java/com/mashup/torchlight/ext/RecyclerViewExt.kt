package com.mashup.torchlight.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mashup.torchlight.adapter.BaseRecyclerViewAdapter

@BindingAdapter(value = ["replaceAll"])
fun RecyclerView.replaceAll(list: List<Any>?) {
    @Suppress("UNCHECKED_CAST")
    (this.adapter as? BaseRecyclerViewAdapter<Any, *>)?.let {
        it.replaceAll(list)
        it.notifyDataSetChanged()
    }
}