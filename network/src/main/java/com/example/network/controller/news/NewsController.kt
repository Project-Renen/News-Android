package com.example.network.controller.news

import retrofit2.Callback
import java.io.File

interface NewsController{
    fun loadNews(callback: Callback<MultipleNewsResponse>
    )
}