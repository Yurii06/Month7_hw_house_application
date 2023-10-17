package com.geektech.month7_hw.domain.repositories


import com.geektech.month7_hw.domain.models.DoorModel
import com.geektech.month7_hw.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DoorRepository {

    suspend fun getAllDoors(): Flow<Resource<List<DoorModel>>>

    suspend fun getResult() : Flow<Resource<List<DoorModel>>>

    suspend fun insertDoor(doors: List<DoorModel>): Unit

    suspend fun updateDoor(door: DoorModel): Unit

    suspend fun deleteDoor(door: DoorModel): Unit
}