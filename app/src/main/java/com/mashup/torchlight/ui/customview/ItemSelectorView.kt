package com.mashup.torchlight.ui.customview

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.mashup.torchlight.R
import kotlinx.android.synthetic.main.view_item_selector_item.view.*

class ItemSelectorView: RecyclerView {

    private var displayStyle = ItemSelectorStyle()
    private lateinit var itemSelectorAdapter: ItemSelectorAdapter

    constructor(context: Context) : super(context) { init(null) }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) { init(attrs) }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) { init(attrs) }

    private fun init(attrs: AttributeSet?) {
        loadAttrs(attrs)

        if (displayStyle.isScrollable) {
            super.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false))
        } else {
            super.setLayoutManager(FlexboxLayoutManager(context, FlexDirection.ROW, FlexWrap.WRAP))
        }

        // create / set adapter
        itemSelectorAdapter = ItemSelectorAdapter(displayStyle)
        super.setAdapter(itemSelectorAdapter)
    }

    private fun loadAttrs(attrs: AttributeSet?) {
        val attrTypedArr = context.obtainStyledAttributes(attrs, R.styleable.ItemSelectorView)
        val primaryColor = context.resources.getColor(R.color.colorPrimary)
        val whiteColor = Color.WHITE
        val accentColor = context.resources.getColor(R.color.colorAccent)
        with(displayStyle) {
            isMultiSelectable = attrTypedArr.getBoolean(R.styleable.ItemSelectorView_multi_selectable, false)
            isRemovable = attrTypedArr.getBoolean(R.styleable.ItemSelectorView_removable, false)
            isAllDeselectable = attrTypedArr.getBoolean(R.styleable.ItemSelectorView_all_deselectable, false)
            maxSelectedCnt = attrTypedArr.getInt(R.styleable.ItemSelectorView_max_select_count, 0)
            isScrollable = attrTypedArr.getBoolean(R.styleable.ItemSelectorView_scrollable, true)
            displayType = attrTypedArr.getInt(R.styleable.ItemSelectorView_display_type, 1)
            borderThickness = attrTypedArr.getInt(R.styleable.ItemSelectorView_border_thickness, 2)
            radius = attrTypedArr.getFloat(R.styleable.ItemSelectorView_radius, 20f)
            removeBtnSize = attrTypedArr.getDimensionPixelSize(R.styleable.ItemSelectorView_remove_btn_size, 65)
            textSize = attrTypedArr.getDimension(R.styleable.ItemSelectorView_text_size, 20f)
            itemMargin = attrTypedArr.getInt(R.styleable.ItemSelectorView_item_margin, 30)
            itemPadding = attrTypedArr.getInt(R.styleable.ItemSelectorView_item_padding, 30)
            selectedColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_selected_color, primaryColor)
            deselectedColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_deselected_color, whiteColor)
            selectedTextColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_selected_text_color, whiteColor)
            deselectedTextColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_deselected_text_color, primaryColor)
            borderColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_border_color, primaryColor)
            removeBtnBgColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_remove_btn_bg_color, accentColor)
            removeBtnXColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_remove_btn_x_color, whiteColor)
            removeBtnBorderColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_remove_btn_border_color, accentColor)
            removeBtnBorderThickness = attrTypedArr.getInt(R.styleable.ItemSelectorView_remove_btn_border_thickness, 2)
        }
        attrTypedArr.recycle()
    }

    fun setItemList(dataList: List<ItemSelectorData>) =
        itemSelectorAdapter.setItemList(dataList)

    fun addItem(data: ItemSelectorData) =
        itemSelectorAdapter.addItem(data)

    fun addItem(idx: Int, data: ItemSelectorData) =
        itemSelectorAdapter.addItem(idx, data)

    fun removeItem(idx: Int) =
        itemSelectorAdapter.removeItem(idx)

    fun removeItemById(Id: Int) =
        itemSelectorAdapter.removeItemById(id)

    fun clearItems() =
        itemSelectorAdapter.clearItems()

    fun getItemCount(): Int =
        itemSelectorAdapter.itemCount

    fun getSelectedItemCount(): Int =
        itemSelectorAdapter.getSelectedItemCount()

    fun getSelectedItemList(): ArrayList<ItemSelectorData> =
        itemSelectorAdapter.getSelectedItems()

    fun getItemList(): ArrayList<ItemSelectorData> =
        itemSelectorAdapter.itemList

    @Deprecated("Adapter is handled in the view itself!", ReplaceWith("nothing"), DeprecationLevel.HIDDEN)
    override fun setAdapter(adapter: Adapter<*>?) {
        throw UnsupportedOperationException("Adapter is handled in ItemSelectorView itself!")
    }

    @Deprecated("LayoutManager is handled in the view itself!", ReplaceWith("nothing"), DeprecationLevel.HIDDEN)
    override fun setLayoutManager(layout: LayoutManager?) {
        throw UnsupportedOperationException("LayoutManager is handled in ItemSelectorView itself!")
    }
}

