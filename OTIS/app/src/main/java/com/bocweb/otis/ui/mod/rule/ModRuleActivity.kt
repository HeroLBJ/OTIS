package com.bocweb.otis.ui.mod.rule

import android.animation.ObjectAnimator
import android.view.View
import cn.youngkaaa.yviewpager.YViewPager
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.ui.mod.dialog.InputInfoDialog
import com.bocweb.otis.util.dp2px
import com.bocweb.otis.util.setClickNoRepeat
import kotlinx.android.synthetic.main.activity_mod_rule.*

class ModRuleActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_rule

    private val dialog by lazy { InputInfoDialog(this) }

    override fun initView() {
        viewpager.adapter = ModRuleAdapter(supportFragmentManager)

        iv_submit_info.setClickNoRepeat {
            dialog.show()
            dismissImg()
        }

        viewpager.addOnPageChangeListener(object : YViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                if (position == 2) {
                    iv_submit_info.visibility = View.GONE
                } else {
                    iv_submit_info.visibility = View.VISIBLE
                }
            }
        })

        dialog.setOnDismissListener { showImg() }
    }

    private fun showImg() {
        val anim = ObjectAnimator.ofFloat(iv_submit_info, "translationX", 60.dp2px().toFloat(), 0f)
        anim.duration = 500
        anim.start()
    }

    private fun dismissImg() {
        val anim = ObjectAnimator.ofFloat(iv_submit_info, "translationX", 0f, 60.dp2px().toFloat())
        anim.duration = 500
        anim.start()
    }
}