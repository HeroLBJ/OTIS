package com.bocweb.otis.ui.aeeb.spare

import com.bocweb.otis.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class AeebSpareAdapter(data: MutableList<AeebSpareInfo>?) :
    BaseQuickAdapter<AeebSpareInfo, BaseViewHolder>(R.layout.adapter_aeeb_spare, data) {

    override fun convert(holder: BaseViewHolder, item: AeebSpareInfo) {
        holder.apply {
            setText(R.id.tv_no, item.no)
            setText(R.id.tv_title, item.title)
            setImageResource(R.id.iv_bg, item.image)
        }
    }
}