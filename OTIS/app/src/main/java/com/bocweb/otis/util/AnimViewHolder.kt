package com.bocweb.otis.util

import android.animation.Animator
import android.view.View
import androidx.core.view.ViewCompat
import com.chad.library.adapter.base.viewholder.BaseViewHolder

open class AnimViewHolder(private val itemView: View) : BaseViewHolder(itemView),Animator.AnimatorListener {
    override fun onAnimationStart(animation: Animator?) {
        ViewCompat.animate(itemView)
            .translationY(-itemView.height * 0.3f)
            .alpha(0f)
            .setDuration(3000)
            .start()
    }

    override fun onAnimationEnd(animation: Animator?) {

    }

    override fun onAnimationCancel(animation: Animator?) {

    }

    override fun onAnimationRepeat(animation: Animator?) {

    }


}
