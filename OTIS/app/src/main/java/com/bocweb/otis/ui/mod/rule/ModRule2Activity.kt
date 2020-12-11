package com.bocweb.otis.ui.mod.rule

import android.view.MotionEvent
import android.view.View
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.*
import kotlinx.android.synthetic.main.activity_mob_rule.*
import kotlin.math.abs

class ModRule2Activity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mob_rule2

    override fun initView() {

    }

    var downX = 0f
    var downY = 0f
    var distanceX = 0f
    var distanceY = 0f
    override fun initListener() {
        rootView.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    downX = event.x
                    downY = event.y
                    distanceX = 0f
                    distanceY = 0f
                }
                MotionEvent.ACTION_MOVE -> {
                    val moveX = event.x
                    val moveY = event.y
                    distanceX += abs(downX - moveX)
                    distanceY += downY - moveY
                    downX = moveX
                    downY = moveY
                }
                MotionEvent.ACTION_UP -> {
                    println("($distanceX,$distanceY))")
                    if (distanceX < 160) {
                        if (distanceY > 300) {
//                            rootView.startPage(this,ModRule3Activity::class.java,
//                            getScreenWidth()/2, getScreenHeight())
                            startPageDownY(ModRule3Activity::class.java)
                        }
                    }
                }
            }
            rootView.performClick()
            true
        }
    }

    override fun onBackPressed() {}

}