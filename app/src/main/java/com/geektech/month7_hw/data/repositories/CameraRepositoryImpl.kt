package com.geektech.month7_hw.data.repositories

import com.geektech.month7_hw.domain.utils.Resource
import com.geektech.month7_hw.data.db.dao.CameraDao
import com.geektech.month7_hw.data.retrofit.RetrofitService
import com.geektech.month7_hw.data.utils.convertToCamera
import com.geektech.month7_hw.data.utils.mapToCameraList
import com.geektech.month7_hw.data.utils.mapToCameraModel
import com.geektech.month7_hw.domain.models.CameraModel
import com.geektech.month7_hw.domain.repositories.CameraRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CameraRepositoryImpl @Inject constructor(
    private val cameraDao: CameraDao
) : CameraRepository {

    override suspend fun getAllCameras(): Flow<Resource<List<CameraModel>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = cameraDao.getAllCameras().mapToCameraModel()
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Message is empty"))
            }
        }
    }

    override suspend fun getResult(): Flow<Resource<List<CameraModel>>> {
        return flow {
            val data = RetrofitService.apiService.getCameras().body()?.data?.cameras
            if (data != null) {
                emit(Resource.Success(data))
                cameraDao.insertCamera(data.mapToCameraList())
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun insertCamera(cameras: List<CameraModel>) {
        TODO()
    }

    override suspend fun updateCamera(camera: CameraModel) {
        cameraDao.updateCamera(camera.convertToCamera())
    }

    override suspend fun deleteCamera(camera: CameraModel) {
        cameraDao.deleteCamera(camera.convertToCamera())
    }
}