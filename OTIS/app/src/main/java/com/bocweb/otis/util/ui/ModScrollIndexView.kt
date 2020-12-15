package com.bocweb.otis.util.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.bocweb.otis.R

class ModScrollIndexView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var currentView: View
    private var index1View: View
    private var index2View: View
    private var index3View: View
    private var rootView = LayoutInflater.from(context).inflate(R.layout.view_mod_scroll_index, this) as LinearLayout

    init {
        currentView = rootView.findViewById(R.id.current)
        index1View = rootView.findViewById(R.id.index1)
        index2View = rootView.findViewById(R.id.index2)
        index3View = rootView.findViewById(R.id.index3)
    }

    fun setCurrentPosition(index: Int) {
        removeAllViews()
        rootView.removeAllViews()
        when (index) {
            0 -> {
                rootView.addView(currentView)
                rootView.addView(index1View)
                rootView.addView(index2View)
                rootView.addView(index3View)
            }
            1 -> {
                rootView.addView(index1View)
                rootView.addView(currentView)
                rootView.addView(index2View)
                rootView.addView(index3View)
            }
            2 -> {
                rootView.addView(index1View)
                rootView.addView(index2View)
                rootView.addView(currentView)
                rootView.addView(index3View)
            }
            3 -> {
                rootView.addView(index1View)
                rootView.addView(index2View)
                rootView.addView(index3View)
                rootView.addView(currentView)
            }
        }
        addView(rootView)
        invalidate()
    }
}