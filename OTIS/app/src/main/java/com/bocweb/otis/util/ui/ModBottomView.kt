package com.bocweb.otis.util.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bocweb.otis.R
import com.bocweb.otis.util.setClickNoRepeat

@SuppressLint("InflateParams")
class ModBottomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    init {
        val rootView = LayoutInflater.from(context).inflate(R.layout.view_mod_bottom, null)
        val tvTitle = rootView.findViewById<TextView>(R.id.title)
        val action = rootView.findViewById<ImageView>(R.id.action)
        action.setClickNoRepeat { onActionListener?.onActionClick() }
        addView(rootView)
    }

    private var onActionListener: OnActionListener? = null

    fun setOnActionListener(onActionListener: OnActionListener?) {
        this.onActionListener = onActionListener
    }

    interface OnActionListener {
        fun onActionClick()
    }
}