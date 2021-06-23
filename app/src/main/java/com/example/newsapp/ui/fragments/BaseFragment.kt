package com.example.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.newsapp.ui.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_breaking_news.*

@AndroidEntryPoint
open class BaseFragment(layoutId: Int): Fragment(layoutId) {

    protected val viewModel: NewsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    protected fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

    protected fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }
}