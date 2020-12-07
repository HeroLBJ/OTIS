package com.bocweb.otis.util.ui.layoutmanager.card

import android.annotation.SuppressLint
import android.view.View
import android.view.View.OnTouchListener
import androidx.core.view.MotionEventCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class CardLayoutManager(
    private val recyclerView: RecyclerView,
    private val itemTouchHelper: ItemTouchHelper
) :
    RecyclerView.LayoutManager() {
    @SuppressLint("ClickableViewAccessibility")
    private val mOnTouchListener = OnTouchListener { v, event ->
        val childViewHolder = this@CardLayoutManager.recyclerView.getChildViewHolder(v)
        if (MotionEventCompat.getActionMasked(event) == 0) {
            itemTouchHelper.startSwipe(childViewHolder)
        }
        false
    }

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(-2, -2)
    }

    private val translationParam = 18

    override fun onLayoutChildren(recycler: Recycler, state: RecyclerView.State) {
        detachAndScrapAttachedViews(recycler)
        val itemCount = this.itemCount
        var position: Int
        var view: View
        var widthSpace: Int
        var heightSpace: Int
        if (itemCount > 3) {
            position = 3
            while (position >= 0) {
                view = recycler.getViewForPosition(position)
                this.addView(view)
                measureChildWithMargins(view, 0, 0)
                widthSpace = this.width - getDecoratedMeasuredWidth(view)
                heightSpace = this.height - getDecoratedMeasuredHeight(view)
                layoutDecoratedWithMargins(
                    view,
                    widthSpace / 2,
                    heightSpace / 2,
                    widthSpace / 2 + getDecoratedMeasuredWidth(view),
                    heightSpace / 2 + getDecoratedMeasuredHeight(view)
                )
                if (position == 3) {
                    view.scaleX = 1.0f - (position - 1).toFloat() * 0.1f
                    view.scaleY = 1.0f - (position - 1).toFloat() * 0.1f
                    view.translationY = ((position - 1) * view.measuredHeight / translationParam).toFloat()
                } else if (position > 0) {
                    view.scaleX = 1.0f - position.toFloat() * 0.1f
                    view.scaleY = 1.0f - position.toFloat() * 0.1f
                    view.translationY = (position * view.measuredHeight / translationParam).toFloat()
                } else {
                    view.setOnTouchListener(mOnTouchListener)
                }
                --position
            }
        } else {
            position = itemCount - 1
            while (position >= 0) {
                view = recycler.getViewForPosition(position)
                this.addView(view)
                measureChildWithMargins(view, 0, 0)
                widthSpace = this.width - getDecoratedMeasuredWidth(view)
                heightSpace = this.height - getDecoratedMeasuredHeight(view)
                layoutDecoratedWithMargins(
                    view,
                    widthSpace / 2,
                    heightSpace / 2,
                    widthSpace / 2 + getDecoratedMeasuredWidth(view),
                    heightSpace / 2 + getDecoratedMeasuredHeight(view)
                )
                if (position > 0) {
                    view.scaleX = 1.0f - position.toFloat() * 0.1f
                    view.scaleY = 1.0f - position.toFloat() * 0.1f
                    view.translationY = (position * view.measuredHeight / translationParam).toFloat()
                } else {
                    view.setOnTouchListener(mOnTouchListener)
                }
                --position
            }
        }
    }
}