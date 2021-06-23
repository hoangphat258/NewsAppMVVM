package com.example.newsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.models.NewsResponse
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
): ViewModel() {

    private val _fetchedNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val fetchedNews: LiveData<Resource<NewsResponse>> = _fetchedNews

    private var breakingNewsPage = 1
    private var searchNewsPage = 1

    fun getBreakingNews(countryCode: String) = viewModelScope.launch {
        _fetchedNews.postValue(Resource.Loading())
        val response = repository.getBreakingNews(countryCode, breakingNewsPage)
        _fetchedNews.postValue(handleFetchedNewsResponse(response))
    }

    fun searchNews(keyword: String) = viewModelScope.launch {
        _fetchedNews.postValue(Resource.Loading())
        val response = repository.searchNews(keyword, searchNewsPage)
        _fetchedNews.postValue(handleFetchedNewsResponse(response))
    }

    private fun handleFetchedNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if(response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

}