package com.bocweb.otis.ui.aeeb.health

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.widget.FrameLayout
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnRepeat
import androidx.core.animation.doOnStart
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseFragment
import com.bocweb.otis.util.dp2px
import com.bocweb.otis.util.setClickNoRepeat
import kotlinx.android.synthetic.main.include_health3_anim.*
import java.util.*
import kotlin.math.cos
import kotlin.math.sin

class Health3Fragment : BaseFragment() {
    override fun getLayoutId() = R.layout.fragment_l1_health3

    private val random by lazy { Random() }

    override fun initView() {
        isCancelAllAnim = false
        progressBar.progress = 0
        animGood()
        animBad()
        animProgress()
    }

    override fun initListener() {
        iv_repeat.setClickNoRepeat {
            iv_repeat.visibility = View.GONE
            isCancel = true
            if (!isCancelAllAnim) repeat1()
        }
    }

    private fun repeat1() {

        val set = AnimatorSet()
        val animAlpha1 = ObjectAnimator.ofFloat(iv_label_1, "alpha", 1f, 0f)
        val animAlpha2 = ObjectAnimator.ofFloat(iv_label_2, "alpha", 1f, 0f)
        val animAlpha3 = ObjectAnimator.ofFloat(iv_label_3, "alpha", 1f, 0f)
        val animAlpha4 = ObjectAnimator.ofFloat(iv_label_4, "alpha", 1f, 0f)
        val animAlpha5 = ObjectAnimator.ofFloat(iv_label_5, "alpha", 1f, 0f)
        val animAlpha6 = ObjectAnimator.ofFloat(iv_label_6, "alpha", 1f, 0f)
        val animAlpha7 = ObjectAnimator.ofFloat(iv_label_7, "alpha", 1f, 0f)
        val animAlpha8 = ObjectAnimator.ofFloat(iv_label_8, "alpha", 1f, 0f)

        val animScaleX1 = ObjectAnimator.ofFloat(iv_label_1, "scaleX", 2f, 0f)
        val animScaleX2 = ObjectAnimator.ofFloat(iv_label_2, "scaleX", 2f, 0f)
        val animScaleX3 = ObjectAnimator.ofFloat(iv_label_3, "scaleX", 2f, 0f)
        val animScaleX4 = ObjectAnimator.ofFloat(iv_label_4, "scaleX", 2f, 0f)
        val animScaleX5 = ObjectAnimator.ofFloat(iv_label_5, "scaleX", 2f, 0f)
        val animScaleX6 = ObjectAnimator.ofFloat(iv_label_6, "scaleX", 2f, 0f)
        val animScaleX7 = ObjectAnimator.ofFloat(iv_label_7, "scaleX", 2f, 0f)
        val animScaleX8 = ObjectAnimator.ofFloat(iv_label_8, "scaleX", 2f, 0f)

        val animScaleY1 = ObjectAnimator.ofFloat(iv_label_1, "scaleY", 2f, 0f)
        val animScaleY2 = ObjectAnimator.ofFloat(iv_label_2, "scaleY", 2f, 0f)
        val animScaleY3 = ObjectAnimator.ofFloat(iv_label_3, "scaleY", 2f, 0f)
        val animScaleY4 = ObjectAnimator.ofFloat(iv_label_4, "scaleY", 2f, 0f)
        val animScaleY5 = ObjectAnimator.ofFloat(iv_label_5, "scaleY", 2f, 0f)
        val animScaleY6 = ObjectAnimator.ofFloat(iv_label_6, "scaleY", 2f, 0f)
        val animScaleY7 = ObjectAnimator.ofFloat(iv_label_7, "scaleY", 2f, 0f)
        val animScaleY8 = ObjectAnimator.ofFloat(iv_label_8, "scaleY", 2f, 0f)

        val animTX1 = ObjectAnimator.ofFloat(iv_label_1, "translationX", -50.dp2px().toFloat(), 0f)
        val animTX2 = ObjectAnimator.ofFloat(iv_label_2, "translationX", 80.dp2px().toFloat(), 0f)
        val animTX3 = ObjectAnimator.ofFloat(iv_label_3, "translationX", -78.dp2px().toFloat(), 0f)
        val animTX4 = ObjectAnimator.ofFloat(iv_label_4, "translationX", 100.dp2px().toFloat(), 0f)
        val animTX5 = ObjectAnimator.ofFloat(iv_label_5, "translationX", -140.dp2px().toFloat(), 0f)
        val animTX6 = ObjectAnimator.ofFloat(iv_label_6, "translationX", 120.dp2px().toFloat(), 0f)
        val animTX7 = ObjectAnimator.ofFloat(iv_label_7, "translationX", -92.dp2px().toFloat(), 0f)
        val animTX8 = ObjectAnimator.ofFloat(iv_label_8, "translationX", 45.dp2px().toFloat(), 0f)

        val animTY1 = ObjectAnimator.ofFloat(iv_label_1, "translationY", -232.dp2px().toFloat(), 0f)
        val animTY2 = ObjectAnimator.ofFloat(iv_label_2, "translationY", -196.dp2px().toFloat(), 0f)
        val animTY3 = ObjectAnimator.ofFloat(iv_label_3, "translationY", -116.dp2px().toFloat(), 0f)
        val animTY4 = ObjectAnimator.ofFloat(iv_label_4, "translationY", -77.dp2px().toFloat(), 0f)
        val animTY5 = ObjectAnimator.ofFloat(iv_label_5, "translationY", 0f, 0f)
        val animTY6 = ObjectAnimator.ofFloat(iv_label_6, "translationY", 110.dp2px().toFloat(), 0f)
        val animTY7 = ObjectAnimator.ofFloat(iv_label_7, "translationY", 142.dp2px().toFloat(), 0f)
        val animTY8 = ObjectAnimator.ofFloat(iv_label_8, "translationY", 210.dp2px().toFloat(), 0f)

        set.play(animAlpha1).with(animAlpha2).with(animAlpha3).with(animAlpha4).with(animAlpha5)
            .with(animAlpha6).with(animAlpha7).with(animAlpha8).with(animScaleX1).with(animScaleX2)
            .with(animScaleX3).with(animScaleX4).with(animScaleX5).with(animScaleX6)
            .with(animScaleX7).with(animScaleX8).with(animScaleY1).with(animScaleY2)
            .with(animScaleY3).with(animScaleY4).with(animScaleY5).with(animScaleY6)
            .with(animScaleY7).with(animScaleY8).with(animTX1).with(animTX2).with(animTX3)
            .with(animTX4).with(animTX5).with(animTX6).with(animTX7).with(animTX8).with(animTY1)
            .with(animTY2).with(animTY3).with(animTY4).with(animTY5).with(animTY6).with(animTY7)
            .with(animTY8)
        set.start()

        set.doOnEnd {
            if(!isCancelAllAnim){
                repeat2()
            }else{
                set.cancel()
            }
        }
    }

