package com.bocweb.otis.util.ui

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.bocweb.otis.R
import com.bocweb.otis.util.getScreenWidth

abstract class BaseDialog : Dialog {
    private var mWindow: Window? = null

    constructor(context: Context) : super(context, R.style.dialog_bottom_style)
    constructor(context: Context, style: Int) : super(context, style)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        mWindow = window
        initView()
        initData()
        setListener()
    }

    protected abstract val layout: Int
    protected abstract fun initView()
    protected abstract fun initData()
    protected abstract fun setListener()
    fun setWindowMax(gravity: Int) {
        if (mWindow != null) {
            mWindow!!.setGravity(gravity)
            mWindow!!.decorView.setPadding(0, 0, 0, 0)
            //获得window窗口的属性
            val lp = mWindow!!.attributes
            //设置窗口宽度为充满全屏
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            //设置窗口高度为包裹内容
            lp.height = WindowManager.LayoutParams.MATCH_PARENT
            //将设置好的属性set回去
            mWindow!!.attributes = lp
        }
    }

    fun setWindowWidthMax(gravity: Int) {
        if (mWindow != null) {
            mWindow!!.setGravity(gravity)
            mWindow!!.decorView.setPadding(0, 0, 0, 0)
            //获得window窗口的属性
            val lp = mWindow!!.attributes
            //设置窗口宽度为充满全屏
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            //设置窗口高度为包裹内容
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            //将设置好的属性set回去
            mWindow!!.attributes = lp
        }
    }

    fun setWindow3To5(gravity: Int) {
        if (mWindow != null) {
            mWindow!!.setGravity(gravity)
            mWindow!!.decorView.setPadding(0, 0, 0, 0)
            //获得window窗口的属性
            val lp = mWindow!!.attributes
            //设置窗口宽度为充满全屏
            lp.width = getScreenWidth() * 3 / 5
            //设置窗口高度为包裹内容
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            //将设置好的属性set回去
            mWindow!!.attributes = lp
        }
    }

    fun setWindow3To4(gravity: Int) {
        if (mWindow != null) {
            mWindow!!.setGravity(gravity)
            mWindow!!.decorView.setPadding(0, 0, 0, 0)
            //获得window窗口的属性
            val lp = mWindow!!.attributes
            //设置窗口宽度为充满全屏
            lp.width = getScreenWidth() * 3 / 4
            //设置窗口高度为包裹内容
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            //将设置好的属性set回去
            mWindow!!.attributes = lp
        }
    }

    fun setWindow4To5(gravity: Int) {
        if (mWindow != null) {
            mWindow!!.setGravity(gravity)
            mWindow!!.decorView.setPadding(0, 0, 0, 0)
            //获得window窗口的属性
            val lp = mWindow!!.attributes
            //设置窗口宽度为充满全屏
            lp.width = getScreenWidth() * 4 / 5
            //设置窗口高度为包裹内容
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            //将设置好的属性set回去
            mWindow!!.attributes = lp
        }
    }

    fun setWindow7To8(gravity: Int) {
        if (mWindow != null) {
            mWindow!!.setGravity(gravity)
            mWindow!!.decorView.setPadding(0, 0, 0, 0)
            //获得window窗口的属性
            val lp = mWindow!!.attributes
            //设置窗口宽度为充满全屏
            lp.width = getScreenWidth() * 7 / 8
            //设置窗口高度为包裹内容
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            //将设置好的属性set回去
            mWindow!!.attributes = lp
        }
    }

    fun setWindow2Max(gravity: Int) {
        if (mWindow != null) {
            mWindow!!.setGravity(gravity)
            mWindow!!.decorView.setPadding(0, 0, 0, 0)
            //获得window窗口的属性
            val lp = mWindow!!.attributes
            //设置窗口宽度为充满全屏
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            //设置窗口高度为包裹内容
            lp.height = WindowManager.LayoutParams.MATCH_PARENT
            //将设置好的属性set回去
            mWindow!!.attributes = lp
        }
    }

    /**
     * 打开软键盘
     */
    fun openKeyboard(mContext: Context, mEditText: EditText) {
        mEditText.requestFocus()
        val imm = mContext
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN)
        imm.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
        )
    }

    /**
     * 关闭软键盘
     */
    fun closeKeyboard(mContext: Context, mEditText: EditText) {
        val imm = mContext
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(mEditText.windowToken, 0)
    }

    /**
     * 判断当前软键盘是否打开
     */
    fun isKeyboardOpen(activity: Activity): Boolean {
        // 虚拟键盘隐藏 判断view是否为空
        val view = activity.window.peekDecorView()
        if (view != null) {
            // 隐藏虚拟键盘
            val inputManager = activity
                .getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            return inputManager.isActive && activity.window.currentFocus != null
        }
        return false
    }
}