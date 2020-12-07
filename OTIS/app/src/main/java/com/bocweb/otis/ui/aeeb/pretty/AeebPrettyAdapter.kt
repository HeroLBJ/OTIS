package com.bocweb.otis.ui.aeeb.pretty

import android.content.Intent
import android.view.View
import com.bocweb.otis.R
import com.bocweb.otis.ui.aeeb.pretty.detail.AeebPrettyDetailActivity
import com.bocweb.otis.util.setClickNoRepeat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class AeebPrettyAdapter(data: MutableList<AeebPrettyInfo>) :
    BaseQuickAdapter<AeebPrettyInfo, BaseViewHolder>
        (R.layout.adapter_aeeb_pretty, data) {

    override fun convert(holder: BaseViewHolder, item: AeebPrettyInfo) {
        holder.apply {
            getView<View>(R.id.iv_bg).setBackgroundColor(item.color)
            setText(R.id.tv_title, item.title)

            getView<View>(R.id.action).setClickNoRepeat {
                val intent = Intent(context, AeebPrettyDetailActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}