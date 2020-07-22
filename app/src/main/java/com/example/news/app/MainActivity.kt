package com.example.news.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.network.NetworkGate
import com.example.network.controller.news.NewsController
import com.example.network.controller.news.NewsControllerImpl
import com.example.network.controller.news.tmdbApi
import com.example.news.R

class MainActivity : AppCompatActivity() {

    lateinit var networkGate: NetworkGate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkGate= NetworkGate(NewsControllerImpl(tmdbApi))
        setContentView(R.layout.activity_main)
    }
}