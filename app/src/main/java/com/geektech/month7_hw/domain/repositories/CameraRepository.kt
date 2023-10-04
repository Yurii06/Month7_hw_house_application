package com.geektech.month7_hw.domain.repositories

import com.geektech.month7_hw.domain.utils.Resource
import com.geektech.month7_hw.domain.models.CameraModel
import kotlinx.coroutines.flow.Flow

interface CameraRepository {

    suspend fun getAllCameras(): Flow<Resource<List<CameraModel>>>

    suspend fun getResult(): Flow<List<CameraModel>>

    suspend fun insertCamera(camera: CameraModel): Unit

    suspend fun updateCamera(camera: CameraModel): Unit

    suspend fun deleteCamera(camera: CameraModel): Unit
}