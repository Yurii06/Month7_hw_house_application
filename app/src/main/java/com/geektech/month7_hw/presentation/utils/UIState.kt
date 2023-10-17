package com.geektech.month7_hw.presentation.utils

sealed class UIState<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T>() : UIState<T>()
    class Success<T>(data: T?) : UIState<T>(data = data)
    class Empty<T> : UIState<T>()
    class Error<T>(message: String?) : UIState<T>(message = message)
}