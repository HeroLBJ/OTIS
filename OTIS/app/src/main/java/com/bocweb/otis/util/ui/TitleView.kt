package com.bocweb.otis.util.ui

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.bocweb.otis.R
import com.bocweb.otis.util.dp2px

class TitleView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    init {
        val rootView = LayoutInflater.from(context).inflate(R.layout.view_title, null)
        val tvTitle = rootView.findViewById<TextView>(R.id.tv_title)

        val array = context.obtainStyledAttributes(attrs, R.styleable.TitleView)
        val title = array.getString(R.styleable.TitleView_title)
        val titleColor = array.getColor(R.styleable.TitleView_title_color, Color.BLACK)
        tvTitle.text = title ?: ""
        tvTitle.setTextColor(titleColor)

        addView(rootView)
        array.recycle()
    }
}