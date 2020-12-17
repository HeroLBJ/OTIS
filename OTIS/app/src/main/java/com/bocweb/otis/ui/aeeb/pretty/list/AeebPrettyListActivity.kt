package com.bocweb.otis.ui.aeeb.pretty.list

import androidx.fragment.app.Fragment
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.ui.aeeb.pretty.detail.AeebPrettyDetailChildFragment
import com.bocweb.otis.util.*
import kotlinx.android.synthetic.main.activity_aeeb_pretty_list.*
import kotlinx.android.synthetic.main.activity_aeeb_pretty_list.indicator
import kotlinx.android.synthetic.main.activity_aeeb_pretty_list.rootView
import kotlinx.android.synthetic.main.activity_aeeb_pretty_list.vp_pager

class AeebPrettyListActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_aeeb_pretty_list

    private val fragments = arrayListOf<Fragment>(
        AeebPrettyList1Fragment(),
        AeebPrettyList2Fragment()
    )
    private val titles = arrayListOf("外观", "内饰")

    override fun initView() {
        rootView.startPageAnim(this)
        rl_back.setClickNoRepeat { onBackPressed() }

        vp_pager.init(supportFragmentManager, fragments)
        indicator.bindViewPager(vp_pager, titles,selectTextSize = 20f,indicatorColor = R.color.transparent)
    }

    override fun onBackPressed() {
        rootView.finishPage(this)
    }
}