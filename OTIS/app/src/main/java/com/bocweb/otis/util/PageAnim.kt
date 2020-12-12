package com.bocweb.otis.util

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import com.bocweb.otis.R

fun View.getCenterX(): Int {
    return right / 2 + left / 2
}

fun View.getCenterY(): Int {
    return top / 2 + bottom / 2
}

fun View.startPage(
    context: Activity,
    cls: Class<*>?,
    pointX: Int = 0,
    pointY: Int = 0
) {
    val intent = Intent(context, cls)
    intent.putExtra("X", if (pointX == 0) getCenterX() else pointX)
    intent.putExtra("Y", if (pointY == 0) getCenterY() else pointY)
    context.startActivity(intent)
}

fun View.startPageIndex(
    context: Activity,
    cls: Class<*>?,
    index: Int = 0,
    pointX: Int = 0,
    pointY: Int = 0
) {
    val intent = Intent(context, cls)
    intent.putExtra("X", if (pointX == 0) getCenterX() else pointX)
    intent.putExtra("Y", if (pointY == 0) getCenterY() else pointY)
    intent.putExtra("page", index)
    context.startActivity(intent)
}

// 从底部出来
fun Activity.startPageDownY(cls: Class<*>?, finish: Boolean = false) {
    runOnUiThread {
        val intent = Intent(this, cls)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_from_bottom, R.anim.slide_to_top)
        if (finish) finish()
    }
}

fun Activity.startPageUpY(cls: Class<*>?) {
    runOnUiThread {
        val intent = Intent(this, cls)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_to_top, R.anim.slide_from_bottom)
    }
}

fun View.startPageAnim(activity: Activity) {
    visibility = View.INVISIBLE
    post {
        val x = activity.intent.getIntExtra("X", 0)
        val y = activity.intent.getIntExtra("Y", 0)
        val startRadius = 0f
        val endRadius = getScreenHeight().toFloat()
        val anim = ViewAnimationUtils.createCircularReveal(rootView, x, y, startRadius, endRadius)
        anim.duration = 1000
        anim.interpolator = AccelerateDecelerateInterpolator()
        anim.doOnStart { visibility = View.VISIBLE }
        anim.start()
    }
}

fun View.finishPage(activity: Activity) {
    val x = activity.intent.getIntExtra("X", 0)
    val y = activity.intent.getIntExtra("Y", 0)
    val startRadius = getScreenHeight().toFloat()
    val endRadius = 0f
    val anim = ViewAnimationUtils.createCircularReveal(rootView, x, y, startRadius, endRadius)
    anim.duration = 1000
    anim.interpolator = AccelerateDecelerateInterpolator()
    anim.doOnEnd {
        alpha = 0f
        visibility = View.GONE
        activity.finish()
    }
    anim.start()
}