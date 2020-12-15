package com.bocweb.otis.ui.mod.scroll

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import cn.youngkaaa.yviewpager.YFragmentPagerAdapter

class ModScroll2Adapter(fm: FragmentManager) : YFragmentPagerAdapter(fm) {

    private val fragmentList = arrayListOf<Fragment>(
        ModScroll21Fragment(),
        ModScroll22Fragment()
    )

    override fun getCount() = 2

    override fun getItem(p0: Int) = fragmentList[p0]
}