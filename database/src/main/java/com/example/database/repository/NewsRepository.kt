package com.example.database.repository

import com.example.database.dao.NewsDao
import com.example.database.entity.News

class NewsRepository(private val newsDao: NewsDao) {

    suspend fun insertNews(news: News) {
        newsDao.insertNews(news)
    }
    suspend fun insertNewsList(news: List<News>) {
        newsDao.insertNewsList(news)
    }

    suspend fun fetchAllNews(): List<News> {
        return newsDao.fetchAllNews()
    }


    suspend fun updateNews(news: News) {
        return newsDao.updateNews(news)
    }

    suspend fun deleteNews(news: News) {
        return newsDao.deleteNews(news)
    }
}