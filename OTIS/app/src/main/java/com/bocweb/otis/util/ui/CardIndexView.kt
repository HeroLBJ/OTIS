package com.bocweb.otis.util.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.bocweb.otis.util.dp2px
import com.bocweb.otis.util.getScreenWidth

class CardIndexView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var start = 0f
    private val width = 18.dp2px().toFloat()
    private val height = 3.dp2px().toFloat()
    private val space = 5.dp2px().toFloat()

    var maxLine = 5
        set(value){
            field = value

            val screenW = getScreenWidth()
            start = (screenW - width * maxLine - space * (maxLine - 1)) / 2 + 17.dp2px()

            invalidate()
        }

    var currentIndex = 0
        set(value) {
            field = value
            invalidate()
        }

    private val paint by lazy { Paint() }

    init {
        paint.color = Color.parseColor("#C8CABC")
        paint.strokeWidth = height
        paint.isAntiAlias = true

        val screenW = getScreenWidth()

        start = (screenW - width * maxLine - space * (maxLine - 1)) / 2 + 17.dp2px()
    }


    override fun onDraw(canvas: Canvas) {
        paint.color = Color.parseColor("#C8CABC")
        for (index in 0 until maxLine) {
            val startW = start + (width + space) * index
            val endW = startW + width
            canvas.drawLine(startW, 0f, endW, 0f, paint)
        }
        val startW = start + (width + space) * currentIndex
        val endW = startW + width
        paint.color = Color.parseColor("#141A29")
        canvas.drawLine(startW, 0f, endW, 0f, paint)
    }
}