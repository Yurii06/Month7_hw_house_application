package com.geektech.month7_hw.domain.models

data class CameraList(
    var data: CameraData
)

data class CameraData(
    var cameras: List<CameraModel>
)