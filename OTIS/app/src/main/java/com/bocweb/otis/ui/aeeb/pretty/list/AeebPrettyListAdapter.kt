package com.bocweb.otis.ui.aeeb.pretty.list

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import cn.youngkaaa.yviewpager.YFragmentPagerAdapter

class AeebPrettyListAdapter(fm: FragmentManager) : YFragmentPagerAdapter(fm) {

    private val fragmentList = arrayListOf<Fragment>(
        AeebPrettyList1Fragment(),
        AeebPrettyList2Fragment()
    )

    override fun getCount() = fragmentList.size

    override fun getItem(p0: Int) = fragmentList[p0]
}