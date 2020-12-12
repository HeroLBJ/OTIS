package com.bocweb.otis.ui.mod

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.core.animation.doOnEnd
import androidx.core.view.children
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.ui.mod.rule.ModRuleActivity
import com.bocweb.otis.util.*
import kotlinx.android.synthetic.main.activity_mod_main.*
import java.util.*

class ModMainActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_main

    private val random = Random()

    override fun initView() {
        for (child in rl_parent.children) {
            val set = AnimatorSet()
            val translation =
                ObjectAnimator.ofFloat(child, "translationY", getScreenHeight().toFloat(), 0f)
            set.play(translation)
            set.duration = 4000L + random.nextInt(2000)
            set.start()
        }

        val anim = ObjectAnimator.ofFloat(tv_title, "alpha", 1f, 1f)
        anim.duration = 6000
        anim.start()
        anim.doOnEnd { startPageDownY(ModRuleActivity::class.java, finish = true) }
    }
}