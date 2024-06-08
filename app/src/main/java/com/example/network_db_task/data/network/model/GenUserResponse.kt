package com.example.network_db_task.data.network.model

import com.google.gson.annotations.SerializedName


data class GenUserResponse(
    @SerializedName("results")
    val data: List<UserJson>
) {
    data class UserJson(
        @SerializedName("name")
        val name: Name,
        @SerializedName("dob")
        val dob: Dob,
        @SerializedName("phone")
        val phone: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("picture")
        val picture: Picture
    ) {
        data class Name(
            @SerializedName("first")
            val first: String,
            @SerializedName("last")
            val last: String
        )

        data class Dob(
            @SerializedName("date")
            val date: String,
        )

        data class Picture(
            @SerializedName("medium")
            val picUrl: String
        )
    }
}




