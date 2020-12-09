package com.bocweb.otis.util

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.text.Html
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bocweb.otis.R
import com.bocweb.otis.ui.aeeb.pretty.detail.ImageInfo
import com.bocweb.otis.util.ui.MaxViewPager
import com.bocweb.otis.util.ui.ScaleTransitionPagerTitleView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.entity.LocalMedia
import com.to.aboomy.banner.Banner
import net.lucode.hackware.magicindicator.MagicIndicator
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator

fun ViewPager.init(
    fragmentM: FragmentManager,
    fragments: ArrayList<Fragment>
): ViewPager {
    overScrollMode = View.OVER_SCROLL_NEVER
    adapter = object : FragmentPagerAdapter(fragmentM) {
        override fun getItem(position: Int) = fragments[position]
        override fun getCount() = fragments.size
    }
    return this
}

fun MaxViewPager.init(
    fragmentM: FragmentManager,
    fragments: ArrayList<Fragment>
): MaxViewPager {
    overScrollMode = View.OVER_SCROLL_NEVER
    adapter = object : FragmentPagerAdapter(fragmentM) {
        override fun getItem(position: Int) = fragments[position]
        override fun getCount() = fragments.size
    }
    return this
}

fun MagicIndicator.bindViewPager(
    viewPager: ViewPager,
    mDataList: List<String> = arrayListOf(),
    mStringList: List<String> = arrayListOf(),
    action: (index: Int) -> Unit = {}
) {
    val commonNavigator = CommonNavigator(context)
    commonNavigator.adapter = object : CommonNavigatorAdapter() {
        override fun getCount(): Int {
            return if (mDataList.isNotEmpty()) {
                mDataList.size
            } else {
                mStringList.size
            }
        }

        override fun getTitleView(context: Context, index: Int): IPagerTitleView {
            return ScaleTransitionPagerTitleView(context).apply {
                text = if (mDataList.isNotEmpty()) {
                    Html.fromHtml(mDataList[index])
                } else {
                    Html.fromHtml(mStringList[index])
                }
                textSize = 17f
                normalColor = ContextCompat.getColor(context, R.color.black_141A29)
                selectedColor = ContextCompat.getColor(context, R.color.black_141A29)
                setOnClickListener {
                    viewPager.currentItem = index
                    action.invoke(index)
                }
            }
        }

        override fun getIndicator(context: Context): IPagerIndicator {
            return LinePagerIndicator(context).apply {
                mode = LinePagerIndicator.MODE_EXACTLY
                //线条的宽高度
                lineHeight = UIUtil.dip2px(context, 1.5).toFloat()
                lineWidth = UIUtil.dip2px(context, 30.0).toFloat()
                //线条的圆角
                roundRadius = UIUtil.dip2px(context, 6.0).toFloat()
                startInterpolator = AccelerateInterpolator()
                endInterpolator = DecelerateInterpolator(2.0f)
                //线条的颜色
                setColors(ContextCompat.getColor(context, R.color.black_141A29))
                yOffset = 10.dp2px().toFloat()
            }
        }
    }
    this.navigator = commonNavigator

    viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
            this@bindViewPager.onPageScrollStateChanged(state)
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            this@bindViewPager.onPageScrolled(position, positionOffset, positionOffsetPixels)
        }

        override fun onPageSelected(position: Int) {
            this@bindViewPager.onPageSelected(position)
            action.invoke(position)
        }
    })
}

fun Banner.setNoMorePages(items: List<Any>) {

}

@SuppressLint("CheckResult")
fun ImageView.load(imgPath: String?) {
    val requestOptions = RequestOptions()
    requestOptions.error(R.color.image_bg)
    requestOptions.placeholder(R.color.image_bg)
    Glide.with(context)
        .load(imgPath ?: "")
        .apply(requestOptions)
        .into(this)
}

fun View.showImage(activity: Activity, photoArr: MutableList<ImageInfo>, index: Int) {
    val showImgList: MutableList<LocalMedia> = ArrayList()
    for (path in photoArr) {
        val media = LocalMedia()
        media.path = path.url
        showImgList.add(media)
    }

    PictureSelector.create(activity)
        .themeStyle(R.style.picture_default_style)
        .isNotPreviewDownload(true)
        .loadImageEngine(GlideEngine.createGlideEngine()) // 请参考Demo GlideEngine.java
        .openExternalPreview(index, showImgList)
}

fun View.getLocalVisibleRect(activity: Activity, offsetY: Int): Boolean {
    val p = Point()
    activity.windowManager.defaultDisplay.getSize(p)
    val screenWidth: Int = p.x
    val screenHeight: Int = p.y
    val rect = Rect(0, 0, screenWidth, screenHeight) //得到屏幕矩阵
    val location = IntArray(2)
    location[1] = location[1] + offsetY.dp2px()
    getLocationInWindow(location)
    tag = location[1] //存储y方向的位置
    return getLocalVisibleRect(rect)
}

fun RecyclerView.isVisBottom(): Boolean {
    val layoutManager = layoutManager as LinearLayoutManager
    //屏幕中最后一个可见子项的position
    val lastVisibleItemPosition: Int = layoutManager.findLastVisibleItemPosition()
    //当前屏幕所看到的子项个数
    val visibleItemCount: Int = layoutManager.childCount
    //当前RecyclerView的所有子项个数
    val totalItemCount: Int = layoutManager.itemCount
    //RecyclerView的滑动状态
    val state: Int = scrollState
    return visibleItemCount > 0 && lastVisibleItemPosition == totalItemCount - 1 && state == RecyclerView.SCROLL_STATE_IDLE
}