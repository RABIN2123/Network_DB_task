package com.example.network_db_task.domain.repository

import com.example.network_db_task.data.localdatabase.UserDaoHelper
import com.example.network_db_task.data.localdatabase.UserEntity
import com.example.network_db_task.data.network.ApiHelper
import com.example.network_db_task.domain.model.User
import com.example.network_db_task.domain.utils.convertJsonToLocalDb

class MainRepository(private val apiHelper: ApiHelper, private val localDatabase: UserDaoHelper) {
    suspend fun getUsers(): List<User> {
        val newList: List<User> = try {
            apiHelper.getUser().convertJsonToLocalDb()
        } catch (ex: Exception) {
            getOutLocalDb()
        }
        return newList
    }

    suspend fun saveInLocalDb(userList: List<User>) {
        localDatabase.deleteData()
        localDatabase.insertData(
            userList.map { item ->
                UserEntity(
                    id = item.id,
                    name = item.name,
                    dateOfBirth = item.dateOfBirth,
                    phone = item.phone,
                    email = item.email,
                    image = item.picUrl
                )
            }
        )
    }

    private fun getOutLocalDb(): List<User> {
        val list = localDatabase.getLocalUsers()
        return list.map { item ->
            User(
                id = item.id,
                name = item.name,
                dateOfBirth = item.dateOfBirth,
                phone = item.phone,
                email = item.email,
                picUrl = item.image
            )
        }
    }

}