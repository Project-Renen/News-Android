package com.example.network.controller.news

data class MultipleNewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsResponse>
)
