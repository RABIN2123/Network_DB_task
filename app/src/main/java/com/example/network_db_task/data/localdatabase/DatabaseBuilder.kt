package com.example.network_db_task.data.localdatabase

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    fun getDatabase(context: Context) = synchronized(this) {
        Room.databaseBuilder(context, UserDatabase::class.java, "database.db").build().dao
    }
}