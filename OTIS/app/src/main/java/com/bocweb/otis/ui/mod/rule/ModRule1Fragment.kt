package com.bocweb.otis.ui.mod.rule

import androidx.core.view.get
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseFragment
import com.bocweb.otis.ui.mod.chart.ModChartActivity
import com.bocweb.otis.ui.mod.page.ModPageActivity
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPage
import com.bocweb.otis.util.startPageIndex
import kotlinx.android.synthetic.main.fragment_mob_rule1.*

class ModRule1Fragment : BaseFragment() {
    override fun getLayoutId() = R.layout.fragment_mob_rule1

    override fun initListener() {
        tv_action.setClickNoRepeat { it.startPage(requireActivity(), ModChartActivity::class.java) }
        iv_play.setClickNoRepeat {

        }

        for (index in 0 until rl_actions.childCount) {
            rl_actions[index].setClickNoRepeat {
                it.startPageIndex(requireActivity(), ModPageActivity::class.java, index)
            }
        }
    }
}