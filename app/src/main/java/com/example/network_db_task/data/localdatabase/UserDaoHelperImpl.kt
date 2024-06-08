package com.example.network_db_task.data.localdatabase

class UserDaoHelperImpl(private val dao: UserDao) : UserDaoHelper {
    override suspend fun insertData(users: List<UserEntity>) {
        return dao.insertData(users)
    }

    override suspend fun deleteData() {
        return dao.deleteData()
    }

    override fun getLocalUsers(): List<UserEntity> {
        return dao.getLocalUsers()
    }

}