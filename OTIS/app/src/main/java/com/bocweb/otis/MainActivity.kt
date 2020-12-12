package com.bocweb.otis

import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.ui.aeeb.AeebSplashActivity

import com.bocweb.otis.ui.mod.ModSplashActivity
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_main

    override fun initListener() {
        btn_aeeb.setClickNoRepeat { it.startPage(this, AeebSplashActivity::class.java) }

        btn_mod.setClickNoRepeat { it.startPage(this, ModSplashActivity::class.java) }
    }

}