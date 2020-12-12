package com.bocweb.otis.ui.mod

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import androidx.core.animation.doOnEnd
import com.bocweb.otis.MainActivity
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.*
import kotlinx.android.synthetic.main.activity_mod_splash.*
import kotlinx.android.synthetic.main.activity_mod_splash.rootView

class ModSplashActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_splash

    private val screenHeight = 667.dp2px().toFloat()

    override fun initView() {
        rootView.startPageAnim(this)
        animLine()
    }

    fun onAction(it: View) {
        startPageDownY(ModMainActivity::class.java, finish = true)
    }

    private fun animLine() {
        val set = AnimatorSet()
        val line1 = ObjectAnimator.ofFloat(line1, "scaleY", 1f, -screenHeight)
        val line2 = ObjectAnimator.ofFloat(line2, "scaleY", 1f, -screenHeight)
        val line3 = ObjectAnimator.ofFloat(line3, "scaleY", 1f, -screenHeight)
        val line4 = ObjectAnimator.ofFloat(line4, "scaleY", 1f, -screenHeight)
        set.play(line1).with(line2).with(line3).with(line4)
        set.duration = 2000
        set.start()

        val alpha = ObjectAnimator.ofFloat(line1, "alpha", 1f, 1f)
        alpha.duration = 500
        alpha.start()
        alpha.doOnEnd { animRect() }
    }

    private fun animRect() {
        val set = AnimatorSet()
        val rect1 =
            ObjectAnimator.ofFloat(rect1, "translationY", 0f, -screenHeight * 3 / 2)
        rect1.duration = 3000
        val rect2 =
            ObjectAnimator.ofFloat(rect2, "translationY", 0f, -screenHeight * 3 / 2)
        rect2.duration = 3000
        rect2.startDelay = 200
        val rect3 =
            ObjectAnimator.ofFloat(rect3, "translationY", 0f, -screenHeight - 100.dp2px())
        rect3.duration = 3000
        rect3.startDelay = 500
        val rect4 =
            ObjectAnimator.ofFloat(rect4, "translationY", 0f, -screenHeight + 100.dp2px())
        rect4.duration = 3000
        rect4.startDelay = 1000
        val rect5 =
            ObjectAnimator.ofFloat(rect5, "translationY", 0f, -screenHeight / 2)
        rect5.duration = 3000
        rect5.startDelay = 1500

        val top = ObjectAnimator.ofFloat(tv_top_title, "alpha", 0f, 1f)
        top.duration = 1500
        top.startDelay = 1000
        val top1 = ObjectAnimator.ofFloat(
            tv_top_title, "translationY", 0f, -270.dp2px().toFloat()
        )
        top1.startDelay = 1500
        top1.duration = 1500

        set.play(rect1).with(rect2).with(rect3).with(rect4).with(rect5).with(top).with(top1)
        set.startDelay = 100
        set.start()
        top.doOnEnd { animT() }
    }

    private fun animT() {
        val set = AnimatorSet()
        val logoA = ObjectAnimator.ofFloat(ll_logo_title, "alpha", 0f, 1f)
        val logoT =
            ObjectAnimator.ofFloat(ll_logo_title, "translationY", 0f, -100.dp2px().toFloat())
        val actionA = ObjectAnimator.ofFloat(tv_splash_action, "alpha", 0f, 1f)
        set.play(logoA).with(logoT).with(actionA)
        set.duration = 1000
        set.start()
    }
}