package com.bocweb.otis.ui.mod.rule

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import cn.youngkaaa.yviewpager.YFragmentPagerAdapter

class ModRuleAdapter(fm: FragmentManager) : YFragmentPagerAdapter(fm) {

    private val fragmentList = arrayListOf<Fragment>(
        ModRule1Fragment(), ModRule2Fragment(), ModRule3Fragment()
    )

    override fun getCount() = fragmentList.size

    override fun getItem(index: Int): Fragment = fragmentList[index]
}