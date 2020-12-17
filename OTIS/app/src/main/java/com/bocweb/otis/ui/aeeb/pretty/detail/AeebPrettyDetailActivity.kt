package com.bocweb.otis.ui.aeeb.pretty.detail

import androidx.recyclerview.widget.GridLayoutManager
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseActivity
import com.bocweb.otis.ui.adapter.SuperAdapter
import com.bocweb.otis.ui.adapter.SuperMultiItem
import com.bocweb.otis.util.finishPage
import com.bocweb.otis.util.setClickNoRepeat
import com.bocweb.otis.util.startPageAnim
import kotlinx.android.synthetic.main.activity_aeeb_pretty_detail.*

class AeebPrettyDetailActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_aeeb_pretty_detail

    private val adapter by lazy { SuperAdapter(this,mList) }
    private val mList by lazy { arrayListOf<SuperMultiItem>() }

    override fun initView() {
        rootView.startPageAnim(this)
        tv_back.setClickNoRepeat { onBackPressed() }

        tv_title.text = "玻璃外观"

        for(index in 0 until 30){
            mList.add(SuperMultiItem(SuperMultiItem.Item_03,""))
        }

        recyclerView.layoutManager = GridLayoutManager(this,3)
        recyclerView.adapter = adapter
    }

    override fun onBackPressed() {rootView.finishPage(this)}
}