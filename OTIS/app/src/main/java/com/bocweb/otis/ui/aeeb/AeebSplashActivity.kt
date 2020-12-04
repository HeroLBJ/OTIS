package com.bocweb.otis.ui.aeeb

import android.animation.ObjectAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.dp2px
import com.bocweb.otis.util.getScreenHeight
import com.bocweb.otis.util.getScreenWidth
import com.bocweb.otis.util.setClickNoRepeat
import kotlinx.android.synthetic.main.activity_splash_aeeb.*

class AeebSplashActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_splash_aeeb

    private val duration = 3000L

    override fun initData() {
        startAnim1()

        iv_action.setClickNoRepeat {
            val intent = Intent(this, AeebMainActivity::class.java)
            val transitionActivityOptions =
                ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    iv_action,
                    "action"
                )
            startActivity(intent, transitionActivityOptions.toBundle())
        }
    }

    private fun startAnim1() {
        val animLineStart1 =
            ObjectAnimator.ofFloat(line_start_1, "scaleY", 0f, getScreenHeight().toFloat())
        animLineStart1.duration = duration
        animLineStart1.start()

        val animLineStart2 =
            ObjectAnimator.ofFloat(line_start_2, "scaleY", 0f, getScreenHeight().toFloat())
        animLineStart2.duration = duration
        animLineStart2.start()

        val animLineStart3 =
            ObjectAnimator.ofFloat(line_start_3, "scaleY", 0f, getScreenHeight().toFloat())
        animLineStart3.duration = duration
        animLineStart3.start()

        val animLineStart4 =
            ObjectAnimator.ofFloat(line_start_4, "scaleY", 0f, getScreenHeight().toFloat())
        animLineStart4.duration = duration
        animLineStart4.start()

        val animLineStart5 =
            ObjectAnimator.ofFloat(line_start_5, "scaleY", 0f, getScreenHeight().toFloat())
        animLineStart5.duration = duration
        animLineStart5.start()

        val animTextStart1 = ObjectAnimator.ofFloat(
            tv_start_1, "translationY", -getScreenHeight() / 2.toFloat(), 0f
        )
        animTextStart1.duration = duration
        animTextStart1.start()

        val animTextStart2 = ObjectAnimator.ofFloat(
            tv_start_2, "translationY", -getScreenHeight() / 2.toFloat(), 0f
        )
        animTextStart2.interpolator = DecelerateInterpolator()
        animTextStart2.duration = duration
        animTextStart2.start()

        val animTextStart3 = ObjectAnimator.ofFloat(
            tv_start_3, "translationY", getScreenHeight() / 2.toFloat(), 0f
        )
        animTextStart3.duration = duration
        animTextStart3.start()

        val animTextStart4 = ObjectAnimator.ofFloat(
            tv_start_4, "translationY", getScreenHeight() / 2.toFloat(), 0f
        )
        animTextStart4.interpolator = DecelerateInterpolator()
        animTextStart4.duration = duration
        animTextStart4.start()
        animLineStart4.doOnEnd {
            startAnim2()
        }
    }

    private fun startAnim2() {
        val animTextScaleX1 = ObjectAnimator.ofFloat(tv_start_1, "scaleX", 1f, 0.25f)
        animTextScaleX1.duration = duration
        animTextScaleX1.start()
        val animTextScaleY1 = ObjectAnimator.ofFloat(tv_start_1, "scaleY", 1f, 0.25f)
        animTextScaleY1.duration = duration
        animTextScaleY1.start()

        val animTextScaleX2 = ObjectAnimator.ofFloat(tv_start_2, "scaleX", 1f, 0.25f)
        animTextScaleX2.duration = duration
        animTextScaleX2.start()
        val animTextScaleY2 = ObjectAnimator.ofFloat(tv_start_2, "scaleY", 1f, 0.25f)
        animTextScaleY2.duration = duration
        animTextScaleY2.start()

        val animTextScaleX3 = ObjectAnimator.ofFloat(tv_start_3, "scaleX", 1f, 0.25f)
        animTextScaleX3.duration = duration
        animTextScaleX3.start()
        val animTextScaleY3 = ObjectAnimator.ofFloat(tv_start_3, "scaleY", 1f, 0.25f)
        animTextScaleY3.duration = duration
        animTextScaleY3.start()

        val animTextScaleX4 = ObjectAnimator.ofFloat(tv_start_4, "scaleX", 1f, 0.25f)
        animTextScaleX4.duration = duration
        animTextScaleX4.start()
        val animTextScaleY4 = ObjectAnimator.ofFloat(tv_start_4, "scaleY", 1f, 0.25f)
        animTextScaleY4.duration = duration
        animTextScaleY4.start()


        val animTextTranslationX1 =
            ObjectAnimator.ofFloat(tv_start_1, "translationX", 0f, 70.dp2px().toFloat())
        animTextTranslationX1.duration = duration
        animTextTranslationX1.start()

        val animTextTranslationX2 =
            ObjectAnimator.ofFloat(tv_start_2, "translationX", 0f, 22.dp2px().toFloat())
        animTextTranslationX2.duration = duration
        animTextTranslationX2.start()

        val animTextTranslationX3 = ObjectAnimator.ofFloat(
            tv_start_3, "translationX", 0f,
            (-22).dp2px().toFloat()
        )
        animTextTranslationX3.duration = duration
        animTextTranslationX3.start()

        val animTextTranslationX4 = ObjectAnimator.ofFloat(
            tv_start_4, "translationX", 0f,
            (-70).dp2px().toFloat()
        )
        animTextTranslationX4.duration = duration
        animTextTranslationX4.start()

        animTextTranslationX4.doOnEnd {
            startAnim3()
        }
    }

    private fun startAnim3() {
        val animTextTranslationY1 = ObjectAnimator.ofFloat(
            tv_start_1, "translationY",
            50.dp2px() - getScreenHeight() / 2.toFloat()
        )
        animTextTranslationY1.duration = duration
        animTextTranslationY1.start()

        val animTextTranslationY2 = ObjectAnimator.ofFloat(
            tv_start_2, "translationY",
            50.dp2px() - getScreenHeight() / 2.toFloat()
        )
        animTextTranslationY2.duration = duration
        animTextTranslationY2.start()

        val animTextTranslationY3 = ObjectAnimator.ofFloat(
            tv_start_3,
            "translationY",
            50.dp2px() - getScreenHeight() / 2.toFloat()
        )
        animTextTranslationY3.duration = duration
        animTextTranslationY3.start()

        val animTextTranslationY4 = ObjectAnimator.ofFloat(
            tv_start_4,
            "translationY",
            50.dp2px() - getScreenHeight() / 2.toFloat()
        )
        animTextTranslationY4.duration = duration
        animTextTranslationY4.start()

        val animLineAlpha1 = ObjectAnimator.ofFloat(line_start_1, "alpha", 1f, 0f)
        animLineAlpha1.duration = duration
        animLineAlpha1.start()
        val animLineAlpha2 = ObjectAnimator.ofFloat(line_start_2, "alpha", 1f, 0f)
        animLineAlpha2.duration = duration
        animLineAlpha2.start()
        val animLineAlpha4 = ObjectAnimator.ofFloat(line_start_4, "alpha", 1f, 0f)
        animLineAlpha4.duration = duration
        animLineAlpha4.start()
        val animLineAlpha5 = ObjectAnimator.ofFloat(line_start_5, "alpha", 1f, 0f)
        animLineAlpha5.duration = duration
        animLineAlpha5.start()


        val animLineX1 =
            ObjectAnimator.ofFloat(line_center_x1, "scaleX", 0f, getScreenWidth().toFloat())
        animLineX1.duration = duration
        animLineX1.start()
        val animLineX2 =
            ObjectAnimator.ofFloat(line_center_x2, "scaleX", 0f, getScreenWidth().toFloat())
        animLineX2.duration = duration
        animLineX2.start()
        val animLineX3 =
            ObjectAnimator.ofFloat(line_center_x3, "scaleX", 0f, getScreenWidth().toFloat())
        animLineX3.duration = duration
        animLineX3.start()
        val animLineX4 =
            ObjectAnimator.ofFloat(line_center_x4, "scaleX", 0f, getScreenWidth().toFloat())
        animLineX4.duration = duration
        animLineX4.start()
        val animLineX5 =
            ObjectAnimator.ofFloat(line_center_x5, "scaleX", 0f, getScreenWidth().toFloat())
        animLineX5.duration = duration
        animLineX5.start()
        val animLineX6 =
            ObjectAnimator.ofFloat(line_center_x6, "scaleX", 0f, getScreenWidth().toFloat())
        animLineX6.duration = duration
        animLineX6.start()
        val animLineX7 =
            ObjectAnimator.ofFloat(line_center_x7, "scaleX", 0f, getScreenWidth().toFloat())
        animLineX7.duration = duration
        animLineX7.start()
        val animLineX8 =
            ObjectAnimator.ofFloat(line_center_x8, "scaleX", 0f, getScreenWidth().toFloat())
        animLineX8.duration = duration
        animLineX8.start()

        val animLineY1 =
            ObjectAnimator.ofFloat(line_center_y1, "scaleY", 0f, getScreenHeight().toFloat())
        animLineY1.duration = duration
        animLineY1.start()
        val animLineY2 =
            ObjectAnimator.ofFloat(line_center_y2, "scaleY", 0f, getScreenHeight().toFloat())
        animLineY2.duration = duration
        animLineY2.start()
        val animLineY3 =
            ObjectAnimator.ofFloat(line_center_y3, "scaleY", 0f, getScreenHeight().toFloat())
        animLineY3.duration = duration
        animLineY3.start()
        val animLineY4 =
            ObjectAnimator.ofFloat(line_center_y4, "scaleY", 0f, getScreenHeight().toFloat())
        animLineY4.duration = duration
        animLineY4.start()

        val animRect11 = ObjectAnimator.ofFloat(rect_line1_num1, "alpha", 0f, 1f)
        animRect11.duration = duration
        animRect11.start()
        val animRect12 = ObjectAnimator.ofFloat(rect_line1_num2, "alpha", 0f, 1f)
        animRect12.duration = duration
        animRect12.start()
        val animRect13 = ObjectAnimator.ofFloat(rect_line1_num3, "alpha", 0f, 1f)
        animRect13.duration = duration
        animRect13.start()
        val animRect14 = ObjectAnimator.ofFloat(rect_line1_num4, "alpha", 0f, 1f)
        animRect14.duration = duration
        animRect14.start()
        val animRect21 = ObjectAnimator.ofFloat(rect_line2_num1, "alpha", 0f, 1f)
        animRect21.duration = duration
        animRect21.start()
        val animRect22 = ObjectAnimator.ofFloat(rect_line2_num2, "alpha", 0f, 1f)
        animRect22.duration = duration
        animRect22.start()
        val animRect23 = ObjectAnimator.ofFloat(rect_line2_num3, "alpha", 0f, 1f)
        animRect23.duration = duration
        animRect23.start()
        val animRect24 = ObjectAnimator.ofFloat(rect_line2_num4, "alpha", 0f, 1f)
        animRect24.duration = duration
        animRect24.start()
        val animRect31 = ObjectAnimator.ofFloat(rect_line3_num1, "alpha", 0f, 1f)
        animRect31.duration = duration
        animRect31.start()
        val animRect32 = ObjectAnimator.ofFloat(rect_line3_num2, "alpha", 0f, 1f)
        animRect32.duration = duration
        animRect32.start()
        val animRect33 = ObjectAnimator.ofFloat(rect_line3_num3, "alpha", 0f, 1f)
        animRect33.duration = duration
        animRect33.start()
        val animRect34 = ObjectAnimator.ofFloat(rect_line3_num4, "alpha", 0f, 1f)
        animRect34.duration = duration
        animRect34.start()
        val animRect41 = ObjectAnimator.ofFloat(rect_line4_num1, "alpha", 0f, 1f)
        animRect41.duration = duration
        animRect41.start()
        val animRect42 = ObjectAnimator.ofFloat(rect_line4_num2, "alpha", 0f, 1f)
        animRect42.duration = duration
        animRect42.start()
        val animRect43 = ObjectAnimator.ofFloat(rect_line4_num3, "alpha", 0f, 1f)
        animRect43.duration = duration
        animRect43.start()
        val animRect44 = ObjectAnimator.ofFloat(rect_line4_num4, "alpha", 0f, 1f)
        animRect44.duration = duration
        animRect44.start()

        animRect44.doOnEnd { startAnim4() }
    }

    private fun startAnim4() {
        val animTitleAlpha = ObjectAnimator.ofFloat(iv_title, "alpha", 0f, 1f)
        animTitleAlpha.duration = duration
        animTitleAlpha.start()
        val animTitleTranslation = ObjectAnimator.ofFloat(iv_title, "translationY", 150f, 0f)
        animTitleTranslation.duration = duration
        animTitleTranslation.start()

        val animActionAlpha = ObjectAnimator.ofFloat(iv_action, "alpha", 0f, 1f)
        animActionAlpha.duration = duration
        animActionAlpha.start()
    }
}