package com.bocweb.otis.ui.aeeb.health

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bocweb.otis.R

class HealthAdapter(private val context: Context) : PagerAdapter() {
    override fun getCount() = 3

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    @SuppressLint("SetTextI18n")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_l1_health, null)
        val ivBg = view.findViewById<ImageView>(R.id.iv_bg)
        val tvIndex = view.findViewById<TextView>(R.id.tv_index)
        val tvTitle = view.findViewById<TextView>(R.id.tv_adapter_title)

        tvIndex.text = "隐患${1 + position}"
        when (position) {
            1 -> {
                tvTitle.text = "电梯轿壁传播病毒"
                ivBg.setBackgroundResource(R.drawable.health_big1)
            }
            2 -> {
                tvTitle.text = "电梯按钮传播病毒"
                ivBg.setBackgroundResource(R.drawable.health_big2)
            }
            else -> {
                tvTitle.text = "电梯密闭空间空气易污染"
                ivBg.setBackgroundResource(R.drawable.health_big3)
            }
        }

        container.addView(view)

        return view
    }
}