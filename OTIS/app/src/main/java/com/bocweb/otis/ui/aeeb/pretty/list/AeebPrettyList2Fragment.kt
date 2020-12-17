package com.bocweb.otis.ui.aeeb.pretty.list

import androidx.recyclerview.widget.LinearLayoutManager
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseFragment
import com.bocweb.otis.app.data.PrettyInfo
import com.bocweb.otis.ui.adapter.SuperAdapter
import com.bocweb.otis.ui.adapter.SuperMultiItem
import kotlinx.android.synthetic.main.fragment_aeeb_pretty_list1.*

class AeebPrettyList2Fragment:BaseFragment() {
    override fun getLayoutId() = R.layout.fragment_aeeb_pretty_list1

    private val adapter by lazy { SuperAdapter(requireActivity(), mList) }
    private val mList by lazy { arrayListOf<SuperMultiItem>() }

    override fun initView() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        for(index in 0 until 10){
            val list = arrayListOf("","","","","","","","","","")
            val info  = PrettyInfo("$index","玻璃内饰$index",list)
            mList.add(SuperMultiItem(SuperMultiItem.Item_01,info))
        }
        recyclerView.adapter = adapter
    }
}