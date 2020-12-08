package com.bocweb.otis.ui.aeeb.more

import androidx.viewpager2.widget.ViewPager2
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import kotlinx.android.synthetic.main.activity_aeeb_more.*

class AeebMoreActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_aeeb_more

    override fun initView() {
        vp2_pager.orientation = ViewPager2.ORIENTATION_VERTICAL
        vp2_pager.adapter = AeebMoreAdapter(this)
    }
}