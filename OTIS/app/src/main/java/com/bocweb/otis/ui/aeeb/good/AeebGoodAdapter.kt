package com.bocweb.otis.ui.aeeb.good

import android.view.View
import android.widget.ImageView
import com.bocweb.otis.R
import com.bocweb.otis.util.setClickNoRepeat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder


class AeebGoodAdapter(data: MutableList<AeebGoodInfo>) :
    BaseQuickAdapter<AeebGoodInfo, BaseViewHolder>(R.layout.adapter_aeeb_good, data) {

    override fun convert(holder: BaseViewHolder, item: AeebGoodInfo) {
        holder.apply {
            getView<ImageView>(R.id.iv_img).setBackgroundResource(item.imgBg)
            setText(R.id.tv_title, item.title)
            setText(R.id.tv_desc, item.desc)
            getView<ImageView>(R.id.iv_num).setBackgroundResource(item.num)
            setGone(R.id.v1,adapterPosition != 0)

            getView<View>(R.id.tv_action_play).setClickNoRepeat {

            }
        }
    }
}