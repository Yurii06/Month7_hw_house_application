package com.geektech.month7_hw.domain.models

data class DoorModel(
    val id: Int,
    val name: String = "Door",
    val image: String? = null,
    var isFavourite: Boolean = false
)