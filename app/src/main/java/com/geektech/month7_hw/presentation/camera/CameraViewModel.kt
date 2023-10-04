package com.geektech.month7_hw.presentation.camera

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.month7_hw.data.repositories.CameraRepositoryImpl
import com.geektech.month7_hw.domain.models.CameraModel
import com.geektech.month7_hw.domain.usecases.GetAllCamerasUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(private val repositoryImpl: CameraRepositoryImpl) :
    ViewModel() {

    private val camerasUseCase = GetAllCamerasUseCase(repositoryImpl)

    val cameraList = MutableLiveData<List<CameraModel>>()

    init {
        getCameras()
    }

    fun getCameras() {
        viewModelScope.launch {
            camerasUseCase.getResult().collect { response ->
                cameraList.postValue(response)
                Log.d("ololo", "getCameras: ${response}")
            }
        }
    }
}