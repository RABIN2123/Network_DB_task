package com.example.network_db_task.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    val id: Int = 0,
    val name: String,
    val dateOfBirth: String,
    val phone: String,
    val email: String,
    val picUrl: String
) : Parcelable
