package com.example.network.controller.news

import retrofit2.Callback

class NewsControllerImpl(val api: Api) : NewsController {
    val apiKey = "e4b9013ade7b4383a4a3c7533257d82a"
    override fun loadNews(callback: Callback<MultipleNewsResponse>){
        val call = api.loadNews("ru", apiKey)
        call.enqueue(callback)
    }
}