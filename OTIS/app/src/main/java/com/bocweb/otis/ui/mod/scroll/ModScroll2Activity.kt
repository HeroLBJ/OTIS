package com.bocweb.otis.ui.mod.scroll

import android.view.View
import android.widget.LinearLayout
import cn.youngkaaa.yviewpager.YViewPager
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.dp2px
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_mod_scroll2.*
import kotlinx.android.synthetic.main.activity_mod_scroll2.rootView
import kotlinx.android.synthetic.main.activity_mod_scroll2.vp_pager

class ModScroll2Activity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_scroll2

    override fun initView() {
        rootView.startPageAnim(this)
        vp_pager.adapter = ModScroll2Adapter(supportFragmentManager)

        setCurrentIndex(0)
        vp_pager.addOnPageChangeListener(object : YViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                rootView.postDelayed({ setCurrentIndex(position) }, 300)
                tv_back.visibility = if (position == 0) View.GONE else View.VISIBLE
            }
        })
        tv_back.setClickNoRepeat { onBackPressed() }
    }

    override fun onBackPressed() {
        rootView.finishPage(this)
    }

    private fun setCurrentIndex(index: Int) {
        ll_index.removeAllViews()

        val pointV1 = View(this)
        val params1 = LinearLayout.LayoutParams(3.dp2px(), 3.dp2px())
        params1.marginEnd = 5.dp2px()
        pointV1.setBackgroundResource(R.drawable.shape_yellow_circle_3)
        pointV1.layoutParams = params1
        ll_index.addView(pointV1)
        val pointV = View(this)
        val params = LinearLayout.LayoutParams(17.dp2px(), 3.dp2px())
        params.marginEnd = 5.dp2px()
        pointV.setBackgroundResource(R.drawable.shape_yellow_rect_3)
        pointV.layoutParams = params
        ll_index.addView(pointV, index)
    }
}