package com.bocweb.otis.ui.aeeb.more

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bocweb.otis.R
import com.bocweb.otis.ui.aeeb.common.AeebInfo
import com.bocweb.otis.ui.aeeb.common.getAeebMoreBottomData
import com.bocweb.otis.ui.aeeb.common.getAeebMoreTopData
import com.bocweb.otis.ui.aeeb.more.child.AeebMoreChildAdapter
import com.bocweb.otis.util.ui.CardIndexView
import com.bocweb.otis.util.ui.layoutmanager.card.CardLayoutManager
import com.bocweb.otis.util.ui.layoutmanager.card.CardTouchHelperCallback
import com.bocweb.otis.util.ui.layoutmanager.card.OnSwipeListener

class AeebMoreAdapter(private val context: Context) :
    RecyclerView.Adapter<AeebMoreAdapter.ViewHolder>() {

    private val inflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.adapter_aeeb_more, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = if (position == 0) getAeebMoreTopData() else getAeebMoreBottomData()
        holder.cardIndexView.maxLine = list.size
        if (position == 0) {
            holder.rlTop.visibility = View.VISIBLE
            holder.rlBottom.visibility = View.GONE
        } else {
            holder.rlTop.visibility = View.GONE
            holder.rlBottom.visibility = View.VISIBLE
        }
        val adapter = AeebMoreChildAdapter(list)
        holder.recyclerView.adapter = adapter

        val cardCallback = CardTouchHelperCallback(adapter, list)
        val touchHelper = ItemTouchHelper(cardCallback)
        val clm = CardLayoutManager(holder.recyclerView, touchHelper)
        holder.recyclerView.layoutManager = clm
        touchHelper.attachToRecyclerView(holder.recyclerView)

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
                holder.cardIndexView.currentIndex = if (t.no + 1 > list.size) {
                    0
                } else {
                    t.no + 1
                }
                list.add(t)
                adapter.notifyDataSetChanged()
            }

            override fun onSwipedClear() {

            }
        })
    }

    override fun getItemCount() = 2

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView by lazy { itemView.findViewById(R.id.recyclerView) }
        val rlTop: View by lazy { itemView.findViewById(R.id.rl1) }
        val rlBottom: View by lazy { itemView.findViewById(R.id.rl2) }
        val cardIndexView: CardIndexView by lazy { itemView.findViewById(R.id.cardIndexView) }
    }
}