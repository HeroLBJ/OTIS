package com.bocweb.otis.ui.aeeb

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.core.animation.doOnEnd
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.ui.aeeb.good.AeebGoodActivity
import com.bocweb.otis.ui.aeeb.health.HealthActivity
import com.bocweb.otis.ui.aeeb.spare.AeebSpareActivity
import com.bocweb.otis.util.setClickNoRepeat
import kotlinx.android.synthetic.main.activity_main_aeeb.*

class AeebMainActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_main_aeeb

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
            val intent = Intent(this,AeebGoodActivity::class.java)
            startActivity(intent)
        }
    }

    override fun initData() {
        val animBgAlpha = ObjectAnimator.ofFloat(iv_bg, "alpha", 1f, 0f)
        animBgAlpha.duration = 3000
        animBgAlpha.start()

        val animTitleAlpha = ObjectAnimator.ofFloat(tv_title, "alpha", 0f, 1f)
        animTitleAlpha.duration = 1500
        animTitleAlpha.start()

        animTitleAlpha.doOnEnd {
            animCenter()
        }
    }

    private fun animCenter() {

        val animCenter1 = ObjectAnimator.ofFloat(iv_center, "alpha", 1f, 0.5f)
        animCenter1.duration = 1000
        animCenter1.start()
        val animCenter2 = ObjectAnimator.ofFloat(iv_center, "scaleX", 1.01f, 0.99f)
        animCenter2.duration = 1000
        animCenter2.start()
        val animCenter3 = ObjectAnimator.ofFloat(iv_center, "scaleY", 1.01f, 0.99f)
        animCenter3.duration = 1000
        animCenter3.start()

        val animCenter4 = ObjectAnimator.ofFloat(iv_center, "alpha", 0.5f, 1f)
        animCenter4.duration = 1000
        val animCenter5 = ObjectAnimator.ofFloat(iv_center, "scaleX", 0.99f, 1.01f)
        animCenter5.duration = 1000
        val animCenter6 = ObjectAnimator.ofFloat(iv_center, "scaleY", 0.99f, 1.01f)
        animCenter6.duration = 1000


        animCenter1.doOnEnd {
            animCenter4.start()
            animCenter5.start()
            animCenter6.start()
        }

        animCenter4.doOnEnd {
            animCenter1.start()
            animCenter2.start()
            animCenter3.start()
        }
    }
}