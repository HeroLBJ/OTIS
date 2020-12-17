package com.bocweb.otis.ui.mod.scroll

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bocweb.otis.R
import com.bocweb.otis.util.setClickNoRepeat

class ModScrollAdapter(private val context: Context) : PagerAdapter() {
    override fun getCount() = 4

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val rootView =
            LayoutInflater.from(context).inflate(R.layout.adapter_mod_scroll, container, false)
        val llInfo = rootView.findViewById<View>(R.id.ll_info)
        val ivBg = rootView.findViewById<ImageView>(R.id.iv_bg)
        when (position) {
            1 -> {
                ivBg.setBackgroundResource(R.drawable.mod_scroll_big_2)
                llInfo.visibility = View.GONE
            }
            2 -> {
                ivBg.setBackgroundResource(R.drawable.mod_scroll_big_3)
                llInfo.visibility = View.GONE
            }
            3 -> {
                ivBg.setBackgroundResource(R.drawable.mod_scroll_big_4)
                llInfo.visibility = View.GONE
            }
            else -> {
                ivBg.setBackgroundResource(R.drawable.mod_scroll_big_1)
                llInfo.visibility = View.VISIBLE
            }
        }
        container.addView(rootView)
        return rootView
    }
}