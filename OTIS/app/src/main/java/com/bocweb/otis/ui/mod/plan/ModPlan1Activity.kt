package com.bocweb.otis.ui.mod.plan

import androidx.recyclerview.widget.LinearLayoutManager
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.app.data.getModPlan1List
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_mod_plan1.*

class ModPlan1Activity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_plan1

    private val adapter by lazy { ModPlan1Adapter(getModPlan1List()) }

    override fun initView() {
        rootView.startPageAnim(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        rl_back.setClickNoRepeat { onBackPressed() }
    }

    override fun onBackPressed() {
        rootView.finishPage(this)
    }
}