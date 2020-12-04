package com.bocweb.otis.ui.aeeb.health

import android.animation.ObjectAnimator
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.animation.doOnEnd
import androidx.core.view.children
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseFragment
import com.bocweb.otis.util.dp2px
import kotlinx.android.synthetic.main.fragment_l1_health1.*
import java.util.*

class Health1Fragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_l1_health1

    override fun initView() {
        initOld()
        initNew()
        initBottom()
        initWind()
    }

    private val random by lazy { Random() }

    /**
     * 吹风
     */
    private fun initWind() {
        val anim1 = ObjectAnimator.ofFloat(iv_wind1, "alpha", 1f, 0f)
        anim1.duration = 700
        anim1.repeatCount = ObjectAnimator.INFINITE
        anim1.start()

        val anim2 = ObjectAnimator.ofFloat(iv_wind2, "alpha", 1f, 0f)
        anim2.duration = 700
        anim2.repeatCount = ObjectAnimator.INFINITE
        anim2.startDelay = 350
        anim2.start()
    }

    private fun initOld() {
        fl_old.removeAllViews()
        for (index in 0..6) {
            fl_old.addView(createOldView())
        }
        fl_old.children.forEach {
            runOld(it)
        }
    }

    private fun runOld(view: View) {
        val anim = ObjectAnimator.ofFloat(
            view, "translationY", 0f,
            30.dp2px() + random.nextInt(15).dp2px().toFloat()
        )
        anim.duration = random.nextInt(4000).toLong() + 2000
        anim.start()
        anim.doOnEnd {
            runOld(createOldViewParams(view))
        }
    }

    private fun initNew() {
        fl_new.removeAllViews()
        for (index in 0..10) {
            fl_new.addView(createNewView())
        }
        fl_new.children.forEach {
            runNew(it)
        }
    }

    private fun runNew(view: View) {
        val anim1 =
            ObjectAnimator.ofFloat(view, "translationX", 0f, random.nextInt(80).dp2px().toFloat())
        val anim2 =
            ObjectAnimator.ofFloat(
                view,
                "translationY",
                0f,
                110.dp2px() + random.nextInt(70).dp2px().toFloat()
            )
        anim1.duration = random.nextInt(8000).toLong() + 8000
        anim2.duration = random.nextInt(8000).toLong() + 8000
        anim1.start()
        anim2.start()

        anim2.doOnEnd {
            runNew(createNewViewParams(view))
        }
    }

    private fun initBottom() {
        fl_bottom.removeAllViews()
        for (index in 0..10) {
            fl_bottom.addView(createBottomView())
        }
        fl_bottom.children.forEach {
            runBottom(it)
        }
    }

    private fun runBottom(view: View) {
        val anim1 =
            ObjectAnimator.ofFloat(view, "alpha", 1f, random.nextFloat())
        anim1.duration = random.nextInt(5000).toLong() + 5000
        anim1.start()

        anim1.doOnEnd {
            runBottom(createBottomViewParams(view))
        }
    }

    private fun createOldView(): View {
        val iv = ImageView(requireContext())
        return createOldViewParams(iv)
    }

    private fun createOldViewParams(view: View): View {
        val size = (random.nextInt(8) + 8).dp2px()
        val lp = FrameLayout.LayoutParams(size, size)
        lp.marginStart = random.nextInt(50.dp2px())
        lp.topMargin = random.nextInt(20.dp2px())
        view.layoutParams = lp
        view.rotation = 360 * random.nextFloat()
        view.setBackgroundResource(R.drawable.health_bad)
        return view
    }

    private fun createNewView(): View {
        val iv = ImageView(requireContext())
        return createNewViewParams(iv)
    }

    private fun createNewViewParams(view: View): View {
        val size = (random.nextInt(10) + 10).dp2px()
        val lp = FrameLayout.LayoutParams(size, size)
        lp.marginStart = random.nextInt(30.dp2px())
        lp.topMargin = random.nextInt(30.dp2px())
        view.layoutParams = lp
        view.rotation = 360 * random.nextFloat()
        view.setBackgroundResource(R.drawable.health_kongqi)
        return view
    }

    private fun createBottomView(): View {
        val iv = ImageView(requireContext())
        return createBottomViewParams(iv)
    }

    private fun createBottomViewParams(view: View): View {
        val size = (random.nextInt(10) + 10).dp2px()
        val lp = FrameLayout.LayoutParams(size, size)
        lp.marginStart = random.nextInt(80.dp2px())
        lp.topMargin = random.nextInt(70.dp2px())
        view.layoutParams = lp
        view.rotation = 360 * random.nextFloat()
        view.setBackgroundResource(R.drawable.health_kongqi)
        return view
    }
}