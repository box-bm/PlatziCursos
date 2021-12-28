package com.boxmanzog.kotlinfirebase.network

interface Callback<T> {
    fun onSuccess(result: T?)
    fun onFailed(exception: Exception)
}