package com.example.network_db_task.data.network

import com.example.network_db_task.data.network.model.GenUserResponse

interface ApiHelper {
    suspend fun getUser(): GenUserResponse
}