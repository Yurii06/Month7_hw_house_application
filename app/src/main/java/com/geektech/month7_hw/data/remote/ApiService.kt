package com.geektech.month7_hw.data.remote

import com.geektech.month7_hw.domain.models.CameraList
import com.geektech.month7_hw.domain.models.DoorList
import retrofit2.http.GET
import retrofit2.Response

interface ApiService {
    @GET("cameras")
    suspend fun getCameras(): Response<CameraList>

    @GET("doors")
    suspend fun getDoors(): Response<DoorList>
}