package com.example.baybay2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.baybay2.model.Article
import com.example.baybay2.ui.theme.NewsViewModel

class NewsActivity : ComponentActivity(){
    val newsModel = viewModels<NewsViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsApp(newsModel.value.newsUiState)
        }
    }
}

@Composable
fun NewsApp(listArticle: List<Article>){
    LazyColumn{
        items(listArticle) { article ->
            NewsCard(article = article)
        }
    }
}

@Composable
fun NewsCard(article: Article){
    Card(elevation = 8.dp) {
        Column() {
            AsyncImage(model = article.urlToImage, contentDescription = "news image")
        }
        Text(text = article.title)
    }
}