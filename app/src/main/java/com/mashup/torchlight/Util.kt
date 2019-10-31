package com.mashup.torchlight

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics

object Util {

    // <editor-fold defaultstate="collapsed" desc="Display width/height">
    private val dm = DisplayMetrics()
    fun getDisplayWidthPx(activity: Activity) : Int {
        activity.windowManager.defaultDisplay.getMetrics(dm)
        return dm.widthPixels
    }

    fun getDisplayHeightPx(activity: Activity) : Int {
        activity.windowManager.defaultDisplay.getMetrics(dm)
        return dm.heightPixels
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="dp2px, px2dp">
    fun dp2px(context: Context, dp: Float) : Int {
        val scale = context.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }

    fun px2dp(context: Context, px: Int) : Float {
        val scale = context.resources.displayMetrics.density
        return (px / scale + 0.5f)
    }
    // </editor-fold>

}