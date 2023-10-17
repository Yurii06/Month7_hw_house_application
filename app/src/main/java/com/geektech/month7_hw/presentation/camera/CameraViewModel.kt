package com.geektech.month7_hw.presentation.camera

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.month7_hw.data.repositories.CameraRepositoryImpl
import com.geektech.month7_hw.domain.models.CameraModel
import com.geektech.month7_hw.domain.usecases.GetAllCamerasUseCase
import com.geektech.month7_hw.domain.utils.Resource
import com.geektech.month7_hw.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(private val getAllCamerasUseCase: GetAllCamerasUseCase) :
    ViewModel() {

    private val _cameraList: MutableStateFlow<UIState<List<CameraModel>>> =
        MutableStateFlow(UIState.Loading())
    val camerasList: StateFlow<UIState<List<CameraModel>>> = _cameraList

    fun getAllCameras() {
        viewModelScope.launch {
            getAllCamerasUseCase.getAllCameras().collect { resource ->
                when (resource) {
                    is Resource.Loading -> _cameraList.value = UIState.Loading()
                    is Resource.Success -> {
                        if (resource.data != null) {
                            _cameraList.value = UIState.Success(data = resource.data)
                            Log.d("ololo", "getAllCameras: ${_cameraList}")
                        } else {
                            _cameraList.value = UIState.Empty()
                        }
                    }

                    is Resource.Error -> _cameraList.value =
                        UIState.Error(message = resource.message ?: "Error")
                }
            }
        }
    }

    fun getResult() {
        viewModelScope.launch {
            getAllCamerasUseCase.getResult().collect { resource ->
                when (resource) {
                    is Resource.Loading -> _cameraList.value = UIState.Loading()
                    is Resource.Success -> {
                        if (resource.data != null) {
                            _cameraList.value = UIState.Success(data = resource.data)
                            Log.d("ololo", "getResult: ${_cameraList}")
                        } else {
                            _cameraList.value = UIState.Empty()
                        }
                    }

                    is Resource.Error -> _cameraList.value =
                        UIState.Error(message = resource.message ?: "Error")
                }
            }
        }
    }
}