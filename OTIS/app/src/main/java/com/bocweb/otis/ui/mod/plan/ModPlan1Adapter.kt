package com.bocweb.otis.ui.mod.plan

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.bocweb.otis.R
import com.bocweb.otis.app.data.InfoData
import com.bocweb.otis.util.dp2px
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class ModPlan1Adapter(data: MutableList<InfoData>) :
    BaseQuickAdapter<InfoData, BaseViewHolder>(R.layout.adapter_mod_plan1, data) {

    init {
        addChildClickViewIds(R.id.iv_action)
    }

    override fun convert(holder: BaseViewHolder, item: InfoData) {
        holder.apply {
            setBackgroundResource(R.id.iv_no, item.label1)
            setBackgroundResource(R.id.iv_bg, item.bigImg)
            setText(R.id.tv_desc1, item.desc1)
            setText(R.id.tv_desc2, item.desc2)
            setText(R.id.tv_desc3, item.desc3)
            if (item.desc4.isNotEmpty()) {
                setText(R.id.tv_desc4, item.desc4)
                setGone(R.id.tv_desc4, false)
            } else {
                setGone(R.id.tv_desc4, true)
            }


            val tvTitle = getView<TextView>(R.id.tv_title)
            tvTitle.text = item.title
            tvTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(item.label2,0,0,0)
            val cv = getView<CardView>(R.id.cardView)
            val lp = cv.layoutParams
            val line = getView<View>(R.id.line)
            val lineLp = line.layoutParams
            if (holder.adapterPosition == 0) {
                lp.height = 385.dp2px()
                lineLp.height = 363.dp2px()

            } else {
                lp.height = 419.dp2px()
                lineLp.height = 397.dp2px()
            }
            cv.layoutParams = lp
            line.layoutParams = lineLp
        }
    }
}