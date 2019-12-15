package com.mashup.torchlight.ui.customview.itemselectorview

import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_item_selector_item.view.*

class ItemSelectorVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val bgShape = GradientDrawable()
    val removeShape = GradientDrawable()
    fun bind(data: ItemSelectorData,
             style: ItemSelectorStyle,
             onItemClicked: (id: Int) -> Unit,
             onRemoveClicked: (id: Int) -> Unit) {
        val tv = itemView.txt
        val img = itemView.img
        val remove = itemView.remove
        val wrapper = itemView.wrapper

        // Data set
        tv.text = data.name
        img.setImageDrawable(data.image)

        //Visibility. 1: TextOnly, 2: IconOnly, 3: Text+Icon
        tv.visibility = if (style.displayType and 1 > 0) View.VISIBLE else View.GONE
        img.visibility = if (style.displayType and 2 > 0) View.VISIBLE else View.GONE
        remove.visibility = if (style.isRemovable) View.VISIBLE else View.GONE

        // Text
        tv.setTextColor(if (data.isSelected) style.selectedTextColor else style.deselectedTextColor)
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, style.textSize.toFloat());

        // BG
        bgShape.setColor(if (data.isSelected) style.selectedColor else style.deselectedColor)
        bgShape.setStroke(style.borderThickness, style.borderColor)
        bgShape.cornerRadius = style.radius
        wrapper.background = bgShape

        // Remove
        remove.width = style.removeBtnSize
        remove.height = style.removeBtnSize
        removeShape.setColor((style.removeBtnBgColor))
        removeShape.setStroke(style.removeBtnBorderThickness, style.removeBtnBorderColor)
        removeShape.cornerRadius = style.removeBtnSize * 0.5f
        remove.background = removeShape
        remove.setTextColor(style.removeBtnXColor)
        remove.textSize = style.removeBtnSize * 0.3f

        // Layout Param
        val paramsWrapper = wrapper.layoutParams as ViewGroup.MarginLayoutParams
        paramsWrapper.setMargins(style.itemMargin)
        wrapper.layoutParams = paramsWrapper
        wrapper.setPadding(style.itemPadding)
        wrapper.gravity = Gravity.CENTER_VERTICAL

        // Click Listener
        itemView.setOnClickListener { onItemClicked(data.id) }
        remove.setOnClickListener { onRemoveClicked(data.id) }
    }
}