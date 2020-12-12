package com.bocweb.otis.ui.mod.rule

import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import kotlinx.android.synthetic.main.activity_mod_rule.*

class ModRuleActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_rule

    override fun initView() {
        viewpager.adapter = ModRuleAdapter(supportFragmentManager)
    }

}