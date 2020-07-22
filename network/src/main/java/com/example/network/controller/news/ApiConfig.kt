package com.example.network.controller.news

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val authInterceptor = Interceptor { chain ->
    val newUrl = chain.request().url()
        .newBuilder()
        .build()

    val newRequest = chain.request()
        .newBuilder()
        .url(newUrl)
        .build()

    chain.proceed(newRequest)
}

//val baseUrl = "http://10.0.2.2:8008"
val baseUrl = "http://newsapi.org/v2/"

//OkhttpClient for building http request url
private val tmdbClient = OkHttpClient().newBuilder()
    .addInterceptor(authInterceptor)
    .build()

fun retrofit(): Retrofit = Retrofit.Builder()
    .client(tmdbClient)
    .baseUrl(baseUrl)
    .addConverterFactory(MoshiConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

val tmdbApi: Api = retrofit().create(Api::class.java)
