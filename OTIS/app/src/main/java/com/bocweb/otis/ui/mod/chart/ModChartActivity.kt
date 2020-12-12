package com.bocweb.otis.ui.mod.chart

import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_mod_chart.*
import kotlinx.android.synthetic.main.fragment_mob_rule1.rootView

class ModChartActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_chart

    override fun initView() {
        rootView.startPageAnim(this)
    }

    override fun initListener() {
        tv_back.setClickNoRepeat { onBackPressed() }
    }

    override fun onBackPressed() { rootView.finishPage(this)}
}