package com.bocweb.otis.util

import com.bocweb.otis.R
import com.bocweb.otis.ui.aeeb.common.AeebInfo
import com.bocweb.otis.ui.aeeb.spare.AeebSpareInfo

fun MutableList<AeebSpareInfo>.setLocalData() {
    add(AeebSpareInfo("1F", "IOT", R.color.image_bg))
    add(AeebSpareInfo("2F", "强大的后台支持", R.color.image_bg))
    add(AeebSpareInfo("3F", "第三方电梯管理服务", R.color.image_bg))
}

fun getAeebPrettyData():MutableList<AeebInfo> {
    val list = arrayListOf<AeebInfo>()
    val aeeb1 = AeebInfo()
    aeeb1.title = "外观的美"
    aeeb1.image1 = R.drawable.res_pretty_1
    list.add(aeeb1)
    val aeeb2 = AeebInfo()
    aeeb2.title = "内饰的美"
    aeeb2.image1 = R.drawable.res_pretty_2
    list.add(aeeb2)
    return list
}
