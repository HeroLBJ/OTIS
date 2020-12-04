package com.bocweb.otis.app.app

import android.app.Application
import android.content.Context
import com.bocweb.otis.R
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import kotlin.properties.Delegates

class App : Application() {

    companion object {
        var CONTEXT: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()

        CONTEXT = applicationContext

        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/default.TTF") // 我的字体库是放在res/font目录下
                            .setFontAttrId(R.attr.fontPath).build()
                    )
                )
                .build()
        )
    }

}