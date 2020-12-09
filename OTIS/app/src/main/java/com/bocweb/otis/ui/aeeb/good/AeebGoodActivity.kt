package com.bocweb.otis.ui.aeeb.good

import androidx.recyclerview.widget.LinearLayoutManager
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_aeeb_good.*
import kotlinx.android.synthetic.main.activity_aeeb_good.rootView
import kotlinx.android.synthetic.main.activity_l1_health.*

class AeebGoodActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_aeeb_good

    override fun initView() {
        rootView.startPageAnim(this)

        val list = arrayListOf(
            AeebGoodInfo(
                R.drawable.home_good_img1, "全系顶配",
                "稀土永磁同步无齿轮条形主机\n能源再生变频控制柜\n永磁同步变频门机",
                R.drawable.res_f1
            ),
            AeebGoodInfo(
                R.drawable.home_good_img2, "以静智动",
                "复合钢带无刚性摩擦\n盘式制动静音抱闸技术\n主机底座双层隔振设计",
                R.drawable.res_f2
            ),
            AeebGoodInfo(
                R.drawable.home_good_img3, "极致安全",
                "奥的斯E3标准高于全球各地区标准\n钢带自动探伤\n坚固的门系统设计",
                R.drawable.res_f3
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AeebGoodAdapter(list)
    }

    override fun onBackPressed() { rootView.finishPage(this)}
}