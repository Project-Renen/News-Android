package com.example.news.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.database.entity.News
import com.example.database.repository.NewsRepository

public class NewsViewModel(val repository: NewsRepository) : ViewModel() {

    val news = MutableLiveData<List<News>>()
    val allNews: LiveData<List<News>> = news

    init {
    }

    suspend fun allNews() {
        news.postValue(repository.fetchAllNews())
    }

    suspend fun insertNews(news: News) {
        repository.insertNews(news)
    }

    suspend fun insertNewsList(news: List<News>) {
        repository.insertNewsList(news)
    }


    suspend fun updateNote(news: News) {
        repository.updateNews(news)
    }


    suspend fun deleteNote(news: News) {
        repository.deleteNews(news)
    }

}