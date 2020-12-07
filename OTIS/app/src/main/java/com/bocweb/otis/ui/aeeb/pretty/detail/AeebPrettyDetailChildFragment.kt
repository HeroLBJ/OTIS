package com.bocweb.otis.ui.aeeb.pretty.detail

import androidx.recyclerview.widget.GridLayoutManager
import com.bocweb.otis.R
import com.bocweb.otis.app.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_aeeb_pretty_detail.*

class AeebPrettyDetailChildFragment : BaseFragment() {
    override fun getLayoutId() = R.layout.fragment_aeeb_pretty_detail

    private val adapter by lazy { AeebPrettyDetailAdapter(requireActivity(), list) }
    private val list by lazy { arrayListOf<ImageInfo>() }

    override fun initView() {
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = adapter
    }
}