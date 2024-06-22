package com.example.network_db_task.domain.utils

import com.example.network_db_task.data.network.model.GenUserResponse
import com.example.network_db_task.domain.model.User

fun GenUserResponse.convertJsonToLocalDb(): List<User> {
    return data.mapIndexed { index, item ->
        User(
            id = index,
            name = item.name.first + " " + item.name.last,
            dateOfBirth = item.dob.date,
            phone = item.phone,
            email = item.email,
            picUrl = item.picture.picUrl
        )
    }
}