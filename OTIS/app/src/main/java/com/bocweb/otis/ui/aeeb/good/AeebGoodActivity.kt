package com.bocweb.otis.ui.aeeb.good

import android.animation.ObjectAnimator
import android.view.View
import androidx.core.widget.NestedScrollView
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.*
import kotlinx.android.synthetic.main.activity_aeeb_good.*
import kotlinx.android.synthetic.main.include_title_l1.*

class AeebGoodActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_aeeb_good

    override fun initTitle() {
        tv_title.text = "好电梯"
    }

    override fun initView() {
        rootView.startPageAnim(this)
        translationY()
    }

    private var root3V = false

    private fun translationY(scrollY: Int = 0) {
        if (rl3.getLocalVisibleRect(this, scrollY) && !root3V) {
            root3V = true
            rl3.startAnim()
        }
    }

    override fun initListener() {
        rl_back.setClickNoRepeat { onBackPressed() }

        scrollView.setOnScrollChangeListener(
            NestedScrollView.OnScrollChangeListener
            { _, _, scrollY, _, _ ->
                translationY(scrollY)
            })
    }

    private fun View.startAnim() {
        val anim =
            ObjectAnimator.ofFloat(this, "translationY", 0f, -15.dp2px().toFloat())
        anim.duration = 1000
        anim.startDelay = 200
        anim.start()
    }

    override fun onBackPressed() {
        rootView.finishPage(this)
    }
}