    private fun repeat2() {
        if (progressBar == null) return
        progressBar.progress = 0
        fl_good.removeAllViews()
        fl_bad.removeAllViews()

        val anim11 = ObjectAnimator.ofFloat(fl_good, "alpha", 0f, 1f)
        anim11.duration = 1000
        anim11.start()

        val set = AnimatorSet()
        val anim1 = ObjectAnimator.ofFloat(progressBar, "alpha", 0f, 1f)
        val anim2 = ObjectAnimator.ofFloat(tv_good_title, "translationX", 66.dp2px().toFloat(), 0f)
        val anim3 = ObjectAnimator.ofFloat(tv_bad_title, "alpha", 0f, 1f)
        val anim4 = ObjectAnimator.ofFloat(rl_switch2, "alpha", 0f, 1f)
        val anim5 = ObjectAnimator.ofFloat(rl_switch1, "translationX", 66.dp2px().toFloat(), 0f)
        val anim6 = ObjectAnimator.ofFloat(tv_time1, "alpha", 0f, 1f)
        val anim7 = ObjectAnimator.ofFloat(tv_time2, "alpha", 0f, 1f)
        set.duration = 1000
        set.play(anim1).with(anim2).with(anim3).with(anim4).with(anim5).with(anim6).with(anim7)
        set.startDelay = 500
        set.start()

        set.doOnEnd {
            if(!isCancelAllAnim){
                animGood()
                animBad()
                animProgress()
            }else{
                set.cancel()
                anim11.cancel()
            }
        }
    }

