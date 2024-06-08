package com.example.network_db_task.data.localdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = UserEntity.TABLE_NAME)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID) val id: Int = 0,
    @ColumnInfo(name = COLUMN_NAME) val name: String,
    @ColumnInfo(name = COLUMN_BIRTH) val dateOfBirth: String,
    @ColumnInfo(name = COLUMN_PHONE) val phone: String,
    @ColumnInfo(name = COLUMN_EMAIL) val email: String,
    @ColumnInfo(name = COLUMN_IMAGE) val image: String
) {

    companion object {
        const val TABLE_NAME = "users"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val  COLUMN_BIRTH = "date_of_birth"
        const val COLUMN_PHONE = "phone"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_IMAGE = "image_url"
    }
}
