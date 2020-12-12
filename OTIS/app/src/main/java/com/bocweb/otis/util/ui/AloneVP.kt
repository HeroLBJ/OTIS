package com.bocweb.otis.util.ui

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import cn.youngkaaa.yviewpager.YViewPager

class AloneVP(context: Context, attrs: AttributeSet?) : YViewPager(context, attrs) {

    private var beforeY = 0f
    private var isCanScroll = false

    //-----禁止左滑-------左滑：上一次坐标 > 当前坐标

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if(isCanScroll){
            return super.dispatchTouchEvent(ev)
        }else{
            when(ev.action){
                MotionEvent.ACTION_DOWN ->{
                    beforeY = ev.y
                }
                MotionEvent.ACTION_MOVE ->{
                    val motionValue = ev.y - beforeY
                    if(motionValue > 0){
                        // 禁止左滑
                        return true
                    }
                    beforeY = ev.y
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}