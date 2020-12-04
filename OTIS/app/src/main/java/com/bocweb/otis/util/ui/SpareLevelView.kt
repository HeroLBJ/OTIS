package com.bocweb.otis.util.ui

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.bocweb.otis.util.dp2px
import com.bocweb.otis.util.sp2px

class SpareLevelView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val mPaint by lazy {
        Paint().also {
            it.isAntiAlias = true
        }
    }

    private val mTextPaint by lazy {
        Paint().also {
            it.isAntiAlias = true
            it.color = Color.WHITE
            it.textSize = 8.sp2px().toFloat()
            it.textAlign = Paint.Align.CENTER
        }
    }

    private var anim: ValueAnimator? = null

    fun startAnim() {
        anim = ValueAnimator.ofInt(0, 70)
        anim?.apply {
            addUpdateListener { animation ->
                if (animation.animatedValue is Int) {
                    aWidth = (animation.animatedValue as Int).dp2px().toFloat()
                    invalidate()
                }

            }
            duration = 1000
            start()
        }
    }

    // 每个图形的高度
    private var mHeight = 11.dp2px().toFloat()

    // 下一个图形比上一个图形上
    private var aHeight = mHeight / 2
    private var aWidth = 0f

    // 第一个图形的宽度
    private var oneViewWidth = 40.dp2px().toFloat()

    // 每个图形的间隔, 也就是说下一个图形的Y轴为
    private var mSpace = 2.dp2px().toFloat()

    private val colorList = arrayListOf(
        Color.parseColor("#00A556"),
        Color.parseColor("#00C247"),
        Color.parseColor("#71CB27"),
        Color.parseColor("#FEFF00"),
        Color.parseColor("#FF9A00"),
        Color.parseColor("#FF4600"),
        Color.parseColor("#FF0000")
    )

    private val textList = arrayListOf("A", "B", "C", "D", "E", "F", "G")

    private fun draw(canvas: Canvas, index: Int, width: Float = 0f) {
        mPaint.color = colorList[index]
        // y1 = (每个图形的固定高度 + 行高) * index
        val y1 = (mHeight + mSpace) * index
        val y2 = y1 + mHeight

        val x = if (width >= oneViewWidth + index * aHeight) {
            oneViewWidth + index * aHeight
        } else {
            width
        }

        val path = Path()
        path.moveTo(0f, y1)
        path.lineTo(0f, y2)
        path.lineTo(x - aHeight, y2)
        path.lineTo(x, y1 + aHeight)
        path.lineTo(x - aHeight, y1)
        path.close()

        canvas.drawPath(path, mPaint)

        canvas.drawText(textList[index],x-10.dp2px(),y2-3.dp2px(), mTextPaint)
    }

    override fun onDraw(canvas: Canvas) {
        for (index in 0..6) {
            draw(canvas, index, aWidth)
        }
    }
}