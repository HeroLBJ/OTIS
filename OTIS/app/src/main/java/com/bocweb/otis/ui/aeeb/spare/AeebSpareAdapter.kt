package com.bocweb.otis.ui.aeeb.spare

import android.view.View
import com.bocweb.otis.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class AeebSpareAdapter(data: MutableList<AeebSpareInfo>?) :
    BaseQuickAdapter<AeebSpareInfo, BaseViewHolder>(R.layout.adapter_aeeb_spare, data) {

    private val animRootList = arrayListOf<View>()
    private val animBottomList = arrayListOf<View>()

    override fun convert(holder: BaseViewHolder, item: AeebSpareInfo) {
        holder.apply {
            setText(R.id.tv_no, item.no)
            setText(R.id.tv_title, item.title)
            setImageResource(R.id.iv_bg, item.image)

            val rlRoot = getView<View>(R.id.rl_root)
            val rlBottom = getView<View>(R.id.rl_bottom)
            if (animBottomList.size < data.size) animBottomList.add(rlBottom)
            if (animRootList.size < data.size) animRootList.add(rlRoot)
        }
    }
}