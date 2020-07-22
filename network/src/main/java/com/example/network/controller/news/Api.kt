package com.example.network.controller.news

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.network.controller.news.NewsResponse as NewsResponse

interface Api {
    @GET("top-headlines")
    fun loadNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String

        ):
            Call<MultipleNewsResponse>
}