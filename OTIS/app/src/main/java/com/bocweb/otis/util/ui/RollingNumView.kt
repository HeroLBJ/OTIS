package com.bocweb.otis.util.ui

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.animation.AccelerateDecelerateInterpolator

/**
 * 高仿余额宝数字动画
 */
class RollingNumView(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatTextView(context, attrs) {
    //动画时长
    private val duration = 1000

    /**
     * 根据正则表达式，显示对应数字样式
     */
    var number = 0f
        set(number) {
            field = number
            text = String.format(regex!!, number)
        }

    //显示表达式
    private var regex: String? = null

    /**
     * 显示带有动画效果的数字
     */
    fun showNumberWithAnimation(number: Float, regex: String = INT_REGEX) {
        this.regex = regex
        //修改number属性，会调用setNumber方法
        val objectAnimator = ObjectAnimator.ofFloat(this, "number", 0f, number)
        objectAnimator.duration = duration.toLong()
        //加速器，从慢到快到再到慢
        objectAnimator.interpolator = AccelerateDecelerateInterpolator()
        objectAnimator.start()
    }

    companion object {
        //显示表示式
        const val INT_REGEX = "%1$01.0f" //不保留小数，整数
        const val FLOAT_REGEX = "%1$01.2f" //保留2位小数
    }
}