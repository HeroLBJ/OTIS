package com.bocweb.otis.ui.aeeb.pretty

import android.app.Activity
import android.view.View
import com.bocweb.otis.R
import com.bocweb.otis.ui.aeeb.common.AeebInfo
import com.bocweb.otis.ui.aeeb.pretty.detail.AeebPrettyDetailActivity
import com.bocweb.otis.ui.aeeb.pretty.list.AeebPrettyListActivity
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPage
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class AeebPrettyAdapter(private val act:Activity,data: MutableList<AeebInfo>) :
    BaseQuickAdapter<AeebInfo, BaseViewHolder>
        (R.layout.adapter_aeeb_pretty, data) {

    override fun convert(holder: BaseViewHolder, item: AeebInfo) {
        holder.apply {
            getView<View>(R.id.iv_bg).setBackgroundResource(item.image1)
            setText(R.id.tv_title, item.title)

            val rootView = getView<View>(R.id.rootView)
            rootView.setClickNoRepeat {
                rootView.startPage(act, AeebPrettyListActivity::class.java)
            }
        }
    }

}