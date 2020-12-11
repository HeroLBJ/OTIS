package com.bocweb.otis.ui.mod.rule

import android.view.View
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_mob_rule.*

class MobRuleActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mob_rule

    override fun initView() {
        rootView.startPageAnim(this)
    }

    fun onAction(it: View) {
        it.finishPage(this)
    }

    override fun onBackPressed() {
        rootView.finishPage(this)
    }
}