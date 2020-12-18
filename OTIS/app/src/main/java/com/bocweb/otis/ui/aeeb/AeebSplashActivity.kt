package com.bocweb.otis.ui.aeeb

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.*
import kotlinx.android.synthetic.main.activity_splash_aeeb.*

class AeebSplashActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_splash_aeeb

    private val duration1 = 1200L // 将aeeb移动到中间
    private val duration2 = 500L // 缩小aeeb
    private val duration3 = 500L // 移动aeeb到顶部,展示电梯
    private val duration4 = 1200L // 显示logo

    override fun initData() {
        startAnim1()
    }

    private fun startAnim1() {
        val set = AnimatorSet()
        val animLineStart1 =
            ObjectAnimator.ofFloat(line_start_1, "scaleY", 0f, getScreenHeight().toFloat())
        val animLineStart2 =
            ObjectAnimator.ofFloat(line_start_2, "scaleY", 0f, getScreenHeight().toFloat())
        val animLineStart3 =
            ObjectAnimator.ofFloat(line_start_3, "scaleY", 0f, getScreenHeight().toFloat())
        val animLineStart4 =
            ObjectAnimator.ofFloat(line_start_4, "scaleY", 0f, getScreenHeight().toFloat())
        val animLineStart5 =
            ObjectAnimator.ofFloat(line_start_5, "scaleY", 0f, getScreenHeight().toFloat())
        val animTextStart1 = ObjectAnimator.ofFloat(
            tv_start_1, "translationY", -getScreenHeight() / 2.toFloat(), 0f
        )
        val animTextStart2 = ObjectAnimator.ofFloat(
            tv_start_2, "translationY", -getScreenHeight() / 2.toFloat(), 0f
        )
        animTextStart2.interpolator = DecelerateInterpolator()
        val animTextStart3 = ObjectAnimator.ofFloat(
            tv_start_3, "translationY", getScreenHeight() / 2.toFloat(), 0f
        )
        val animTextStart4 = ObjectAnimator.ofFloat(
            tv_start_4, "translationY", getScreenHeight() / 2.toFloat(), 0f
        )
        animTextStart4.interpolator = DecelerateInterpolator()
        set.play(animLineStart1).with(animLineStart2).with(animLineStart3).with(animLineStart4)
            .with(animLineStart5).with(animTextStart1).with(animTextStart2).with(animTextStart3)
            .with(animTextStart4)
        set.duration = duration1
        set.start()
        set.doOnEnd { startAnim2() }
    }

    private fun startAnim2() {
        val set = AnimatorSet()
        val animTextScaleX1 = ObjectAnimator.ofFloat(tv_start_1, "scaleX", 1f, 0.25f)
        val animTextScaleY1 = ObjectAnimator.ofFloat(tv_start_1, "scaleY", 1f, 0.25f)
        val animTextScaleX2 = ObjectAnimator.ofFloat(tv_start_2, "scaleX", 1f, 0.25f)
        val animTextScaleY2 = ObjectAnimator.ofFloat(tv_start_2, "scaleY", 1f, 0.25f)
        val animTextScaleX3 = ObjectAnimator.ofFloat(tv_start_3, "scaleX", 1f, 0.25f)
        val animTextScaleY3 = ObjectAnimator.ofFloat(tv_start_3, "scaleY", 1f, 0.25f)
        val animTextScaleX4 = ObjectAnimator.ofFloat(tv_start_4, "scaleX", 1f, 0.25f)
        val animTextScaleY4 = ObjectAnimator.ofFloat(tv_start_4, "scaleY", 1f, 0.25f)
        val animTextTX1 =
            ObjectAnimator.ofFloat(tv_start_1, "translationX", 0f, 70.dp2px().toFloat())
        val animTextTX2 =
            ObjectAnimator.ofFloat(tv_start_2, "translationX", 0f, 22.dp2px().toFloat())
        val animTextTX3 = ObjectAnimator.ofFloat(
            tv_start_3, "translationX", 0f,
            (-22).dp2px().toFloat()
        )
        val animTextTX4 = ObjectAnimator.ofFloat(
            tv_start_4, "translationX", 0f,
            (-70).dp2px().toFloat()
        )
        set.play(animTextScaleX1).with(animTextScaleY1).with(animTextScaleX2).with(animTextScaleY2)
            .with(animTextScaleX3).with(animTextScaleY3).with(animTextScaleX4).with(animTextScaleY4)
            .with(animTextTX1).with(animTextTX2).with(animTextTX3).with(animTextTX4)
        set.duration = duration2
        set.start()
        set.doOnEnd { startAnim3() }
    }

    private fun startAnim3() {
        val set = AnimatorSet()
        val animTextTY1 = ObjectAnimator.ofFloat(
            tv_start_1, "translationY",
            50.dp2px() - getScreenHeight() / 2.toFloat()
        )
        val animTextTY2 = ObjectAnimator.ofFloat(
            tv_start_2, "translationY",
            50.dp2px() - getScreenHeight() / 2.toFloat()
        )
        val animTextTY3 = ObjectAnimator.ofFloat(
            tv_start_3, "translationY",
            50.dp2px() - getScreenHeight() / 2.toFloat()
        )
        val animTextTY4 = ObjectAnimator.ofFloat(
            tv_start_4, "translationY",
            50.dp2px() - getScreenHeight() / 2.toFloat()
        )
        val animLineA1 = ObjectAnimator.ofFloat(line_start_1, "alpha", 1f, 0f)
        val animLineA2 = ObjectAnimator.ofFloat(line_start_2, "alpha", 1f, 0f)
        val animLineA4 = ObjectAnimator.ofFloat(line_start_4, "alpha", 1f, 0f)
        val animLineA5 = ObjectAnimator.ofFloat(line_start_5, "alpha", 1f, 0f)
        val animLX1 =
            ObjectAnimator.ofFloat(line_center_x1, "scaleX", 0f, getScreenWidth().toFloat())
        val animLineX2 =
            ObjectAnimator.ofFloat(line_center_x2, "scaleX", 0f, getScreenWidth().toFloat())
        val animLineX3 =
            ObjectAnimator.ofFloat(line_center_x3, "scaleX", 0f, getScreenWidth().toFloat())
        val animLineX4 =
            ObjectAnimator.ofFloat(line_center_x4, "scaleX", 0f, getScreenWidth().toFloat())
        val animLineX5 =
            ObjectAnimator.ofFloat(line_center_x5, "scaleX", 0f, getScreenWidth().toFloat())
        val animLineX6 =
            ObjectAnimator.ofFloat(line_center_x6, "scaleX", 0f, getScreenWidth().toFloat())
        val animLineX7 =
            ObjectAnimator.ofFloat(line_center_x7, "scaleX", 0f, getScreenWidth().toFloat())
        val animLineX8 =
            ObjectAnimator.ofFloat(line_center_x8, "scaleX", 0f, getScreenWidth().toFloat())
        val animLineY1 =
            ObjectAnimator.ofFloat(line_center_y1, "scaleY", 0f, getScreenHeight().toFloat())
        val animLineY2 =
            ObjectAnimator.ofFloat(line_center_y2, "scaleY", 0f, getScreenHeight().toFloat())
        val animLineY3 =
            ObjectAnimator.ofFloat(line_center_y3, "scaleY", 0f, getScreenHeight().toFloat())
        val animLineY4 =
            ObjectAnimator.ofFloat(line_center_y4, "scaleY", 0f, getScreenHeight().toFloat())
        val animRect11 = ObjectAnimator.ofFloat(rect_line1_num1, "alpha", 0f, 1f)
        val animRect12 = ObjectAnimator.ofFloat(rect_line1_num2, "alpha", 0f, 1f)
        val animRect13 = ObjectAnimator.ofFloat(rect_line1_num3, "alpha", 0f, 1f)
        val animRect14 = ObjectAnimator.ofFloat(rect_line1_num4, "alpha", 0f, 1f)
        val animRect21 = ObjectAnimator.ofFloat(rect_line2_num1, "alpha", 0f, 1f)
        val animRect22 = ObjectAnimator.ofFloat(rect_line2_num2, "alpha", 0f, 1f)
        val animRect23 = ObjectAnimator.ofFloat(rect_line2_num3, "alpha", 0f, 1f)
        val animRect24 = ObjectAnimator.ofFloat(rect_line2_num4, "alpha", 0f, 1f)
        val animRect31 = ObjectAnimator.ofFloat(rect_line3_num1, "alpha", 0f, 1f)
        val animRect32 = ObjectAnimator.ofFloat(rect_line3_num2, "alpha", 0f, 1f)
        val animRect33 = ObjectAnimator.ofFloat(rect_line3_num3, "alpha", 0f, 1f)
        val animRect34 = ObjectAnimator.ofFloat(rect_line3_num4, "alpha", 0f, 1f)
        val animRect41 = ObjectAnimator.ofFloat(rect_line4_num1, "alpha", 0f, 1f)
        val animRect42 = ObjectAnimator.ofFloat(rect_line4_num2, "alpha", 0f, 1f)
        val animRect43 = ObjectAnimator.ofFloat(rect_line4_num3, "alpha", 0f, 1f)
        val animRect44 = ObjectAnimator.ofFloat(rect_line4_num4, "alpha", 0f, 1f)
        set.play(animTextTY1).with(animTextTY2).with(animTextTY3).with(animTextTY4).with(animLineA1)
            .with(animLineA2).with(animLineA4).with(animLineA5).with(animLX1).with(animLineX2)
            .with(animLineX3).with(animLineX4).with(animLineX5).with(animLineX6).with(animLineX7)
            .with(animLineX8).with(animLineY1).with(animLineY2).with(animLineY3).with(animLineY4)
            .with(animRect11).with(animRect12).with(animRect13).with(animRect14).with(animRect21)
            .with(animRect22).with(animRect23).with(animRect24).with(animRect31).with(animRect32)
            .with(animRect33).with(animRect34).with(animRect41).with(animRect42).with(animRect43)
            .with(animRect44)
        set.duration = duration3
        set.start()
        set.doOnEnd { startAnim4() }
    }

    private fun startAnim4() {
        val set = AnimatorSet()
        val anim1 = ObjectAnimator.ofFloat(iv_title, "alpha", 0f, 1f)
        val anim2 = ObjectAnimator.ofFloat(iv_title, "translationY", 150f, 0f)
        val anim3 = ObjectAnimator.ofFloat(iv_action, "alpha", 0f, 1f)
        set.play(anim1).with(anim2).with(anim3)
        set.duration = duration4
        set.start()
        set.doOnEnd { actionNextPage() }
    }

    private fun actionNextPage() {
        val intent = Intent(this, AeebMainActivity::class.java)
        val transitionActivityOptions =
            ActivityOptions.makeSceneTransitionAnimation(
                this,
                iv_action,
                "action"
            )
        startActivity(intent, transitionActivityOptions.toBundle())
        ActivityUtil.addFinish(this)
    }
}