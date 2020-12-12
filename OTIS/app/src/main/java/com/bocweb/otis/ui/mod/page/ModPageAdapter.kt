package com.bocweb.otis.ui.mod.page

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import cn.youngkaaa.yviewpager.YFragmentPagerAdapter

class ModPageAdapter(fm: FragmentManager) : YFragmentPagerAdapter(fm) {

    private val fragmentList by lazy {
        arrayListOf<Fragment>(
            ModPage1Fragment(),
            ModPage2Fragment(),
            ModPage3Fragment(),
            ModPage4Fragment(),
            ModPage5Fragment(),
        )
    }

    override fun getCount() = fragmentList.size
    override fun getItem(p0: Int) = fragmentList[p0]
}