package com.bocweb.otis.ui.aeeb.speed

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.core.widget.NestedScrollView
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.getLocalVisibleRect
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_aeeb_speed.rootView
import kotlinx.android.synthetic.main.activity_aeeb_speed.scrollView
import kotlinx.android.synthetic.main.include_eight_img.*
import kotlinx.android.synthetic.main.include_eight_time.*
import kotlinx.android.synthetic.main.include_title_l1.*

class AeebSpeedActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_aeeb_speed

    private var isStartAnim = false

    override fun initView() {
        rootView.startPageAnim(this)

        tv_title.text = "一体化安装流程"
        startAnimEight()

        scrollView.setOnScrollChangeListener(
            NestedScrollView.OnScrollChangeListener
            { _, _, scrollY, _, _ ->
                if (alpha_11.getLocalVisibleRect(this, scrollY) && !isStartAnim) {
                    isStartAnim = true
                    startAnim()
                    blueView.startAnim()
                }
            })

        rl_back.setClickNoRepeat { onBackPressed() }
    }

    override fun onBackPressed() {
        rootView.finishPage(this)
    }

    private fun startAnimEight() {
        val set = AnimatorSet()
        val eight1 = ObjectAnimator.ofFloat(eight1, "alpha", 0.1f, 1f)
        eight1.duration = 500
        val eight2 = ObjectAnimator.ofFloat(eight2, "alpha", 0.1f, 1f)
        eight2.duration = 500
        eight2.startDelay = 500
        val eight3 = ObjectAnimator.ofFloat(eight3, "alpha", 0.1f, 1f)
        eight3.duration = 500
        eight3.startDelay = 1000
        val eight4 = ObjectAnimator.ofFloat(eight4, "alpha", 0.1f, 1f)
        eight4.duration = 500
        eight4.startDelay = 1500
        val eight5 = ObjectAnimator.ofFloat(eight5, "alpha", 0.1f, 1f)
        eight5.duration = 500
        eight5.startDelay = 2000
        val eight6 = ObjectAnimator.ofFloat(eight6, "alpha", 0.1f, 1f)
        eight6.duration = 500
        eight6.startDelay = 2500
        val eight7 = ObjectAnimator.ofFloat(eight7, "alpha", 0.1f, 1f)
        eight7.duration = 500
        eight7.startDelay = 3000
        val eight8 = ObjectAnimator.ofFloat(eight8, "alpha", 0.1f, 1f)
        eight8.duration = 500
        eight8.startDelay = 3500
        set.play(eight1).with(eight2).with(eight3).with(eight4).with(eight5).with(eight6)
            .with(eight7).with(eight8)
        set.start()
    }

    private fun startAnim() {
        val leftSet = AnimatorSet()
        val alpha11 = ObjectAnimator.ofFloat(alpha_11, "alpha", 0.1f, 1f)
        alpha11.duration = 500
        val alpha12 = ObjectAnimator.ofFloat(alpha_12, "alpha", 0.1f, 1f)
        alpha12.duration = 500
        alpha12.startDelay = 500
        val alpha13 = ObjectAnimator.ofFloat(alpha_13, "alpha", 0.1f, 1f)
        alpha13.duration = 500
        alpha13.startDelay = 1000
        val alpha14 = ObjectAnimator.ofFloat(alpha_14, "alpha", 0.1f, 1f)
        alpha14.duration = 500
        alpha14.startDelay = 1500
        val alpha15 = ObjectAnimator.ofFloat(alpha_15, "alpha", 0.1f, 1f)
        alpha15.duration = 500
        alpha15.startDelay = 2000
        val alpha16 = ObjectAnimator.ofFloat(alpha_16, "alpha", 0.1f, 1f)
        alpha16.duration = 500
        alpha16.startDelay = 2500
        val alpha17 = ObjectAnimator.ofFloat(alpha_17, "alpha", 0.1f, 1f)
        alpha17.duration = 500
        alpha17.startDelay = 3000
        val alpha18 = ObjectAnimator.ofFloat(alpha_18, "alpha", 0.1f, 1f)
        alpha18.duration = 500
        alpha18.startDelay = 3500
        leftSet.play(alpha11).with(alpha12).with(alpha13).with(alpha14).with(alpha15)
            .with(alpha16).with(alpha17).with(alpha18)
        leftSet.start()

        val rightSet = AnimatorSet()
        val alpha21 = ObjectAnimator.ofFloat(alpha_21, "alpha", 0.1f, 1f)
        alpha21.duration = 500
        val alpha22 = ObjectAnimator.ofFloat(alpha_22, "alpha", 0.1f, 1f)
        alpha22.duration = 500
        alpha22.startDelay = 700
        val alpha23 = ObjectAnimator.ofFloat(alpha_23, "alpha", 0.1f, 1f)
        alpha23.duration = 500
        alpha23.startDelay = 1400
        val alpha24 = ObjectAnimator.ofFloat(alpha_24, "alpha", 0.1f, 1f)
        alpha24.duration = 500
        alpha24.startDelay = 2100
        val alpha25 = ObjectAnimator.ofFloat(alpha_25, "alpha", 0.1f, 1f)
        alpha25.duration = 500
        alpha25.startDelay = 2800
        val alpha26 = ObjectAnimator.ofFloat(alpha_26, "alpha", 0.1f, 1f)
        alpha26.duration = 500
        alpha26.startDelay = 3500
        rightSet.play(alpha21).with(alpha22).with(alpha23).with(alpha24).with(alpha25).with(alpha26)
        rightSet.start()
    }
}