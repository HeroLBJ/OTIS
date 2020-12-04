package com.bocweb.otis.util

import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.view.*
import com.bocweb.otis.app.app.App


/**
 * 获取屏幕的宽
 */
fun getScreenWidth(): Int {
    val wm = App.CONTEXT.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val point = Point()
    wm.defaultDisplay.getRealSize(point)
    return point.x
}

fun getScreenHeight(): Int {
    val wm = App.CONTEXT.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val point = Point()
    wm.defaultDisplay.getRealSize(point)
    return point.y
}

/**
 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
 */
fun Int.dp2px(): Int {
    return (0.5f + this * Resources.getSystem()
        .displayMetrics.density).toInt()
}

fun Int.sp2px(): Int {
    return (0.5f + this * Resources.getSystem()
        .displayMetrics.scaledDensity).toInt()
}

/**
 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
 */
fun Int.px2dp(): Float {
    return this / Resources.getSystem().displayMetrics.density
}

/**
 * 防止重复点击事件 默认0.5秒内不可重复点击 跳转前做登录校验
 * @param interval 时间间隔 默认0.5秒
 * @param action 执行方法
 */
var lastClickTime = 0L
fun View.setClickNoRepeat(interval: Long = 500, action: (view: View) -> Unit) {
    setOnClickListener {
        val currentTime = System.currentTimeMillis()
        if (lastClickTime != 0L && (currentTime - lastClickTime < interval)) {
            return@setOnClickListener
        }
        lastClickTime = currentTime
        action(it)
    }
}

/**
 * 获取是否有虚拟按键
 * 通过判断是否有物理返回键反向判断是否有虚拟按键
 * @param context
 * @return
 */
fun Context.checkDeviceHasNavigationBar(): Boolean {
    val hasMenuKey = ViewConfiguration.get(this)
        .hasPermanentMenuKey()
    val hasBackKey = KeyCharacterMap
        .deviceHasKey(KeyEvent.KEYCODE_BACK)
    return !hasMenuKey and !hasBackKey
}

//获取虚拟按键的高度
fun Context.getNavigationBarHeight(): Int {
    var result = 0
    if (checkDeviceHasNavigationBar()) {
        val res = this.resources
        val resourceId = res.getIdentifier("navigation_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = res.getDimensionPixelSize(resourceId)
        }
    }
    return result
}