package com.bocweb.otis.ui.adapter

import android.app.Activity
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bocweb.otis.R
import com.bocweb.otis.app.data.PrettyInfo
import com.bocweb.otis.ui.aeeb.pretty.detail.AeebPrettyDetailActivity
import com.bocweb.otis.util.load
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPage
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class SuperAdapter(private val act: Activity, list: MutableList<SuperMultiItem>) :
    BaseMultiItemQuickAdapter<SuperMultiItem, BaseViewHolder>(list) {

    init {
        // aeeb->美->整个item
        addItemType(SuperMultiItem.Item_01, R.layout.adapter_item_01)
        // aeeb->美->item图片
        addItemType(SuperMultiItem.Item_02, R.layout.adapter_item_02)
        // aeeb->美->查看全部
        addItemType(SuperMultiItem.Item_03, R.layout.adapter_item_03)

        // 20dp
        addItemType(SuperMultiItem.Item_100, R.layout.adapter_item_100)
    }

    override fun convert(holder: BaseViewHolder, item: SuperMultiItem) {
        when (holder.itemViewType) {
            SuperMultiItem.Item_01 -> item01(holder, item)
            SuperMultiItem.Item_02 -> item02(holder, item)
            SuperMultiItem.Item_03 -> item03(holder, item)
            SuperMultiItem.Item_100 -> item100(holder, item)
        }
    }

    private fun item00(holder: BaseViewHolder, item: SuperMultiItem) {

    }

    private fun item03(holder: BaseViewHolder, item: SuperMultiItem) {
        val result = item.data as String
        holder.apply {
            setGone(R.id.empty, adapterPosition % 3 == 0)
            getView<ImageView>(R.id.iv_img).load(result)
        }
    }

    private fun item02(holder: BaseViewHolder, item: SuperMultiItem) {
        val result = item.data as String
        holder.apply {
            setGone(R.id.empty, adapterPosition != 0 && adapterPosition != 1)
            getView<ImageView>(R.id.iv_img).load(result)
        }
    }

    private fun item01(holder: BaseViewHolder, item: SuperMultiItem) {
        val result = item.data as PrettyInfo
        holder.apply {
            setText(R.id.tv_title, result.title)
            val list = arrayListOf<SuperMultiItem>()
            result.list.forEach {
                list.add(SuperMultiItem(SuperMultiItem.Item_02, it))
            }
            val adapter = SuperAdapter(act, list)
            val recyclerView = getView<RecyclerView>(R.id.recyclerView)
            val glm = GridLayoutManager(context, 2)
            glm.orientation = RecyclerView.HORIZONTAL
            recyclerView.layoutManager = glm
            recyclerView.adapter = adapter
            getView<View>(R.id.action_all).setClickNoRepeat {
                it.startPage(act, AeebPrettyDetailActivity::class.java)
            }
        }
    }

    private fun item100(holder: BaseViewHolder, item: SuperMultiItem) {

    }
}