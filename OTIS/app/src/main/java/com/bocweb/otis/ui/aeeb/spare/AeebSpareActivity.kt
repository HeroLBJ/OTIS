package com.bocweb.otis.ui.aeeb.spare

import android.animation.ObjectAnimator
import android.widget.TableRow
import androidx.core.view.children
import androidx.recyclerview.widget.LinearLayoutManager
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.setLocalData
import kotlinx.android.synthetic.main.activity_aeeb_pretty.*
import kotlinx.android.synthetic.main.include_aeeb_spare_center.*

class AeebSpareActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_aeeb_spare

    private var childIndex = 0
    private val adapter by lazy { AeebSpareAdapter(list) }
    private val list by lazy { arrayListOf<AeebSpareInfo>() }

    override fun initView() {
        tv_num1.showNumberWithAnimation(1395f)
        tv_num2.showNumberWithAnimation(13900f)
        tv_num3.showNumberWithAnimation(40f)

        for (tabRow in table_layout.children) {
            for (tree in (tabRow as TableRow).children) {
                childIndex++
                val anim = ObjectAnimator.ofFloat(tree, "alpha", 0.1f, 1f)
                anim.duration = 500
                anim.startDelay = childIndex * 20.toLong()
                anim.start()
            }
        }

        levelView.startAnim()

        list.setLocalData()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}