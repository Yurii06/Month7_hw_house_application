package com.geektech.month7_hw.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.geektech.month7_hw.data.models.Camera

@Dao
interface CameraDao {
    @Query("SELECT * FROM camera")
    suspend fun getAllCameras(): List<Camera>

    @Insert
    suspend fun insertCamera(cameras: List<Camera>): Unit

    @Update
    suspend fun updateCamera(camera: Camera): Unit

    @Delete
    suspend fun deleteCamera(camera: Camera): Unit
}