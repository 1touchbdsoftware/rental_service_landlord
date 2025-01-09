package com.onetouch.service.Utils

sealed class NetworkResult<T>(val message: String? = null, val data: T? = null) {

    class Error<T>(message: String, data: T? = null) : NetworkResult<T>(message, data)

    class Success<T>(message: String? = null, data: T) : NetworkResult<T>(message, data)

    class Loading<T> : NetworkResult<T>()

    class Empty<T> : NetworkResult<T>()
}