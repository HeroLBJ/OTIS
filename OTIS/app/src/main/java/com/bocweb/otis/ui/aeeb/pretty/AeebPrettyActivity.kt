package com.bocweb.otis.ui.aeeb.pretty

import android.graphics.Color
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.ui.layoutmanager.card.CardLayoutManager
import com.bocweb.otis.util.ui.layoutmanager.card.CardTouchHelperCallback
import com.bocweb.otis.util.ui.layoutmanager.card.OnSwipeListener
import kotlinx.android.synthetic.main.activity_aeeb_pretty.*

class AeebPrettyActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_aeeb_pretty

    private val adapter by lazy { AeebPrettyAdapter(list) }
    private val list by lazy { arrayListOf<AeebPrettyInfo>() }

    override fun initView() {
        list.add(AeebPrettyInfo(Color.parseColor("#66ff0000"),"外观的美"))
        list.add(AeebPrettyInfo(Color.parseColor("#6600ff00"),"内饰的美"))
        recyclerView.adapter = adapter
        val cardCallback = CardTouchHelperCallback(adapter, list)
        val touchHelper = ItemTouchHelper(cardCallback)
        val clm = CardLayoutManager(recyclerView,touchHelper)
        recyclerView.layoutManager = clm
        touchHelper.attachToRecyclerView(recyclerView)

        cardCallback.setOnSwipedListener(object : OnSwipeListener<AeebPrettyInfo> {
            override fun onSwiping(
                viewHolder: RecyclerView.ViewHolder,
                ratio: Float,
                direction: Int
            ) {

            }

            override fun onSwiped(
                viewHolder: RecyclerView.ViewHolder,
                t: AeebPrettyInfo,
                direction: Int
            ) {
                list.add(t)
                adapter.notifyDataSetChanged()
            }

            override fun onSwipedClear() {

            }

        })
    }
}