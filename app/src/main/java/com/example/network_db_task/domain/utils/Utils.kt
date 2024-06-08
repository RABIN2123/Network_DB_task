package com.example.network_db_task.domain.utils

import com.example.network_db_task.data.network.model.GenUserResponse
import com.example.network_db_task.domain.model.Item

fun GenUserResponse.convertJsonToLocalDb(): List<Item> {
    var id = 1
    return data.map { item ->
        Item(
            id = id++,
            name = item.name.first + " " + item.name.last,
            dateOfBirth = item.dob.date,
            phone = item.phone,
            email = item.email,
            picUrl = item.picture.picUrl
        )
    }
}