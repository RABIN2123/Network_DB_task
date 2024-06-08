package com.example.network_db_task.data.network

import com.example.network_db_task.data.network.model.GenUserResponse

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getUser(): GenUserResponse {
        return apiService.getUsers()
    }

}