package com.bocweb.otis.ui.mod.chart

import android.app.Activity
import android.content.Intent
import android.view.View
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.ui.mod.rule.ModRuleActivity
import com.bocweb.otis.util.*
import kotlinx.android.synthetic.main.activity_mod_chart.*
import kotlinx.android.synthetic.main.fragment_mob_rule1.rootView

class ModChartActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_mod_chart

    override fun initView() {
        rootView.startPageAnim(this)
    }

    override fun initListener() {
        iv_back.setClickNoRepeat { rootView.startPage(this, ModRuleActivity::class.java) }
        tv_action_left.setClickNoRepeat {
            it.startPage(this, ModChartChildActivity::class.java)
        }
    }

    override fun onBackPressed() {
        rootView.startPage(this, ModRuleActivity::class.java)
    }

    fun View.startPage(
        context: Activity,
        cls: Class<*>?,
        position:Int = 0,
        pointX: Int = 0,
        pointY: Int = 0
    ) {
        val intent = Intent(context, cls)
        intent.putExtra("X", if (pointX == 0) getCenterX() else pointX)
        intent.putExtra("Y", if (pointY == 0) getCenterY() else pointY)
        intent.putExtra("position", 0)
        context.startActivity(intent)
    }
}