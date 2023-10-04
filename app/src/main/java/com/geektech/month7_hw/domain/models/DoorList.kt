package com.geektech.month7_hw.domain.models

data class DoorList(
    var data: DoorData
)

data class DoorData(
    var doors: List<DoorModel>
)