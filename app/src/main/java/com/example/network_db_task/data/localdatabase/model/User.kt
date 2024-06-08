package com.example.network_db_task.data.localdatabase.model

import com.example.network_db_task.domain.model.Item


data class User(
    val list: List<Item> = mutableListOf()
)
