package com.bocweb.otis.ui.mod.dialog

import android.content.Context
import android.view.Gravity
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.blankj.utilcode.util.ToastUtils
import com.bocweb.otis.R
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.ui.BaseDialog

class InputInfoDialog(context: Context) : BaseDialog(context, R.style.dialog_style) {
    override val layout = R.layout.dialog_mod_info

    private lateinit var etName: EditText
    private lateinit var etPhone: EditText
    private lateinit var tvCity: TextView
    private lateinit var etAddress: EditText
    private lateinit var tvType: TextView
    private lateinit var tvSubmit: TextView
    private lateinit var ivClose: ImageView

    override fun initView() {
        etName = findViewById(R.id.et_name)
        etPhone = findViewById(R.id.et_phone)
        tvCity = findViewById(R.id.tv_city)
        etAddress = findViewById(R.id.et_address)
        tvType = findViewById(R.id.tv_type)
        tvSubmit = findViewById(R.id.tv_submit)
        ivClose = findViewById(R.id.iv_close)
    }

    override fun initData() {
        setWindow7To8(Gravity.CENTER)
        setCanceledOnTouchOutside(false)
    }

    override fun setListener() {
        ivClose.setClickNoRepeat { dismiss() }

        tvSubmit.setClickNoRepeat {
            val name = etName.text
            val phone = etPhone.text
            val city = tvCity.text
            val address = etAddress.text
            val type = tvType.text

            when {
                name.isEmpty() -> ToastUtils.showShort("请输入姓名")
                phone.isEmpty() || phone.length != 11 -> ToastUtils.showShort("请输入手机号")
                city.isEmpty() -> ToastUtils.showShort("请选择省市信息")
                address.isEmpty() -> ToastUtils.showShort("请输入具体地址")
                type.isEmpty() -> ToastUtils.showShort("请选择意向部分")
            }

            dismiss()
        }
    }
}