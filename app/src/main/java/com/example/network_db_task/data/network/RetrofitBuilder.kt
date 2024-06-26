package com.example.network_db_task.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://randomuser.me/api/"
    private fun getRetrofit() =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}