package com.bocweb.otis.ui.aeeb.spare

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.view.View
import android.widget.RelativeLayout
import android.widget.TableRow
import androidx.core.view.children
import androidx.core.widget.NestedScrollView
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.dp2px
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.getLocalVisibleRect
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_aeeb_spare.*
import kotlinx.android.synthetic.main.activity_aeeb_spare.rootView
import kotlinx.android.synthetic.main.activity_l1_health.*
import kotlinx.android.synthetic.main.include_aeeb_spare_bottom.*
import kotlinx.android.synthetic.main.include_aeeb_spare_center.*

class AeebSpareActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_aeeb_spare

    private var childIndex = 0

    override fun initView() {
        rootView.startPageAnim(this)

        tv_num1.showNumberWithAnimation(1395f)
        tv_num2.showNumberWithAnimation(13900f)
        tv_num3.showNumberWithAnimation(40f)

        for (tabRow in table_layout.children) {
            for (tree in (tabRow as TableRow).children) {
                childIndex++
                val anim = ObjectAnimator.ofFloat(tree, "alpha", 0.1f, 1f)
                anim.duration = 500
                anim.startDelay = childIndex * 20.toLong()
                anim.start()
            }
        }

        levelView.startAnim()
    }

    private var root1V = false
    private var root2V = false
    private var root3V = false
    private var bottom1V = false
    private var bottom2V = false
    private var bottom3V = false

    override fun initListener() {
        rootView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener
        { _, _, scrollY, _, _ ->
            if (rl_root1.getLocalVisibleRect(this, scrollY) && !root1V) {
                root1V = true
                rl_root1.startAnim()
            }
            if (rl_root2.getLocalVisibleRect(this, scrollY) && !root2V) {
                root2V = true
                rl_root2.startAnim()
            }
            if (rl_root3.getLocalVisibleRect(this, scrollY) && !root3V) {
                root3V = true
                rl_root3.startAnim()
            }

            if (rl_bottom1.getLocalVisibleRect(this, scrollY) && !bottom1V) {
                bottom1V = true
                rl_bottom1.startAnim()
            }
            if (rl_bottom2.getLocalVisibleRect(this, scrollY) && !bottom2V) {
                bottom2V = true
                rl_bottom2.startAnim()
            }
            if (rl_bottom3.getLocalVisibleRect(this, scrollY) && !bottom3V) {
                bottom3V = true
                rl_bottom3.startAnim()
            }
        })
    }

    private fun View.startAnim() {
        val startDelay = if(this is RelativeLayout) 500 else 200
        val anim =
            ObjectAnimator.ofFloat(this, "translationY", 0f, -15.dp2px().toFloat())
        anim.duration = 1000
        anim.startDelay = startDelay.toLong()
        anim.start()
    }

    override fun onBackPressed() { rootView.finishPage(this)}
}