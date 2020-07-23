package com.example.news.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.database.AppDatabase
import com.example.database.repository.NewsRepository
import com.example.network.NetworkGate
import com.example.network.controller.news.NewsController
import com.example.network.controller.news.NewsControllerImpl
import com.example.network.controller.news.tmdbApi
import com.example.news.R
import com.example.news.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {

    lateinit var networkGate: NetworkGate
    lateinit var newsViewModel: NewsViewModel
    lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkGate= NetworkGate(NewsControllerImpl(tmdbApi))
        database= AppDatabase.getInstance(this)
        newsViewModel= NewsViewModel(NewsRepository(database.newsDAO()))
        setContentView(R.layout.activity_main)
    }
}