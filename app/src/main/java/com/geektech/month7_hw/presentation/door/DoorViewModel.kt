package com.geektech.month7_hw.presentation.door

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.month7_hw.domain.models.DoorModel
import com.geektech.month7_hw.domain.usecases.GetAllDoorsUseCase
import com.geektech.month7_hw.domain.utils.Resource
import com.geektech.month7_hw.presentation.utils.UIState

@HiltViewModel
class DoorViewModel @Inject constructor(private val getAllDoorsUseCase: GetAllDoorsUseCase) :
    ViewModel() {

    private val _doorsList: MutableStateFlow<UIState<List<DoorModel>>> =
        MutableStateFlow(UIState.Loading())
    val doorsList: StateFlow<UIState<List<DoorModel>>> = _doorsList

    fun getAllDoors() {
        viewModelScope.launch {
            getAllDoorsUseCase.getAllDoors().collect { resource ->
                when (resource) {
                    is Resource.Loading -> _doorsList.value = UIState.Loading()
                    is Resource.Success -> {
                        if (resource.data != null) {
                            _doorsList.value = UIState.Success(data = resource.data)
                        } else {
                            _doorsList.value = UIState.Empty()
                        }
                    }
                    is Resource.Error -> _doorsList.value =
                        UIState.Error(message = resource.message ?: "Error")
                }
            }
        }
    }

    fun getResult() {
        viewModelScope.launch {
            getAllDoorsUseCase.getResult().collect { resource ->
                when (resource) {
                    is Resource.Loading -> _doorsList.value = UIState.Loading()
                    is Resource.Success -> {
                        if (resource.data != null) {
                            _doorsList.value = UIState.Success(data = resource.data)
                            Log.d("ololo", "getResult: ${_doorsList}")
                        } else {
                            _doorsList.value = UIState.Empty()
                        }
                    }

                    is Resource.Error -> _doorsList.value =
                        UIState.Error(message = resource.message ?: "Error")
                }
            }
        }
    }
}