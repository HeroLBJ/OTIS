package com.bocweb.otis.ui.mod.scroll

import android.view.View
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import com.blankj.utilcode.util.ToastUtils
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.*
import kotlinx.android.synthetic.main.activity_mod_scroll.*
import kotlinx.android.synthetic.main.activity_mod_scroll.vp_pager

class ModScrollActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_scroll

    private var viewPagerIndex = 0

    override fun initView() {
        rootView.startPageAnim(this)
        vp_pager.adapter = ModScrollAdapter(this)

        setCurrentIndex(0)
        vp_pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {

            override fun onPageScrollStateChanged(state: Int) {
                if (state == 1) {
                    viewPagerIndex = vp_pager.currentItem
                }
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (viewPagerIndex == position && position == 3) {
                    jumpNextPage()
                }
            }

            override fun onPageSelected(position: Int) {
                rootView.postDelayed({ setCurrentIndex(position) }, 300)
                iv_back.visibility = if (position == 0) View.GONE else View.VISIBLE
            }
        })

        iv_back.setClickNoRepeat { onBackPressed() }
    }

    private var lastClickTime = 0L
    private fun jumpNextPage() {
        val currentTime = System.currentTimeMillis()
        if (lastClickTime != 0L && (currentTime - lastClickTime < 500)) {
            rootView.startPage(
                this, ModScroll2Activity::class.java, getScreenWidth(), getScreenHeight() / 2
            )
        } else {
            lastClickTime = currentTime
        }
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

    override fun onBackPressed() {
        rootView.finishPage(this)
    }
}