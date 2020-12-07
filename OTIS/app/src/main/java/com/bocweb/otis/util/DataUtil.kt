package com.bocweb.otis.util

import com.bocweb.otis.R
import com.bocweb.otis.ui.aeeb.spare.AeebSpareInfo

fun MutableList<AeebSpareInfo>.setLocalData() {
    add(AeebSpareInfo("1F","IOT", R.color.image_bg))
    add(AeebSpareInfo("2F","强大的后台支持", R.color.image_bg))
    add(AeebSpareInfo("3F","第三方电梯管理服务", R.color.image_bg))
}