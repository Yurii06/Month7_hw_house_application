package com.geektech.month7_hw.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "door")
data class Door(
    @PrimaryKey
    val id: Int,
    val name: String = "Door",
    var isFavourite : Boolean = false
)