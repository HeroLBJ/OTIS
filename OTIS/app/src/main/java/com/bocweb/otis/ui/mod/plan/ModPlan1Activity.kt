package com.bocweb.otis.ui.mod.plan

import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.ui.mod.scroll.ModScroll2Activity
import com.bocweb.otis.ui.mod.scroll.ModScrollActivity
import com.bocweb.otis.util.*
import kotlinx.android.synthetic.main.activity_mod_plan1.*
import kotlinx.android.synthetic.main.include_mod_plan_1.*

class ModPlan1Activity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_plan1

    override fun initView() {
        rootView.startPageAnim(this)
        rl_back.setClickNoRepeat { onBackPressed() }

        iv_action1.setClickNoRepeat {
            it.startPage(this, ModScrollActivity::class.java)
        }
        iv_action2.setClickNoRepeat {
            it.startPage(this, ModScroll2Activity::class.java)
        }
    }

    override fun onBackPressed() {
        rootView.finishPage(this)
    }
}