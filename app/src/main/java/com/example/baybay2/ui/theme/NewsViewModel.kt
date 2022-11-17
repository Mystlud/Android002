package com.example.baybay2.ui.theme

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baybay2.model.Article
import com.example.baybay2.network.Api
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    var newsUiState: List<Article> by mutableStateOf(listOf())
    init {
        getTopHeadlines()
    }
    fun getTopHeadlines(){
        viewModelScope.launch {
            val response = Api.newsApiService.getTopHeadline()
            //val articles = response.articles

            response.articles.forEach{article: Article ->
                Log.d("response", article.title)
            }

            /*articles.forEach{ article: Article ->
                Log.d("response", article.toString())
            }*/
            newsUiState = response.articles
        }
    }
}