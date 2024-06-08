package com.example.network_db_task.data.network

import com.example.network_db_task.data.network.model.GenUserResponse
import retrofit2.http.GET

interface ApiService {
    @GET("?results=50&inc=name,dob,phone,email,picture&noinfo")
    suspend fun getUsers(): GenUserResponse
}