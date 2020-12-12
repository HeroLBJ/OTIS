package com.bocweb.otis.ui.mod.rule

import android.view.View
import android.widget.Toast
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseFragment
import com.bocweb.otis.util.setClickNoRepeat
import kotlinx.android.synthetic.main.fragment_mob_rule3.*

class ModRule3Fragment : BaseFragment() {
    override fun getLayoutId() = R.layout.fragment_mob_rule3

    override fun initListener() {
        action_top.setClickNoRepeat {
            Toast.makeText(requireContext(),"机电改造",Toast.LENGTH_LONG).show()
        }
        action_bottom.setClickNoRepeat {
            Toast.makeText(requireContext(),"整梯换新",Toast.LENGTH_LONG).show()
        }
    }

    fun onActionTop(it: View){

    }

    fun onActionBottom(it: View){

    }
}