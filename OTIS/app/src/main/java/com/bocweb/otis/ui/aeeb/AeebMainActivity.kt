package com.bocweb.otis.ui.aeeb

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.core.animation.doOnEnd
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.ui.aeeb.good.AeebGoodActivity
import com.bocweb.otis.ui.aeeb.health.HealthActivity
import com.bocweb.otis.ui.aeeb.more.AeebMoreActivity
import com.bocweb.otis.ui.aeeb.pretty.AeebPrettyActivity
import com.bocweb.otis.ui.aeeb.spare.AeebSpareActivity
import com.bocweb.otis.util.setClickNoRepeat
import kotlinx.android.synthetic.main.activity_main_aeeb.*
import java.util.*

class AeebMainActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_main_aeeb

    private val random by lazy { Random() }
    private val actionList by lazy {
        arrayListOf(
            tv_action_more,
            tv_action_speed,
            tv_action_good,
            tv_action_spare,
            tv_action_pretty,
            tv_action_health
        )
    }

    override fun initListener() {
        tv_action_health.setClickNoRepeat {
            val intent = Intent(this, HealthActivity::class.java)
            startActivity(intent)
        }

        tv_action_spare.setClickNoRepeat {
            val intent = Intent(this, AeebSpareActivity::class.java)
            startActivity(intent)
        }

        tv_action_good.setClickNoRepeat {
            val intent = Intent(this, AeebGoodActivity::class.java)
            startActivity(intent)
        }

        tv_action_pretty.setClickNoRepeat {
            val intent = Intent(this, AeebPrettyActivity::class.java)
            startActivity(intent)
        }

        tv_action_more.setClickNoRepeat {
            val intent = Intent(this, AeebMoreActivity::class.java)
            startActivity(intent)
        }
    }

    override fun initData() {
        val animBgAlpha = ObjectAnimator.ofFloat(iv_bg, "alpha", 1f, 0f)
        animBgAlpha.duration = 2000
        animBgAlpha.start()
        animBgAlpha.doOnEnd { animAction() }

        val animTitleAlpha = ObjectAnimator.ofFloat(tv_title, "alpha", 0f, 1f)
        animTitleAlpha.duration = 1000
        animTitleAlpha.start()

        animTitleAlpha.doOnEnd { animCenter() }
    }

    private fun animAction() {
        for (item in actionList.indices) {
            val anim = ObjectAnimator.ofFloat(actionList[item], "alpha", 0f, 1f)
            anim.duration = 500
            anim.startDelay = item * 500L
            anim.start()
        }
    }

    private fun animCenter() {
        val set = AnimatorSet()
        val anim1 = ObjectAnimator.ofFloat(iv_center, "alpha", 1f, 0.5f, 1f)
        anim1.repeatCount = ObjectAnimator.INFINITE
        val anim2 = ObjectAnimator.ofFloat(iv_center, "scaleX", 1.01f, 0.99f, 1.01f)
        anim2.repeatCount = ObjectAnimator.INFINITE
        val anim3 = ObjectAnimator.ofFloat(iv_center, "scaleY", 1.01f, 0.99f, 1.01f)
        anim3.repeatCount = ObjectAnimator.INFINITE
        set.play(anim1).with(anim2).with(anim3)
        set.duration = 2000
        set.start()
    }
}