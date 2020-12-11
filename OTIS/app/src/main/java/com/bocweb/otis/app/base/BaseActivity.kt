package com.bocweb.otis.app.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ImmersionBar
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        createAgo()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        ImmersionBar.with(this).init()
        println("当前页面:${localClassName}")
        initTitle()
        initView()
        initListener()
        initData()
    }

    open fun createAgo() {}

    open fun initTitle() {}

    open fun initView() {}

    open fun initListener() {}

    open fun initData() {}

    abstract fun getLayoutId(): Int

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}