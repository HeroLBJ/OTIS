package com.bocweb.otis.util

import android.app.Activity

class ActivityUtil {
    companion object {
        private val finishList = arrayListOf<Activity>()

        fun addFinish(act: Activity) {
            finishList.add(act)
        }

        fun finish() {
            finishList.forEach { it.finish() }
        }
    }
}