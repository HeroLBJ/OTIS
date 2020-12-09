package com.bocweb.otis.ui.aeeb.pretty

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.ui.aeeb.common.AeebInfo
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.getAeebPrettyData
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPageAnim
import com.bocweb.otis.util.ui.layoutmanager.card.CardLayoutManager
import com.bocweb.otis.util.ui.layoutmanager.card.CardTouchHelperCallback
import com.bocweb.otis.util.ui.layoutmanager.card.OnSwipeListener
import kotlinx.android.synthetic.main.activity_aeeb_pretty.*
import kotlinx.android.synthetic.main.activity_aeeb_pretty.rootView
import kotlinx.android.synthetic.main.include_title_l1.*

class AeebPrettyActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_aeeb_pretty

    private val adapter by lazy { AeebPrettyAdapter(list) }
    private val list by lazy { getAeebPrettyData() }

    override fun initTitle() {
        tv_title.text = "奥的斯美学"
    }

    override fun initView() {
        rootView.startPageAnim(this)

        recyclerView.adapter = adapter
        val cardCallback = CardTouchHelperCallback(adapter, list)
        val touchHelper = ItemTouchHelper(cardCallback)
        val clm = CardLayoutManager(recyclerView, touchHelper)
        recyclerView.layoutManager = clm
        touchHelper.attachToRecyclerView(recyclerView)

        cardCallback.setOnSwipedListener(object : OnSwipeListener<AeebInfo> {
            override fun onSwiping(
                viewHolder: RecyclerView.ViewHolder,
                ratio: Float,
                direction: Int
            ) {

            }

            override fun onSwiped(
                viewHolder: RecyclerView.ViewHolder,
                t: AeebInfo,
                direction: Int
            ) {
                list.add(t)
                adapter.notifyDataSetChanged()
            }

            override fun onSwipedClear() {

            }
        })
    }

    override fun initListener() {
        rl_back.setClickNoRepeat { onBackPressed() }
    }

    override fun onBackPressed() {
        rootView.finishPage(this)
    }
}