package com.bocweb.otis.ui.mod

import android.animation.ObjectAnimator
import androidx.core.view.children
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.dp2px
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_mod_main.*
import java.util.*

class ModMainActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_main

    private val random = Random()


    override fun initView() {
        rootView.startPageAnim(this)

        for (child in rl_parent.children) {
            val unit = random.nextBoolean()
            val distance = if (unit) {
                10.dp2px() + random.nextInt(30).toFloat()
            } else {
                (-10).dp2px() - random.nextInt(30).toFloat()
            }
            val anim = ObjectAnimator.ofFloat(child, "translationY", 0f, distance)
            anim.duration = 2000
            anim.startDelay = 500
            anim.start()
        }
    }

    override fun onBackPressed() {
        rootView.finishPage(this)
    }
}