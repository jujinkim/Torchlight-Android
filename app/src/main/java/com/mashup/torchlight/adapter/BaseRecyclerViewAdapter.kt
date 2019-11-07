
package com.mashup.torchlight.adapter

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mashup.torchlight.ui.base.BaseBindingViewHolder

abstract class BaseRecyclerViewAdapter<ITEM : Any, B : ViewDataBinding>(
    @LayoutRes private val layoutRes: Int,
    private val bindingVariableId: Int? = null
) : RecyclerView.Adapter<BaseBindingViewHolder<B>>() {

    private val items = mutableListOf<ITEM>()

    fun replaceAll(items: List<ITEM>?) {
        items?.let {
            this.items.run {
                clear()
                addAll(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            object : BaseBindingViewHolder<B>(
                    layoutRes = layoutRes,
                    parent = parent,
                    bindingId = bindingVariableId) {}

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseBindingViewHolder<B>, position: Int) {
        holder.onBindViewHolder(items[position])
    }
}