    /**
     * 8个label移动到各自的位置
     */
    private fun animLabelTranslation() {
        val time1 = 1000L + random.nextInt(2000)
        val time2 = 1000L + random.nextInt(2000)
        val time3 = 1000L + random.nextInt(2000)
        val time4 = 1000L + random.nextInt(2000)
        val time5 = 1000L + random.nextInt(2000)
        val time6 = 1000L + random.nextInt(2000)
        val time7 = 1000L + random.nextInt(2000)
        val time8 = 1000L + random.nextInt(2000)
        val animAlpha1 = ObjectAnimator.ofFloat(iv_label_1, "alpha", 0f, 1f)
        val animAlpha2 = ObjectAnimator.ofFloat(iv_label_2, "alpha", 0f, 1f)
        val animAlpha3 = ObjectAnimator.ofFloat(iv_label_3, "alpha", 0f, 1f)
        val animAlpha4 = ObjectAnimator.ofFloat(iv_label_4, "alpha", 0f, 1f)
        val animAlpha5 = ObjectAnimator.ofFloat(iv_label_5, "alpha", 0f, 1f)
        val animAlpha6 = ObjectAnimator.ofFloat(iv_label_6, "alpha", 0f, 1f)
        val animAlpha7 = ObjectAnimator.ofFloat(iv_label_7, "alpha", 0f, 1f)
        val animAlpha8 = ObjectAnimator.ofFloat(iv_label_8, "alpha", 0f, 1f)

        val animScaleX1 = ObjectAnimator.ofFloat(iv_label_1, "scaleX", 0f, 2f)
        val animScaleX2 = ObjectAnimator.ofFloat(iv_label_2, "scaleX", 0f, 2f)
        val animScaleX3 = ObjectAnimator.ofFloat(iv_label_3, "scaleX", 0f, 2f)
        val animScaleX4 = ObjectAnimator.ofFloat(iv_label_4, "scaleX", 0f, 2f)
        val animScaleX5 = ObjectAnimator.ofFloat(iv_label_5, "scaleX", 0f, 2f)
        val animScaleX6 = ObjectAnimator.ofFloat(iv_label_6, "scaleX", 0f, 2f)
        val animScaleX7 = ObjectAnimator.ofFloat(iv_label_7, "scaleX", 0f, 2f)
        val animScaleX8 = ObjectAnimator.ofFloat(iv_label_8, "scaleX", 0f, 2f)

        val animScaleY1 = ObjectAnimator.ofFloat(iv_label_1, "scaleY", 0f, 2f)
        val animScaleY2 = ObjectAnimator.ofFloat(iv_label_2, "scaleY", 0f, 2f)
        val animScaleY3 = ObjectAnimator.ofFloat(iv_label_3, "scaleY", 0f, 2f)
        val animScaleY4 = ObjectAnimator.ofFloat(iv_label_4, "scaleY", 0f, 2f)
        val animScaleY5 = ObjectAnimator.ofFloat(iv_label_5, "scaleY", 0f, 2f)
        val animScaleY6 = ObjectAnimator.ofFloat(iv_label_6, "scaleY", 0f, 2f)
        val animScaleY7 = ObjectAnimator.ofFloat(iv_label_7, "scaleY", 0f, 2f)
        val animScaleY8 = ObjectAnimator.ofFloat(iv_label_8, "scaleY", 0f, 2f)

        val animTX1 = ObjectAnimator.ofFloat(iv_label_1, "translationX", 0f, -50.dp2px().toFloat())
        val animTX2 = ObjectAnimator.ofFloat(iv_label_2, "translationX", 0f, 80.dp2px().toFloat())
        val animTX3 = ObjectAnimator.ofFloat(iv_label_3, "translationX", 0f, -78.dp2px().toFloat())
        val animTX4 = ObjectAnimator.ofFloat(iv_label_4, "translationX", 0f, 100.dp2px().toFloat())
        val animTX5 = ObjectAnimator.ofFloat(iv_label_5, "translationX", 0f, -140.dp2px().toFloat())
        val animTX6 = ObjectAnimator.ofFloat(iv_label_6, "translationX", 0f, 120.dp2px().toFloat())
        val animTX7 = ObjectAnimator.ofFloat(iv_label_7, "translationX", 0f, -92.dp2px().toFloat())
        val animTX8 = ObjectAnimator.ofFloat(iv_label_8, "translationX", 0f, 45.dp2px().toFloat())

        val animTY1 = ObjectAnimator.ofFloat(iv_label_1, "translationY", 0f, -232.dp2px().toFloat())
        val animTY2 = ObjectAnimator.ofFloat(iv_label_2, "translationY", 0f, -196.dp2px().toFloat())
        val animTY3 = ObjectAnimator.ofFloat(iv_label_3, "translationY", 0f, -116.dp2px().toFloat())
        val animTY4 = ObjectAnimator.ofFloat(iv_label_4, "translationY", 0f, -77.dp2px().toFloat())
        val animTY5 = ObjectAnimator.ofFloat(iv_label_5, "translationY", 0f, 0f)
        val animTY6 = ObjectAnimator.ofFloat(iv_label_6, "translationY", 0f, 110.dp2px().toFloat())
        val animTY7 = ObjectAnimator.ofFloat(iv_label_7, "translationY", 0f, 142.dp2px().toFloat())
        val animTY8 = ObjectAnimator.ofFloat(iv_label_8, "translationY", 0f, 210.dp2px().toFloat())

        animAlpha1.duration = time1
        animAlpha2.duration = time2
        animAlpha3.duration = time3
        animAlpha4.duration = time4
        animAlpha5.duration = time5
        animAlpha6.duration = time6
        animAlpha7.duration = time7
        animAlpha8.duration = time8

        animScaleX1.duration = time1
        animScaleX2.duration = time2
        animScaleX3.duration = time3
        animScaleX4.duration = time4
        animScaleX5.duration = time5
        animScaleX6.duration = time6
        animScaleX7.duration = time7
        animScaleX8.duration = time8

        animScaleY1.duration = time1
        animScaleY2.duration = time2
        animScaleY3.duration = time3
        animScaleY4.duration = time4
        animScaleY5.duration = time5
        animScaleY6.duration = time6
        animScaleY7.duration = time7
        animScaleY8.duration = time8

        animTX1.duration = time1
        animTX2.duration = time2
        animTX3.duration = time3
        animTX4.duration = time4
        animTX5.duration = time5
        animTX6.duration = time6
        animTX7.duration = time7
        animTX8.duration = time8

        animTY1.duration = time1
        animTY2.duration = time2
        animTY3.duration = time3
        animTY4.duration = time4
        animTY5.duration = time5
        animTY6.duration = time6
        animTY7.duration = time7
        animTY8.duration = time8


        val timeDelay1 = random.nextInt(1000).toLong()
        val timeDelay2 = random.nextInt(1000).toLong()
        val timeDelay3 = random.nextInt(1000).toLong()
        val timeDelay4 = random.nextInt(1000).toLong()
        val timeDelay5 = random.nextInt(1000).toLong()
        val timeDelay6 = random.nextInt(1000).toLong()
        val timeDelay7 = random.nextInt(1000).toLong()
        val timeDelay8 = random.nextInt(1000).toLong()

        animAlpha1.startDelay = timeDelay1
        animAlpha2.startDelay = timeDelay2
        animAlpha3.startDelay = timeDelay3
        animAlpha4.startDelay = timeDelay4
        animAlpha5.startDelay = timeDelay5
        animAlpha6.startDelay = timeDelay6
        animAlpha7.startDelay = timeDelay7
        animAlpha8.startDelay = timeDelay8

        animScaleX1.startDelay = timeDelay1
        animScaleX2.startDelay = timeDelay2
        animScaleX3.startDelay = timeDelay3
        animScaleX4.startDelay = timeDelay4
        animScaleX5.startDelay = timeDelay5
        animScaleX6.startDelay = timeDelay6
        animScaleX7.startDelay = timeDelay7
        animScaleX8.startDelay = timeDelay8

        animScaleY1.startDelay = timeDelay1
        animScaleY2.startDelay = timeDelay2
        animScaleY3.startDelay = timeDelay3
        animScaleY4.startDelay = timeDelay4
        animScaleY5.startDelay = timeDelay5
        animScaleY6.startDelay = timeDelay6
        animScaleY7.startDelay = timeDelay7
        animScaleY8.startDelay = timeDelay8

        animTX1.startDelay = timeDelay1
        animTX2.startDelay = timeDelay2
        animTX3.startDelay = timeDelay3
        animTX4.startDelay = timeDelay4
        animTX5.startDelay = timeDelay5
        animTX6.startDelay = timeDelay6
        animTX7.startDelay = timeDelay7
        animTX8.startDelay = timeDelay8

        animTY1.startDelay = timeDelay1
        animTY2.startDelay = timeDelay2
        animTY3.startDelay = timeDelay3
        animTY4.startDelay = timeDelay4
        animTY5.startDelay = timeDelay5
        animTY6.startDelay = timeDelay6
        animTY7.startDelay = timeDelay7
        animTY8.startDelay = timeDelay8

        animAlpha1.start()
        animAlpha2.start()
        animAlpha3.start()
        animAlpha4.start()
        animAlpha5.start()
        animAlpha6.start()
        animAlpha7.start()
        animAlpha8.start()

        animScaleX1.start()
        animScaleX2.start()
        animScaleX3.start()
        animScaleX4.start()
        animScaleX5.start()
        animScaleX6.start()
        animScaleX7.start()
        animScaleX8.start()

        animScaleY1.start()
        animScaleY2.start()
        animScaleY3.start()
        animScaleY4.start()
        animScaleY5.start()
        animScaleY6.start()
        animScaleY7.start()
        animScaleY8.start()

        animTX1.start()
        animTX2.start()
        animTX3.start()
        animTX4.start()
        animTX5.start()
        animTX6.start()
        animTX7.start()
        animTX8.start()

        animTY1.start()
        animTY2.start()
        animTY3.start()
        animTY4.start()
        animTY5.start()
        animTY6.start()
        animTY7.start()
        animTY8.start()

        isCancel = false

        animAlpha1.doOnEnd {
            iv_repeat.visibility = View.VISIBLE
            if (!isCancelAllAnim) {
                animEndLabel(
                    iv_label_1,
                    -50.dp2px().toFloat(),
                    -232.dp2px().toFloat(),
                    -50.dp2px().toFloat(),
                    -232.dp2px().toFloat()
                )
            } else {
                animAlpha1.cancel()
                animScaleX1.cancel()
                animScaleY1.cancel()
                animTX1.cancel()
                animTY1.cancel()
            }
        }

        animAlpha2.doOnEnd {
            if (!isCancelAllAnim) {
                animEndLabel(
                    iv_label_2,
                    80.dp2px().toFloat(),
                    -196.dp2px().toFloat(),
                    80.dp2px().toFloat(),
                    -196.dp2px().toFloat()
                )
            } else {
                animAlpha2.cancel()
                animScaleX2.cancel()
                animScaleY2.cancel()
                animTX2.cancel()
                animTY2.cancel()
            }
        }

        animAlpha3.doOnEnd {
            if (!isCancelAllAnim) {
                animEndLabel(
                    iv_label_3,
                    -78.dp2px().toFloat(),
                    -116.dp2px().toFloat(),
                    -78.dp2px().toFloat(),
                    -116.dp2px().toFloat()
                )
            } else {
                animAlpha3.cancel()
                animScaleX3.cancel()
                animScaleY3.cancel()
                animTX3.cancel()
                animTY3.cancel()
            }
        }

        animAlpha4.doOnEnd {
            if (!isCancelAllAnim) {
                animEndLabel(
                    iv_label_4,
                    100.dp2px().toFloat(),
                    -77.dp2px().toFloat(),
                    100.dp2px().toFloat(),
                    -77.dp2px().toFloat()
                )
            } else {
                animAlpha4.cancel()
                animScaleX4.cancel()
                animScaleY4.cancel()
                animTX4.cancel()
                animTY4.cancel()
            }
        }

        animAlpha5.doOnEnd {
            if (!isCancelAllAnim) {
                animEndLabel(
                    iv_label_5,
                    -140.dp2px().toFloat(),
                    0f,
                    -140.dp2px().toFloat(),
                    0f
                )
            } else {
                animAlpha5.cancel()
                animScaleX5.cancel()
                animScaleY5.cancel()
                animTX5.cancel()
                animTY5.cancel()
            }
        }

        animAlpha6.doOnEnd {
            if (!isCancelAllAnim) {
                animEndLabel(
                    iv_label_6,
                    120.dp2px().toFloat(),
                    110.dp2px().toFloat(),
                    120.dp2px().toFloat(),
                    110.dp2px().toFloat()
                )
            } else {
                animAlpha6.cancel()
                animScaleX6.cancel()
                animScaleY6.cancel()
                animTX6.cancel()
                animTY6.cancel()
            }
        }

        animAlpha7.doOnEnd {
            if (!isCancelAllAnim) {
                animEndLabel(
                    iv_label_7,
                    -92.dp2px().toFloat(),
                    142.dp2px().toFloat(),
                    -92.dp2px().toFloat(),
                    142.dp2px().toFloat()
                )
            } else {
                animAlpha7.cancel()
                animScaleX7.cancel()
                animScaleY7.cancel()
                animTX7.cancel()
                animTY7.cancel()
            }
        }

        animAlpha8.doOnEnd {
            if (!isCancelAllAnim) {
                animEndLabel(
                    iv_label_8,
                    45.dp2px().toFloat(),
                    210.dp2px().toFloat(),
                    45.dp2px().toFloat(),
                    210.dp2px().toFloat()
                )
            } else {
                animAlpha8.cancel()
                animScaleX8.cancel()
                animScaleY8.cancel()
                animTX8.cancel()
                animTY8.cancel()
            }
        }
    }

