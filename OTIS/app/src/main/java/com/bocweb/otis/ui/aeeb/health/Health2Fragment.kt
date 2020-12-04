package com.bocweb.otis.ui.aeeb.health

import android.animation.ObjectAnimator
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseFragment
import com.bocweb.otis.util.dp2px
import kotlinx.android.synthetic.main.fragment_l1_health2.*

class Health2Fragment : BaseFragment() {
    override fun getLayoutId() = R.layout.fragment_l1_health2

    override fun initView() {

        val anim = ObjectAnimator.ofFloat(iv_scan, "translationY", 0f, 235.dp2px().toFloat(), 0f)
        anim.duration = 7000
        anim.repeatCount = ObjectAnimator.INFINITE
        anim.start()
    }

}