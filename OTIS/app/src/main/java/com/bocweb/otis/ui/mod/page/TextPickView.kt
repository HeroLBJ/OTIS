package com.bocweb.otis.ui.mod.page

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.os.HandlerCompat.postDelayed
import com.bocweb.otis.R

class TextPickView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var currentIndex = 0
    private var tvUp: TextView
    private var tvTitle: TextView
    private var tvDown: TextView
    private var ivUp: ImageView
    private var ivDown: ImageView

    private val titleList by lazy { arrayListOf("控制系统", "曳引系统", "导轨系统", "轿厢系统", "门厅系统") }

    init {
        val rootView = LayoutInflater.from(context).inflate(R.layout.view_text_pick, null)
        tvUp = rootView.findViewById(R.id.tv_up)
        tvTitle = rootView.findViewById(R.id.tv_title)
        tvDown = rootView.findViewById(R.id.tv_down)
        ivUp = rootView.findViewById(R.id.iv_up)
        ivDown = rootView.findViewById(R.id.iv_down)

        currentIndex = 0
        switchText()

        addView(rootView)
    }

    fun setCurrentIndex(index: Int) {
        Handler().postDelayed({
            currentIndex = index
            switchText()
        }, 200)
    }

    private fun switchText() {
        tvUp.visibility = View.VISIBLE
        tvDown.visibility = View.VISIBLE
        ivUp.visibility = View.VISIBLE
        ivDown.visibility = View.VISIBLE
        when (currentIndex) {
            0 -> {
                ivUp.visibility = View.INVISIBLE
                tvUp.visibility = View.INVISIBLE
                tvTitle.text = titleList[0]
                tvDown.text = titleList[1]
            }
            1 -> {
                tvUp.text = titleList[0]
                tvTitle.text = titleList[1]
                tvDown.text = titleList[2]
            }
            2 -> {
                tvUp.text = titleList[1]
                tvTitle.text = titleList[2]
                tvDown.text = titleList[3]
            }
            3 -> {
                tvUp.text = titleList[2]
                tvTitle.text = titleList[3]
                tvDown.text = titleList[4]
            }
            4 -> {
                tvUp.text = titleList[3]
                tvTitle.text = titleList[4]
                tvDown.visibility = View.INVISIBLE
                ivDown.visibility = View.INVISIBLE
            }
        }
    }
}