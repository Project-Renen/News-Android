package com.example.network

import com.example.network.controller.news.MultipleNewsResponse
import com.example.network.controller.news.NewsController
import com.example.network.controller.news.NewsResponse
import retrofit2.Callback

class NetworkGate constructor(
    private var newsController: NewsController
) : NewsController {
    override fun loadNews(callback: Callback<MultipleNewsResponse>) {
        newsController.loadNews(callback)
    }
}