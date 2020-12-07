package com.bocweb.otis.ui.aeeb.pretty.detail

import android.app.Activity
import com.bocweb.otis.R
import com.bocweb.otis.util.load
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.showImage
import com.bocweb.otis.util.ui.SquareImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class AeebPrettyDetailAdapter(private val activity: Activity, data: MutableList<ImageInfo>) :
    BaseQuickAdapter<ImageInfo, BaseViewHolder>(
        R.layout.adapter_aeeb_pretty_detail, data
    ) {

    override fun convert(holder: BaseViewHolder, item: ImageInfo) {
        holder.apply {
            val squareIV = getView<SquareImageView>(R.id.image)
            squareIV.load(item.url)

            squareIV.setClickNoRepeat {
                squareIV.showImage(activity, data, holder.adapterPosition)
            }
        }
    }
}