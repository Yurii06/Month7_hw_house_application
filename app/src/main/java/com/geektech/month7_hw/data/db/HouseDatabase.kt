package com.geektech.month7_hw.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.month7_hw.data.db.dao.CameraDao
import com.geektech.month7_hw.data.db.dao.DoorDao
import com.geektech.month7_hw.data.models.Camera
import com.geektech.month7_hw.data.models.Door

@Database(entities = [Camera::class, Door::class], version = 1, exportSchema = true)
abstract class HouseDatabase : RoomDatabase() {
    abstract fun getCameraDao(): CameraDao
    abstract fun getDoorDao(): DoorDao
}