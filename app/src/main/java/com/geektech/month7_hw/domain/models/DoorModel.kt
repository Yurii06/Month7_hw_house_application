package com.geektech.month7_hw.domain.models

import androidx.room.PrimaryKey

data class DoorModel(
    @PrimaryKey
    val id: Int,
    val name: String = "Door",
    var isFavourite : Boolean = false
)