    private val radius = 10.dp2px()

    /**
     * 8个Label移动到自己的位置,开始各自运动
     * view:View对象
     * angle:角度
     * x:原点x
     * x2:上次移动的位置
     * y:原点y
     * y2:上次移动的位置
     */
    private var isCancel = false // 取消动画,否则会多个动画一起执行
    private fun animEndLabel(
        view: View,
        x: Float = 0f,
        y: Float = 0f,
        lastX: Float = 0f,
        lastY: Float = 0f,
        angle: Float = 135f
    ) {
        val pointX = x + radius * cos(angle)
        val pointY = y + radius * sin(angle)

        val set = AnimatorSet()
        val animX = ObjectAnimator.ofFloat(view, "translationX", lastX, pointX)
        val AnimY = ObjectAnimator.ofFloat(view, "translationY", lastY, pointY)

        set.play(animX).with(AnimY)
        set.duration = 2000
        set.start()

        set.doOnEnd {
            if (!isCancel) {
                val newAngle = random.nextFloat() * 360
                animEndLabel(view, x, y, pointX, pointY, newAngle)
            }else{
                set.cancel()
            }
        }
    }

    private fun animCenter() {
        val anim11 = ObjectAnimator.ofFloat(fl_good, "alpha", 1f, 0f)
        anim11.duration = 1000
        anim11.start()

        val set = AnimatorSet()
        val anim1 = ObjectAnimator.ofFloat(progressBar, "alpha", 1f, 0f)
        val anim2 = ObjectAnimator.ofFloat(tv_good_title, "translationX", 0f, 66.dp2px().toFloat())
        val anim3 = ObjectAnimator.ofFloat(tv_bad_title, "alpha", 1f, 0f)
        val anim4 = ObjectAnimator.ofFloat(rl_switch2, "alpha", 1f, 0f)
        val anim5 = ObjectAnimator.ofFloat(rl_switch1, "translationX", 0f, 66.dp2px().toFloat())
        val anim6 = ObjectAnimator.ofFloat(tv_time1, "alpha", 1f, 0f)
        val anim7 = ObjectAnimator.ofFloat(tv_time2, "alpha", 1f, 0f)
        set.duration = 1000
        set.play(anim1).with(anim2).with(anim3).with(anim4).with(anim5).with(anim6).with(anim7)
        set.startDelay = 500
        set.start()

        set.doOnEnd {
            if (!isCancelAllAnim) {
                animLabelTranslation()
            } else {
                set.cancel()
            }
        }
    }

