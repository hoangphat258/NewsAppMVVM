package com.example.newsapp.repository

import android.content.Context
import com.example.newsapp.api.NewsAPI
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.models.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val db: ArticleDatabase,
    private val apiService: NewsAPI
    ) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int): Response<NewsResponse> {
        return apiService.getBreakingNews(countryCode, pageNumber)
    }

    suspend fun searchNews(keyword: String, pageNumber: Int): Response<NewsResponse> {
        return apiService.searchForNews(keyword, pageNumber)
    }
}