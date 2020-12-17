package com.bocweb.otis.app.data

data class PrettyInfo(
    val id:String,
    val title:String,
    var list:List<String>
)

data class PrettyInfoList(
    var list:List<PrettyInfo>
)