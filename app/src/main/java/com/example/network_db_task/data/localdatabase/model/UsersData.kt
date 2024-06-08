package com.example.network_db_task.data.localdatabase.model

import com.example.network_db_task.domain.model.User


data class UsersData(
    val list: List<User> = mutableListOf()
)
