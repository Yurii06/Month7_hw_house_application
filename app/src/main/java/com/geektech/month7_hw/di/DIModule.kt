package com.geektech.month7_hw.di

import android.content.Context
import androidx.room.Room
import com.geektech.month7_hw.data.db.HouseDatabase
import com.geektech.month7_hw.data.db.dao.CameraDao
import com.geektech.month7_hw.data.db.dao.DoorDao
import com.geektech.month7_hw.data.repositories.CameraRepositoryImpl
import com.geektech.month7_hw.data.repositories.DoorRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DIModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): HouseDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = HouseDatabase::class.java,
            "house_database"
        ).build()
    }

    @Provides
    fun provideCameraDao(roomDatabase: HouseDatabase): CameraDao {
        return roomDatabase.getCameraDao()
    }

    @Provides
    fun provideDoorDao(roomDatabase: HouseDatabase): DoorDao {
        return roomDatabase.getDoorDao()
    }

    @Provides
    fun provideCameraRepository(
        cameraDao: CameraDao
    ): CameraRepositoryImpl = CameraRepositoryImpl(cameraDao)

    @Provides
    fun provideDoorRepository(
        doorDao: DoorDao
    ): DoorRepositoryImpl = DoorRepositoryImpl(doorDao)
}