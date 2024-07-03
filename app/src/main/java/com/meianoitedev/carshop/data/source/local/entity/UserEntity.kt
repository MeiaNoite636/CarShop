package com.meianoitedev.carshop.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.meianoitedev.carshop.util.ColumnsUser
import com.meianoitedev.carshop.util.Tables

@Entity(tableName = Tables.USER_TABLE)
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    @ColumnInfo(name = ColumnsUser.USER_NAME_COLUMN)
    val name: String,

    @ColumnInfo(name = ColumnsUser.USER_EMAIL_COLUMN)
    val email: String
)