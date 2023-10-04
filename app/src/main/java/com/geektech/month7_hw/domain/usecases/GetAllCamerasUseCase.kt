package com.geektech.month7_hw.domain.usecases

import com.geektech.month7_hw.data.repositories.CameraRepositoryImpl
import javax.inject.Inject

class GetAllCamerasUseCase @Inject constructor(
    private val repository: CameraRepositoryImpl
) {
    suspend fun getAllDoors() = repository.getAllCameras()

    suspend fun getResult() = repository.getResult()
}