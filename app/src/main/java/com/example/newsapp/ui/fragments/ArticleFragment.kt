package com.example.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.newsapp.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment: BaseFragment(R.layout.fragment_article) {

    private val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val article = args.article
        webView.apply {
            webViewClient =  WebViewClient()
            loadUrl(article.url!!)
        }

        fab.setOnClickListener {
            viewModel.addToFavorite(article)
            Snackbar.make(view, "Save successfully", 300)
        }
    }
}