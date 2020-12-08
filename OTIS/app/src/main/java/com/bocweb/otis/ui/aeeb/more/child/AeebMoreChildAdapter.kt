package com.bocweb.otis.ui.aeeb.more.child

import android.content.Intent
import android.view.View
import com.bocweb.otis.R
import com.bocweb.otis.ui.aeeb.common.AeebInfo
import com.bocweb.otis.ui.aeeb.more.detail.AeebMoreDetailActivity
import com.bocweb.otis.util.setClickNoRepeat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class AeebMoreChildAdapter(data: MutableList<AeebInfo>) :
    BaseQuickAdapter<AeebInfo, BaseViewHolder>(
        R.layout.adapter_aeeb_more_child, data
    ) {
    override fun convert(holder: BaseViewHolder, item: AeebInfo) {
        holder.apply {
            setBackgroundColor(R.id.iv_bg, item.image1)
            setText(R.id.tv_title, item.title)
            setText(R.id.tv_desc, item.desc1)
            setBackgroundColor(R.id.iv_no, item.image2)

            getView<View>(R.id.action).setClickNoRepeat {
                val intent = Intent(context, AeebMoreDetailActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}