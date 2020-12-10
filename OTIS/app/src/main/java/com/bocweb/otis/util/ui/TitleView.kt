package com.bocweb.otis.util.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.bocweb.otis.R

class TitleView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    init {
        val rootView = LayoutInflater.from(context).inflate(R.layout.view_title, null)
        val tvTitle = rootView.findViewById<TextView>(R.id.tv_title)

        val array = context.obtainStyledAttributes(attrs, R.styleable.TitleView)
        val title = array.getString(R.styleable.TitleView_title)
        tvTitle.text = title?:""
        addView(rootView)
    }
}