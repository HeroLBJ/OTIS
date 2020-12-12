package com.bocweb.otis.ui.mod.chart

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.bocweb.otis.util.dp2px
import com.bocweb.otis.util.sp2px


class ChartView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val lineColor = Color.parseColor("#BDBEB7")
    private val textColor = Color.parseColor("#797975")
    private val blueColor = Color.parseColor("#697BDD")

    private val pointO = PointF(53.dp2px().toFloat(), 338.dp2px().toFloat())
    private val pointXEnd = PointF(310.dp2px().toFloat(), 338.dp2px().toFloat())
    private val pointYEnd = PointF(53.dp2px().toFloat(), 22.dp2px().toFloat())

    private val paint by lazy { Paint() }
    private val textPaint by lazy { Paint() }
    private val blackPaint by lazy { Paint() }
    private val strokePaint by lazy { Paint() }
    private val bluePaint by lazy { Paint() }

    private val y1 = pointO.y - 55.dp2px()
    private val y2 = pointO.y - 53.dp2px() * 2
    private val y3 = pointO.y - 53.dp2px() * 3
    private val y4 = pointO.y - 53.dp2px() * 4
    private val y5 = pointO.y - 52.dp2px() * 5 - 3.dp2px()


    init {
        paint.apply {
            isAntiAlias = true
            color = lineColor
            strokeWidth = 1.dp2px().toFloat() / 2
        }

        textPaint.apply {
            isAntiAlias = true
            color = textColor
            textSize = 10.sp2px().toFloat()
            textAlign = Paint.Align.CENTER
        }

        blackPaint.apply {
            isAntiAlias = true
            color = Color.BLACK
            strokeWidth = 1.dp2px().toFloat()
        }

        strokePaint.apply {
            isAntiAlias = true
            style = Paint.Style.STROKE
            color = lineColor
            strokePaint.pathEffect = DashPathEffect(floatArrayOf(15f, 10f), 0f)
        }

        bluePaint.apply {
            isAntiAlias = true
            color = blueColor
            strokeWidth = 1.dp2px().toFloat()
        }
    }

    override fun onDraw(canvas: Canvas) {
        // 画x轴
        drawXLine(canvas)
        // 画y轴
        drawYLine(canvas)
        // 画x轴参数
        drawXParam(canvas)
        // 画y轴参数与线
        drawYParam(canvas)
        // 画蓝线
        drawBlue(canvas)
        // 画黄线
        // 画红线
    }

    private fun drawBlue(canvas: Canvas) {
        val p1 = PointF(pointO.x, y5)
        val p2 = PointF(pointO.x + 25.dp2px(), y5 + 5.dp2px())
        val p3 = PointF(pointO.x + 51.dp2px(), y5 + 10.dp2px())
        val p4 = PointF(pointO.x + 76.dp2px(), y5 + 15.dp2px())
        val p5 = PointF(pointO.x + 102.dp2px(), y5 + 20.dp2px())
        val p6 = PointF(pointO.x + 127.dp2px(), y5 + 25.dp2px())
        val p7 = PointF(pointO.x + 153.dp2px(), y5 + 30.dp2px())
        val p8 = PointF(pointO.x + 178.dp2px(), y5 + 35.dp2px())
        val p9 = PointF(pointO.x + 204.dp2px(), y5 + 40.dp2px())
        val p10 = PointF(pointO.x + 209.dp2px(), y5 + 45.dp2px())
        val floatArray = floatArrayOf(
            p1.x, p1.y, p2.x, p2.y, p2.x, p2.y, p3.x, p3.y, p3.x, p3.y,
            p4.x, p4.y, p4.x, p4.y, p5.x, p5.y, p5.x, p5.y, p6.x, p6.y,
            p6.x, p6.y, p7.x, p7.y, p7.x, p7.y, p8.x, p8.y, p8.x, p8.y,
            p9.x, p9.y, p9.x, p9.y, p10.x, p10.y
        )
        canvas.drawLines(floatArray, bluePaint)
    }

    private fun drawYParam(canvas: Canvas) {
        canvas.drawText("20%", pointO.x - 20.dp2px(), pointO.y - 52.dp2px(), textPaint)
        canvas.drawText("40%", pointO.x - 20.dp2px(), pointO.y - 52.dp2px() * 2, textPaint)
        canvas.drawText("50%", pointO.x - 20.dp2px(), pointO.y - 52.dp2px() * 3, textPaint)
        canvas.drawText("60%", pointO.x - 20.dp2px(), pointO.y - 52.dp2px() * 4, textPaint)
        canvas.drawText("100%", pointO.x - 22.dp2px(), pointO.y - 52.dp2px() * 5, textPaint)

        canvas.drawLine(pointO.x, y1, pointO.x - 3.dp2px(), y1, blackPaint)
        val path = Path()
        path.moveTo(pointO.x, y1)
        path.lineTo(pointXEnd.x, y1)
        canvas.drawPath(path, strokePaint)

        canvas.drawLine(pointO.x, y2, pointO.x - 3.dp2px(), y2, blackPaint)
        path.moveTo(pointO.x, y2)
        path.lineTo(pointXEnd.x, y2)
        canvas.drawPath(path, strokePaint)

        canvas.drawLine(pointO.x, y3, pointO.x - 3.dp2px(), y3, blackPaint)
        path.moveTo(pointO.x, y3)
        path.lineTo(pointXEnd.x, y3)
        canvas.drawPath(path, strokePaint)

        canvas.drawLine(pointO.x, y4, pointO.x - 3.dp2px(), y4, blackPaint)
        path.moveTo(pointO.x, y4)
        path.lineTo(pointXEnd.x, y4)
        canvas.drawPath(path, strokePaint)

        canvas.drawLine(pointO.x, y5, pointO.x - 3.dp2px(), y5, blackPaint)
        path.moveTo(pointO.x, y5)
        path.lineTo(pointXEnd.x, y5)
        canvas.drawPath(path, strokePaint)
    }

    private fun drawXParam(canvas: Canvas) {
        canvas.drawText("年限", pointO.x, pointO.y + 20.dp2px(), textPaint)
        canvas.drawText("5", pointO.x + 51.dp2px(), pointO.y + 20.dp2px(), textPaint)
        canvas.drawText("10", pointO.x + 51.dp2px() * 2, pointO.y + 20.dp2px(), textPaint)
        canvas.drawText("15", pointO.x + 51.dp2px() * 3, pointO.y + 20.dp2px(), textPaint)
        canvas.drawText("20", pointO.x + 51.dp2px() * 4, pointO.y + 20.dp2px(), textPaint)
        canvas.drawLine(
            pointO.x + 51.dp2px(),
            338.dp2px().toFloat(),
            pointO.x + 51.dp2px(),
            341.dp2px().toFloat(),
            blackPaint
        )
        canvas.drawLine(
            pointO.x + 51.dp2px() * 2,
            338.dp2px().toFloat(),
            pointO.x + 51.dp2px() * 2,
            341.dp2px().toFloat(),
            blackPaint
        )
        canvas.drawLine(
            pointO.x + 51.dp2px() * 3,
            338.dp2px().toFloat(),
            pointO.x + 51.dp2px() * 3,
            341.dp2px().toFloat(),
            blackPaint
        )
        canvas.drawLine(
            pointO.x + 51.dp2px() * 4,
            338.dp2px().toFloat(),
            pointO.x + 51.dp2px() * 4,
            341.dp2px().toFloat(),
            blackPaint
        )
    }

    private fun drawXLine(canvas: Canvas) {
        canvas.drawLine(pointO.x, pointO.y, pointXEnd.x, pointXEnd.y, paint)
        canvas.drawLine(
            pointXEnd.x,
            pointXEnd.y,
            pointXEnd.x - 5.dp2px(),
            pointXEnd.y - 5.dp2px(),
            paint
        )
        canvas.drawLine(
            pointXEnd.x,
            pointXEnd.y,
            pointXEnd.x - 5.dp2px(),
            pointXEnd.y + 5.dp2px(),
            paint
        )
    }

    private fun drawYLine(canvas: Canvas) {
        canvas.drawLine(pointO.x, pointO.y, pointYEnd.x, pointYEnd.y, paint)
        canvas.drawLine(
            pointYEnd.x,
            pointYEnd.y,
            pointYEnd.x - 5.dp2px(),
            pointYEnd.y + 5.dp2px(),
            paint
        )
        canvas.drawLine(
            pointYEnd.x,
            pointYEnd.y,
            pointYEnd.x + 5.dp2px(),
            pointYEnd.y + 5.dp2px(),
            paint
        )
    }
}