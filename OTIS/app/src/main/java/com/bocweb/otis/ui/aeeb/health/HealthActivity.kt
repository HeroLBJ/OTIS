package com.bocweb.otis.ui.aeeb.health

import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.dp2px
import com.bocweb.otis.util.init
import com.bocweb.otis.util.setClickNoRepeat
import kotlinx.android.synthetic.main.activity_l1_health.*
import kotlinx.android.synthetic.main.include_title_l1.*

class HealthActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_l1_health

    override fun initTitle() {
        iv_back.setClickNoRepeat { finish() }
    }

    private val fragmentList = arrayListOf<Fragment>(
        Health1Fragment(),
        Health2Fragment(),
        Health3Fragment()
    )

    override fun initView() {
        banner.adapter = HealthAdapter(this)
        banner.offscreenPageLimit = 3
        banner.pageMargin = 10.dp2px()

        banner.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                vp_pager.setCurrentItem(position, true)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

        vp_pager.init(supportFragmentManager, fragmentList)

    }
}