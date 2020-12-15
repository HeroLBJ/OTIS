package com.bocweb.otis.ui.mod.chart

import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_mod_chart.*
import kotlinx.android.synthetic.main.activity_mod_chart_child.rl_bottom
import kotlinx.android.synthetic.main.activity_mod_plan2.rootView

class ModChartChildActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_chart_child

    override fun initView() {
        rootView.startPageAnim(this)

        tv_back.setClickNoRepeat {
            onBackPressed()
        }
        rl_bottom.setClickNoRepeat {

        }
    }

    override fun onBackPressed() {
        rootView.finishPage(this)
    }
}