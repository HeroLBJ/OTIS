package com.bocweb.otis.app.data

import com.bocweb.otis.R
import java.io.Serializable

class InfoData(
    var title: String = "",
    var desc1: String = "",
    var desc2: String = "",
    var desc3: String = "",
    var desc4: String = "",
    var bigImg: Int = 0,
    var label1: Int = 0,
    var label2: Int = 0
) : Serializable

fun getModPlan1List(): MutableList<InfoData> {
    val info1 = InfoData(
        title = "保留原梯导轨", desc1 = "降低安装环境影响", desc2 = "安装工时节约", desc3 = "成本节约",
        bigImg = R.drawable.mod_rule1_1, label1 = R.drawable.res_f1, label2 = R.drawable.paln_left1
    )
    val info2 = InfoData(
        title = "保留厅门系统",
        desc1 = "安装工时节约",
        desc2 = "降低对原装潢破坏",
        desc3 = "降低对环境影响",
        desc4 = "成本节约", bigImg = R.drawable.mod_rule1_2, label1 = R.drawable.res_f2,
        label2 = R.drawable.paln_left2
    )
    return arrayListOf(info1, info2)
}