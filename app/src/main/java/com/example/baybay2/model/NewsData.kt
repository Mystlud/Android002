package com.example.baybay2.model

data class NewsData (
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)