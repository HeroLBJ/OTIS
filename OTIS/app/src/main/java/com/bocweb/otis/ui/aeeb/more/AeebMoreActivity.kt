package com.bocweb.otis.ui.aeeb.more

import androidx.viewpager2.widget.ViewPager2
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_aeeb_more.*
import kotlinx.android.synthetic.main.activity_aeeb_more.rootView
import kotlinx.android.synthetic.main.activity_l1_health.*
import kotlinx.android.synthetic.main.include_aeeb_more_title1.*
import kotlinx.android.synthetic.main.include_aeeb_more_title2.*

class AeebMoreActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_aeeb_more

    override fun initView() {
        rootView.startPageAnim(this)

        vp2_pager.orientation = ViewPager2.ORIENTATION_VERTICAL
        vp2_pager.adapter = AeebMoreAdapter(this)
    }

    override fun onBackPressed() { rootView.finishPage(this) }
}