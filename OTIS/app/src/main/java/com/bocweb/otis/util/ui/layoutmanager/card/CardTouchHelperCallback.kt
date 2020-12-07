package com.bocweb.otis.util.ui.layoutmanager.card

import android.graphics.Canvas
import android.view.View
import android.view.View.OnTouchListener
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class CardTouchHelperCallback<T> : ItemTouchHelper.Callback {
    private val adapter: RecyclerView.Adapter<*>
    private var dataList: MutableList<T>
    private var mListener: OnSwipeListener<T>? = null

    constructor(adapter: RecyclerView.Adapter<*>, dataList: MutableList<T>) {
        this.adapter = checkIsNull(adapter)
        this.dataList = checkIsNull(dataList)
    }

    constructor(
        adapter: RecyclerView.Adapter<*>,
        dataList: MutableList<T>,
        listener: OnSwipeListener<T>?
    ) {
        this.adapter = checkIsNull(adapter)
        this.dataList = checkIsNull(dataList)
        mListener = listener
    }

    private fun <T> checkIsNull(t: T?): T {
        return t ?: throw NullPointerException()
    }

    fun setOnSwipedListener(listener: OnSwipeListener<T>) {
        this.mListener = listener
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = 0
        var swipeFlags = 0
        val layoutManager = recyclerView.layoutManager
        if (layoutManager is CardLayoutManager) {
            swipeFlags = 12
        }
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        viewHolder.itemView.setOnTouchListener(null as OnTouchListener?)
        val layoutPosition = viewHolder.layoutPosition
        val remove: T = dataList.removeAt(layoutPosition)
        adapter.notifyDataSetChanged()
        if (mListener != null) {
            mListener!!.onSwiped(viewHolder, remove, if (direction == 4) 1 else 4)
        }
        if (adapter.itemCount == 0 && mListener != null) {
            mListener!!.onSwipedClear()
        }
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        val itemView = viewHolder.itemView
        if (actionState == 1) {
            var ratio = dX / getThreshold(recyclerView, viewHolder)
            if (ratio > 1.0f) {
                ratio = 1.0f
            } else if (ratio < -1.0f) {
                ratio = -1.0f
            }
            itemView.rotation = ratio * 15.0f
            val childCount = recyclerView.childCount
            var position: Int
            var index: Int
            var view: View
            if (childCount > 3) {
                position = 1
                while (position < childCount - 1) {
                    index = childCount - position - 1
                    view = recyclerView.getChildAt(position)
                    view.scaleX = 1.0f - index.toFloat() * 0.1f + Math.abs(ratio) * 0.1f
                    view.scaleY = 1.0f - index.toFloat() * 0.1f + Math.abs(ratio) * 0.1f
                    view.translationY =
                        (index.toFloat() - Math.abs(ratio)) * itemView.measuredHeight
                            .toFloat() / 18.0f
                    ++position
                }
            } else {
                position = 0
                while (position < childCount - 1) {
                    index = childCount - position - 1
                    view = recyclerView.getChildAt(position)
                    view.scaleX = 1.0f - index.toFloat() * 0.1f + Math.abs(ratio) * 0.1f
                    view.scaleY = 1.0f - index.toFloat() * 0.1f + Math.abs(ratio) * 0.1f
                    view.translationY =
                        (index.toFloat() - Math.abs(ratio)) * itemView.measuredHeight
                            .toFloat() / 18.0f
                    ++position
                }
            }
            if (mListener != null) {
                if (ratio != 0.0f) {
                    mListener!!.onSwiping(viewHolder, ratio, if (ratio < 0.0f) 4 else 8)
                } else {
                    mListener!!.onSwiping(viewHolder, ratio, 1)
                }
            }
        }
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        viewHolder.itemView.rotation = 0.0f
    }

    private fun getThreshold(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Float {
        return recyclerView.width.toFloat() * getSwipeThreshold(viewHolder)
    }
}
