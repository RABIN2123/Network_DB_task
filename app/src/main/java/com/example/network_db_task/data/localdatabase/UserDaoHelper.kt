package com.example.network_db_task.data.localdatabase


interface UserDaoHelper {
    suspend fun insertData(users: List<UserEntity>)

    suspend fun deleteData()

    fun getLocalUsers(): List<UserEntity>
}