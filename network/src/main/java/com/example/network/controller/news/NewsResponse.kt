package com.example.network.controller.news

data class NewsResponse(
    val author: String?,
    val title: String?,
    val publishedAt: String?,
    val description:String?,
    val url:String?,
    val source: NewsSource?,
    val urlToImage: String?
)