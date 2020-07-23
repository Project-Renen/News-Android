package com.example.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.database.entity.News
@Dao
interface NewsDao {
    @Query("SELECT * from news")
    fun getNews(): LiveData<List<News>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: News)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsList(news: List<News>)

    @Query("SELECT * FROM news")
    suspend fun fetchAllNews(): List<News>

    @Transaction
    @Update
    suspend fun updateNews(news: News)

    @Transaction
    @Delete
    suspend fun deleteNews(news: News)
}