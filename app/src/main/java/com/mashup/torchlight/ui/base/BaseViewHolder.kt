
package com.mashup.torchlight.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(
    @LayoutRes layoutRes: Int, parent: ViewGroup?
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent?.context)
        .inflate(layoutRes, parent, false)
) {

    abstract fun onBindViewHolder(item: Any?)
}