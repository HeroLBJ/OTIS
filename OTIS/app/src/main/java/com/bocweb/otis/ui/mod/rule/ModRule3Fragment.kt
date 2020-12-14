package com.bocweb.otis.ui.mod.rule

import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseFragment
import com.bocweb.otis.ui.mod.plan.ModPlan1Activity
import com.bocweb.otis.ui.mod.plan.ModPlan2Activity
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPage
import kotlinx.android.synthetic.main.fragment_mob_rule3.*

class ModRule3Fragment : BaseFragment() {
    override fun getLayoutId() = R.layout.fragment_mob_rule3

    override fun initListener() {
        iv_action_top.setClickNoRepeat {
            it.startPage(requireActivity(), ModPlan1Activity::class.java)
        }
        iv_action_bottom.setClickNoRepeat {
            it.startPage(requireActivity(), ModPlan2Activity::class.java)
        }
    }
}