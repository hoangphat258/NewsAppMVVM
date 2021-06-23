package com.example.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.models.Article

@Dao
interface ArticleDao {

    //onConflict: used to replace existing item
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticle(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}