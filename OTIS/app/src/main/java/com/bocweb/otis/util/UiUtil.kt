package com.bocweb.otis.util

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bocweb.otis.util.ui.MaxViewPager
import com.to.aboomy.banner.Banner

fun ViewPager.init(
    fragmentM: FragmentManager,
    fragments: ArrayList<Fragment>
): ViewPager {
    overScrollMode = View.OVER_SCROLL_NEVER
    adapter = object : FragmentPagerAdapter(fragmentM) {
        override fun getItem(position: Int) = fragments[position]
        override fun getCount() = fragments.size
    }
    return this
}

fun MaxViewPager.init(
    fragmentM: FragmentManager,
    fragments: ArrayList<Fragment>
): MaxViewPager {
    overScrollMode = View.OVER_SCROLL_NEVER
    adapter = object : FragmentPagerAdapter(fragmentM) {
        override fun getItem(position: Int) = fragments[position]
        override fun getCount() = fragments.size
    }
    return this
}

fun Banner.setNoMorePages(items:List<Any>){

}