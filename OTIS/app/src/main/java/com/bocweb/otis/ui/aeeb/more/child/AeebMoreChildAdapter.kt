package com.bocweb.otis.ui.aeeb.more.child

import com.bocweb.otis.R
import com.bocweb.otis.ui.aeeb.common.AeebInfo
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class AeebMoreChildAdapter(data: MutableList<AeebInfo>) :
    BaseQuickAdapter<AeebInfo, BaseViewHolder>(
        R.layout.adapter_aeeb_more_child, data
    ) {
    override fun convert(holder: BaseViewHolder, item: AeebInfo) {
        holder.apply {
            setBackgroundColor(R.id.iv_bg, item.image1)
            setText(R.id.tv_title,item.title)
            setText(R.id.tv_desc,item.desc1)
            setBackgroundColor(R.id.iv_no,item.image2)
        }
    }
}