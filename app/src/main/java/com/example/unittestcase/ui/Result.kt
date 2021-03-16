package com.example.unittestcase.ui

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Partial<out T : Any>(val data: T, val exception: Throwable? = null) : Result<T>()
    data class Error<out T : Any>(
            val exception: Throwable? = null
    ) : Result<T>()
}