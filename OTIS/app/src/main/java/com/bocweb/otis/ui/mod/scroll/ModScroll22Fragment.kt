package com.bocweb.otis.ui.mod.scroll

import android.view.View
import androidx.core.content.ContextCompat
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseFragment
import com.bocweb.otis.util.dp2px
import com.bocweb.otis.util.setClickNoRepeat
import kotlinx.android.synthetic.main.fragment_mod_scroll_22.*
import kotlinx.android.synthetic.main.include_scroll_label.*

class ModScroll22Fragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_mod_scroll_22

    private var lastIndex = 0

    override fun initView() {
        uploadTextInfo(0)
    }

    override fun initListener() {
        tv_label1.setClickNoRepeat { uploadTextInfo(0) }
        tv_label2.setClickNoRepeat { uploadTextInfo(1) }
        tv_label3.setClickNoRepeat { uploadTextInfo(2) }
    }

    private fun uploadTextInfo(index: Int) {
        uploadScrollLabelText(index)
        tv_good3.visibility = View.VISIBLE
        tv_bad2.visibility = View.VISIBLE
        tv_bad3.visibility = View.VISIBLE
        when (index) {
            0 -> {
                tv_good1.text = "节省安装工时"
                tv_good2.text = "原建筑装潢无影响"
                tv_good3.text = "成本优势"
                tv_bad1.text = "无法满足新国标要求"
                tv_bad2.text = "原厅门系统性无法保证"
                tv_bad3.visibility = View.INVISIBLE

                iv_big.setBackgroundResource(R.drawable.mod_scroll_big1)
                label_bg.translationX = 0f
            }
            1 -> {
                tv_good1.text = "原建筑装潢影响小"
                tv_good2.text = "性能部分升级"
                tv_good3.visibility = View.INVISIBLE
                tv_bad1.text = "需要地质监局确认可以验收"
                tv_bad2.text = "门厅滑块支架非标"
                tv_bad3.text = "适用性差"

                iv_big.setBackgroundResource(R.drawable.mod_scroll_big2)
                label_bg.translationX = width
            }
            2 -> {
                tv_good1.text = "原建筑装潢影响小"
                tv_good2.text = "性能全面升级"
                tv_good3.text = "满足最新国标要求"
                tv_bad1.text = "需要非标门套与门头连接件"
                tv_bad2.visibility = View.INVISIBLE
                tv_bad3.visibility = View.INVISIBLE

                iv_big.setBackgroundResource(R.drawable.mod_scroll_big3)
                label_bg.translationX = 2 * width
            }
        }
        lastIndex = index
    }

    private var width = 90.dp2px().toFloat()
    private fun uploadScrollLabelText(index: Int) {
        tv_label1.setTextColor(ContextCompat.getColor(requireContext(),R.color.black_141A29))
        tv_label2.setTextColor(ContextCompat.getColor(requireContext(),R.color.black_141A29))
        tv_label3.setTextColor(ContextCompat.getColor(requireContext(),R.color.black_141A29))
        when (index) {
            0 -> { tv_label1.setTextColor(ContextCompat.getColor(requireContext(),R.color.info_label_color)) }
            1 -> { tv_label2.setTextColor(ContextCompat.getColor(requireContext(),R.color.info_label_color)) }
            2 -> { tv_label3.setTextColor(ContextCompat.getColor(requireContext(),R.color.info_label_color)) }
        }
    }
}