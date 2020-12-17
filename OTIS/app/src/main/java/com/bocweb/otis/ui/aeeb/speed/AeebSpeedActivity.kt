package com.bocweb.otis.ui.aeeb.speed

import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_aeeb_speed.*
import kotlinx.android.synthetic.main.include_title_l1.*

class AeebSpeedActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_aeeb_speed

    override fun initView() {
        rootView.startPageAnim(this)

        tv_title.text = "一体化安装流程"
    }
}