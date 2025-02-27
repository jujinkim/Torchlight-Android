package com.mashup.torchlight.ui.customview.itemselectorview

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
    var textSize: Int = 10,
    var itemMargin: Int = 0,
    var itemPadding: Int = 0,
    var isMultiSelectable: Boolean = false,
    var isRemovable: Boolean = false,
    var isAllDeselectable: Boolean = false,
    var maxSelectedCnt: Int = 3,
    var isScrollable: Boolean = true
)