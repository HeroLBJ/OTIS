package com.bocweb.otis.ui.mod.plan

import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.ui.mod.chart.ModChartActivity
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPage
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_mod_plan2.*

class ModPlan2Activity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_plan2

    override fun initView() {
        rootView.startPageAnim(this)

        rl_bottom.setClickNoRepeat {
            rootView.startPage(this, ModChartActivity::class.java)
        }
    }

    override fun onBackPressed() {
        rootView.finishPage(this)
    }
}