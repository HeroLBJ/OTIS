package com.bocweb.otis.ui.mod.page

import cn.youngkaaa.yviewpager.YViewPager
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.ui.mod.chart.ModChartActivity
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPage
import com.bocweb.otis.util.startPageAnim
import com.bocweb.otis.util.ui.ModBottomView
import kotlinx.android.synthetic.main.activity_mod_page.*
import kotlinx.android.synthetic.main.fragment_mob_rule1.rootView

class ModPageActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_page

    private val currentPage by lazy { intent.getIntExtra("page", 0) }

    override fun initView() {
        rootView.startPageAnim(this)
        rl_back.setClickNoRepeat { onBackPressed() }

        tpView.setCurrentIndex(currentPage)

        view_pager.adapter = ModPageAdapter(supportFragmentManager)
        view_pager.currentItem = currentPage
        view_pager.addOnPageChangeListener(object : YViewPager.OnPageChangeListener {
            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                tpView.setCurrentIndex(p0)
            }

            override fun onPageScrollStateChanged(p0: Int) {

            }

        })

        cv_action.setClickNoRepeat {
            it.startPage(this@ModPageActivity, ModChartActivity::class.java)
        }
    }

    override fun onBackPressed() {
        rootView.finishPage(this)
    }
}