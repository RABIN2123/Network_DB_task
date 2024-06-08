package com.example.network_db_task.data.network.model

import com.google.gson.annotations.SerializedName


data class GenUserResponse(
    val results: List<UserJson>
) {
    data class UserJson(
        val name: Name,
        val dob: Dob,
        val phone: String,
        val email: String,
        val picture: Picture
    ) {
        data class Name(
            val first: String,
            val last: String
        )

        data class Dob(
            val date: String,
        )

        data class Picture(
            @SerializedName("medium")
            val picUrl: String
        )
    }
}




