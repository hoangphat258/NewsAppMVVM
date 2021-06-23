package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapp.R
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.repository.NewsRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_news.*

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}