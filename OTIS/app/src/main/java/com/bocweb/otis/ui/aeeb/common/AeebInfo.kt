package com.bocweb.otis.ui.aeeb.common

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import com.bocweb.otis.R

class AeebInfo {
    var no: Int = 0
    var image1: Int = 0
    var image2: Int = 0
    var title: String = ""
    var desc1: String = ""
}

fun getAeebMoreTopData(): MutableList<AeebInfo> {
    val list = arrayListOf<AeebInfo>()
    val info1 = AeebInfo()
    info1.image1 = Color.parseColor("#ff0000")
    info1.image2 = R.drawable.more_no1
    info1.title = "直线型连廊"
    info1.desc1 = "可适配大部分建筑类型"
    info1.no = 0
    list.add(info1)

    val info2 = AeebInfo()
    info2.image1 = Color.parseColor("#ffff00")
    info2.image2 = R.drawable.more_no2
    info2.title = "直线型连廊2"
    info2.desc1 = "可适配大部分建筑类型2"
    info2.no = 1
    list.add(info2)

    val info3 = AeebInfo()
    info3.image1 = Color.parseColor("#00f900")
    info3.image2 = R.drawable.more_no3
    info3.title = "直线型连廊3"
    info3.desc1 = "可适配大部分建筑类型3"
    info3.no = 2
    list.add(info3)

    val info4 = AeebInfo()
    info4.image1 = Color.parseColor("#00009f")
    info4.image2 = R.drawable.more_no4
    info4.title = "直线型连廊4"
    info4.desc1 = "可适配大部分建筑类型4"
    info4.no = 3
    list.add(info4)

    val info5 = AeebInfo()
    info5.image1 = Color.parseColor("#00ffff")
    info5.image2 = R.drawable.more_no5
    info5.title = "直线型连廊5"
    info5.desc1 = "可适配大部分建筑类型5"
    info5.no = 4
    list.add(info5)
    return list
}

fun getAeebMoreBottomData(): MutableList<AeebInfo> {
    val list = arrayListOf<AeebInfo>()
    val info1 = AeebInfo()
    info1.image1 = Color.parseColor("#ff0000")
    info1.image2 = R.drawable.more_no1
    info1.title = "直线型连廊"
    info1.desc1 = "可适配大部分建筑类型"
    info1.no = 0
    list.add(info1)

    val info2 = AeebInfo()
    info2.image1 = Color.parseColor("#ffff00")
    info2.image2 = R.drawable.more_no2
    info2.title = "直线型连廊2"
    info2.desc1 = "可适配大部分建筑类型2"
    info2.no = 1
    list.add(info2)
    return list
}