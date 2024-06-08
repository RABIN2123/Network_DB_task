package com.example.network_db_task.data.localdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {
    @Insert
    suspend fun insertData(users: List<UserEntity>)

    @Query("DELETE FROM ${UserEntity.TABLE_NAME}")
    suspend fun deleteData()

    @Query("SELECT * FROM ${UserEntity.TABLE_NAME} ORDER BY ${UserEntity.COLUMN_NAME} ASC")
    fun getLocalUsers(): List<UserEntity>
}