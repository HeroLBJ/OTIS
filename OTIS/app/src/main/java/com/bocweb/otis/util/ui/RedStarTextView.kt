package com.bocweb.otis.util.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.bocweb.otis.R

class RedStarTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        val rootView = LayoutInflater.from(context).inflate(R.layout.view_red_star_text, null)
        val tvTitle = rootView.findViewById<TextView>(R.id.tv_title)
        val array = context.obtainStyledAttributes(R.styleable.RedStarTextView)
        val title = array.getString(R.styleable.RedStarTextView_red_star_title)
        tvTitle.text = title
        addView(rootView)
        array.recycle()
    }

}