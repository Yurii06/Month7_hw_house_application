package com.geektech.month7_hw.data.utils

import com.geektech.month7_hw.data.models.Camera
import com.geektech.month7_hw.data.models.Door
import com.geektech.month7_hw.domain.models.CameraModel
import com.geektech.month7_hw.domain.models.DoorModel

fun List<Camera>.mapToCameraModel() = this.map { camera ->
    CameraModel(
        id = camera.id,
        name = camera.name,
        image = camera.image,
        isFavourite = camera.isFavourite
    )
}

fun List<CameraModel>.mapToCameraList() = this.map { camera ->
    Camera(
        id = camera.id,
        name = camera.name,
        image = camera.image,
        isFavourite = camera.isFavourite
    )
}

fun List<Door>.mapToDoorModel() = this.map { door ->
    DoorModel(
        id = door.id,
        name = door.name,
        isFavourite = door.isFavourite
    )
}

fun List<DoorModel>.mapToDoorList() = this.map { door ->
    Door(
        id = door.id,
        name = door.name,
        isFavourite = door.isFavourite
    )
}

fun CameraModel.convertToCamera() =
    Camera(
        id = this.id,
        name = this.name,
        image = this.image,
        isFavourite = this.isFavourite
    )

fun DoorModel.convertToDoor() =
    Door(
        id = this.id,
        name = this.name,
        isFavourite = this.isFavourite
    )