    private fun animProgress() {
        val anim = ObjectAnimator.ofFloat(tv_bad_title, "alpha", 1f, 1f)
        anim.duration = 50
        anim.repeatCount = 240
        anim.start()
        anim.doOnStart {
            if (!isCancelAllAnim) {
                progressBar?.apply { progress = 1 }
            } else {
                anim.cancel()
            }
        }
        anim.doOnRepeat {
            if (!isCancelAllAnim) {
                progressBar?.apply { progress += 1 }
            } else {
                anim.cancel()
            }
        }
        anim.doOnEnd {
            if (!isCancelAllAnim) {
                animCenter()
            } else {
                anim.cancel()
            }
        }
    }

    private fun animGood() {
        val anim1 = ObjectAnimator.ofFloat(fl_good, "alpha", 1f, 1f)
        anim1.duration = 1000
        anim1.repeatCount = 12
        anim1.start()

        anim1.doOnRepeat {
            if (!isCancelAllAnim) {
                val worm = View(requireContext())
                val lp = FrameLayout.LayoutParams(
                    (random.nextInt(5) + 2).dp2px(),
                    (random.nextInt(2) + 1).dp2px()
                )
                lp.marginStart = random.nextInt(70).dp2px()
                lp.topMargin = random.nextInt(65).dp2px()
                worm.rotation = random.nextFloat() * 360
                worm.layoutParams = lp
                worm.setBackgroundResource(R.drawable.shape_black_worm)
                fl_good.addView(worm)
            } else {
                anim1.cancel()
            }
        }
    }

    private fun animBad() {
        val anim1 = ObjectAnimator.ofFloat(fl_bad, "alpha", 1f, 1f)
        anim1.duration = 200
        anim1.repeatCount = 60
        anim1.start()

        anim1.doOnStart {

            if (!isCancelAllAnim) {
                fl_bad.removeAllViews()
            } else {
                anim1.cancel()
            }
        }
        anim1.doOnRepeat {
            if (!isCancelAllAnim) {
                val worm = View(requireContext())
                val lp = FrameLayout.LayoutParams(
                    (random.nextInt(5) + 2).dp2px(),
                    (random.nextInt(2) + 1).dp2px()
                )
                lp.marginStart = random.nextInt(70).dp2px()
                lp.topMargin = random.nextInt(65).dp2px()
                worm.rotation = random.nextFloat() * 360
                worm.layoutParams = lp
                worm.setBackgroundResource(R.drawable.shape_black_worm)
                fl_bad.addView(worm)
            } else {
                anim1.cancel()
            }
        }
    }

    // 是否取消所有动画
    private var isCancelAllAnim = false

    override fun onDestroyView() {
        isCancelAllAnim = true
        super.onDestroyView()
    }
}