package com.bocweb.otis.ui.aeeb.speed

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.bocweb.otis.util.dp2px

class BlueView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint by lazy { Paint() }

    init {
        paint.apply {
            isAntiAlias = true
            color = Color.parseColor("#00AFED")
        }
    }

    private val anim by lazy { ValueAnimator.ofInt(0, 690) }

    fun startAnim() {
        anim.apply {
            addUpdateListener { animation ->
                if (animation.animatedValue is Int) {
                    height = (animation.animatedValue as Int).dp2px().toFloat()
                    invalidate()
                }
            }
            duration = 4000
            start()
        }
    }

    private var height = 0f

    override fun onDraw(canvas: Canvas) {
        canvas.drawRoundRect(
            0f,
            0f,
            3.dp2px().toFloat(),
            height,
            2.dp2px().toFloat(),
            2.dp2px().toFloat(),
            paint
        )
    }
}