package com.geektech.month7_hw.domain.usecases

import com.geektech.month7_hw.data.repositories.DoorRepositoryImpl
import javax.inject.Inject

class GetAllDoorsUseCase @Inject constructor(
    private val repository : DoorRepositoryImpl
){
    suspend fun getAllDoors() = repository.getAllDoors()

    suspend fun getResult() = repository.getResult()
}