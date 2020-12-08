package com.bocweb.otis.util.ui

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.bocweb.otis.R

class RadiusCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.materialCardViewStyle
) : CardView(context, attrs, defStyleAttr) {
    private val topLeftRadius: Float
    private val topRightRadius: Float
    private val bottomRightRadius: Float
    private val bottomLeftRadius: Float
    override fun onDraw(canvas: Canvas) {
        val path = Path()
        val rectF = rectF
        val radius = floatArrayOf(
            topLeftRadius,
            topLeftRadius,
            topRightRadius,
            topRightRadius,
            bottomRightRadius,
            bottomRightRadius,
            bottomLeftRadius,
            bottomLeftRadius
        )
        path.addRoundRect(rectF, radius, Path.Direction.CW)
        canvas.clipPath(path, Region.Op.INTERSECT)
        super.onDraw(canvas)
    }

    private val rectF: RectF
        private get() {
            val rect = Rect()
            getDrawingRect(rect)
            return RectF(rect)
        }

    init {
        radius = 0f
        val array = context.obtainStyledAttributes(attrs, R.styleable.RadiusCardView)
        topLeftRadius = array.getDimension(R.styleable.RadiusCardView_rcv_topLeftRadius, 0f)
        topRightRadius = array.getDimension(R.styleable.RadiusCardView_rcv_topRightRadius, 0f)
        bottomRightRadius = array.getDimension(R.styleable.RadiusCardView_rcv_bottomRightRadius, 0f)
        bottomLeftRadius = array.getDimension(R.styleable.RadiusCardView_rcv_bottomLeftRadius, 0f)
        background = ColorDrawable()
    }
}