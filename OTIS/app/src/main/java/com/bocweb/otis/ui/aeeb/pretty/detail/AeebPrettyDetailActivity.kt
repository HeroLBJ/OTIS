package com.bocweb.otis.ui.aeeb.pretty.detail

import androidx.fragment.app.Fragment
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.bindViewPager
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.init
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_aeeb_pretty_detail.*

class AeebPrettyDetailActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_aeeb_pretty_detail

    private val fragments = arrayListOf<Fragment>(
        AeebPrettyDetailChildFragment(),
        AeebPrettyDetailChildFragment()
    )
    private val titles = arrayListOf("外观", "内饰")

    override fun initView() {
        rootView.startPageAnim(this)

        vp_pager.init(supportFragmentManager, fragments)
        indicator.bindViewPager(vp_pager, titles)
    }

    override fun onBackPressed() {rootView.finishPage(this)}
}