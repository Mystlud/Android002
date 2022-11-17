package com.example.baybay2.network

import com.example.baybay2.model.NewsData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://run.mocky.io/v3/4a6b4002-e45f-4ffd-8b9e-508419c6ff0a"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService{
    @GET("top-headlines?country=us&apiKey=2a78c5b43e5847ac8f95fc1d5fa310d1")
    suspend fun getTopHeadline(): NewsData
}

object Api{
    val newsApiService: NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}