package com.example.network_db_task.domain

import com.example.network_db_task.data.localdatabase.UserDaoHelper
import com.example.network_db_task.data.localdatabase.UserEntity
import com.example.network_db_task.data.network.ApiHelper
import com.example.network_db_task.data.network.model.GenUserResponse.UserJson
import com.example.network_db_task.domain.model.Item

class MainRepository(private val apiHelper: ApiHelper, private val localDatabase: UserDaoHelper) {
    suspend fun getUsers(): List<Item> {
        val newList: List<Item> = try {
            val userList = apiHelper.getUser()
            convertJsonToLocalDb(userList.results)
        } catch (ex: Exception) {
            getOutLocalDb()
        }
        return newList
    }

    private fun convertJsonToLocalDb(userList: List<UserJson>): List<Item> {
        var id = 1
        return userList.map { item ->
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

    suspend fun saveInLocalDb(userList: List<Item>) {
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

    private fun getOutLocalDb(): List<Item> {
        val list = localDatabase.getLocalUsers()
        return list.map { item ->
            Item(
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