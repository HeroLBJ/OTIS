package com.bocweb.otis.ui.mod

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.core.animation.doOnEnd
import androidx.core.view.children
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.ui.mod.rule.MobRuleActivity
import com.bocweb.otis.util.*
import kotlinx.android.synthetic.main.activity_mod_main.*
import java.util.*

class ModMainActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_main

    private val random = Random()

    override fun initView() {
        rootView.startPageAnim(this)

        for (child in rl_parent.children) {
            val set = AnimatorSet()
            val translation = ObjectAnimator.ofFloat(child, "translationY", getScreenHeight().toFloat(), 0f)
            set.play(translation)
            set.duration = 4000L + random.nextInt(2000)
            set.start()
        }

        val anim = ObjectAnimator.ofFloat(tv_title, "alpha", 1f, 1f)
        anim.duration = 6000
        anim.start()
        anim.doOnEnd {
            rootView.startPage(
                this, MobRuleActivity::class.java,
                getScreenWidth() / 2, getScreenHeight()
            )
        }
    }

    override fun onBackPressed() {
        rootView.finishPage(this)
    }
}