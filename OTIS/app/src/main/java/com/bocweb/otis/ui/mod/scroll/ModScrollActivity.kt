package com.bocweb.otis.ui.mod.scroll

import android.view.View
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.dp2px
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_mod_scroll.*

class ModScrollActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_scroll

    override fun initView() {
        rootView.startPageAnim(this)
        vp_pager.adapter = ModScrollAdapter(this)

        setCurrentIndex(0)
        vp_pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                rootView.postDelayed({ setCurrentIndex(position)},300)
            }
        })
    }

    private fun setCurrentIndex(index: Int) {
        ll_index.removeAllViews()
        for (i in 0..2) {
            val pointV = View(this)
            val params = LinearLayout.LayoutParams(3.dp2px(), 3.dp2px())
            params.marginEnd = 5.dp2px()
            pointV.setBackgroundResource(R.drawable.shape_yellow_circle_3)
            pointV.layoutParams = params
            ll_index.addView(pointV)
        }
        val pointV = View(this)
        val params = LinearLayout.LayoutParams(17.dp2px(), 3.dp2px())
        params.marginEnd = 5.dp2px()
        pointV.setBackgroundResource(R.drawable.shape_yellow_rect_3)
        pointV.layoutParams = params
        ll_index.addView(pointV, index)
    }
}