data class ItemSelectorData(
    val id: Int,
    var name: String,
    var image: Drawable?,
    var isSelected: Boolean = false
)

data class ItemSelectorStyle(
    var selectedColor: Int = 0,
    var deselectedColor: Int = 0,
    var selectedTextColor: Int = 0,
    var deselectedTextColor: Int = 0,
    var displayType: Int = 0,
    var borderColor: Int = 0,
    var borderThickness: Int = 0,
    var radius: Float = 0f,
    var removeBtnBgColor: Int = 0,
    var removeBtnXColor: Int = 0,
    var removeBtnBorderColor: Int = 0,
    var removeBtnBorderThickness: Int = 0,
    var removeBtnSize: Int = 0,
    var textSize: Float = 10f,
    var itemMargin: Int = 0,
    var itemPadding: Int = 0,
    var isMultiSelectable: Boolean = false,
    var isRemovable: Boolean = false,
    var isAllDeselectable: Boolean = false,
    var maxSelectedCnt: Int = 3,
    var isScrollable: Boolean = true
)

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
        tv.textSize = style.textSize

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

        // Layout Param
        val paramsWrapper = wrapper.layoutParams as ViewGroup.MarginLayoutParams
        paramsWrapper.setMargins(style.itemMargin)
        wrapper.layoutParams = paramsWrapper
        wrapper.setPadding(style.itemPadding)

        // Click Listener
        itemView.setOnClickListener { onItemClicked(data.id) }
        remove.setOnClickListener { onRemoveClicked(data.id) }
    }
}

class ItemSelectorAdapter(private var style: ItemSelectorStyle) : RecyclerView.Adapter<ItemSelectorVH>() {
    val itemList: ArrayList<ItemSelectorData> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSelectorVH {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.view_item_selector_item, parent, false)
        return ItemSelectorVH(view)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ItemSelectorVH, position: Int) {
        holder.bind(
            itemList[position],
            style,
            ::toggleItemSelectedById,
            ::removeItemById)
    }

    fun getSelectedItemCount(): Int = itemList.count { x -> x.isSelected }
    fun getSelectedItems(): ArrayList<ItemSelectorData> =
        itemList.filter { x -> x.isSelected } as ArrayList<ItemSelectorData>

    fun setItemList(dataList: List<ItemSelectorData>) {
        itemList.clear()
        for(data: ItemSelectorData in dataList) {
            itemList.add(data)
        }
        notifyDataSetChanged()
    }

    fun addItem(data: ItemSelectorData) {
        itemList.add(data)
        notifyItemInserted(itemList.size - 1)
    }
    fun addItem(idx: Int, data: ItemSelectorData) {
        itemList.add(idx, data)
        notifyItemInserted(idx)
    }

    fun removeItem(idx: Int) {
        itemList.removeAt(idx)
        notifyItemRemoved(idx)
    }
    fun removeItem(data: ItemSelectorData) {
        val idx = itemList.indexOf(data)
        removeItem(idx)
    }
    fun removeItemById(id: Int) {
        val idx = itemList.indexOfFirst { x -> x.id == id  }
        removeItem(idx)
    }

    fun clearItems() {
        itemList.clear()
        notifyDataSetChanged()
    }

    fun setItemSelected(idx: Int, selected: Boolean) {
        if (selected) {
            if (style.maxSelectedCnt > 0
                && getSelectedItemCount() >= style.maxSelectedCnt) {
                return
            }

            if (!style.isMultiSelectable) {
                for (data: ItemSelectorData in itemList) {
                    data.isSelected = false
                }
            }

            itemList[idx].isSelected = true

            if (!style.isMultiSelectable) {
                notifyItemRangeChanged(0, itemCount)
            } else {
                notifyItemChanged(idx)
            }
        } else {
            if (style.isAllDeselectable && getSelectedItemCount() == 0) {
                return
            } else {
                itemList[idx].isSelected = false
                notifyItemChanged(idx)
            }
        }
    }
    fun setItemSelectedById(id: Int, selected: Boolean) {
        val idx = itemList.indexOfFirst { x -> x.id == id  }
        setItemSelected(idx, selected)
    }

    fun toggleItemSelected(idx: Int) {
        val item = itemList[idx]
        setItemSelected(idx, !item.isSelected)
    }
    fun toggleItemSelectedById(id: Int) {
        val idx = itemList.indexOfFirst { x -> x.id == id  }
        toggleItemSelected(idx)
    }
}