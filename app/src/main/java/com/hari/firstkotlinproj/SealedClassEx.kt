package com.hari.firstkotlinproj

sealed class SealedClassEx {
    data class Success(val data: String): SealedClassEx()
    data class Error(val error: String)
    object Loading: SealedClassEx(){
        var obj: String = "Empty"
    }
}