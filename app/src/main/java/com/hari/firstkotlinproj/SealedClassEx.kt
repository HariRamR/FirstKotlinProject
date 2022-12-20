package com.hari.firstkotlinproj

sealed class SealedClassEx {
    data class Success(val data: String): SealedClassEx()
    data class Error(val error: String): SealedClassEx()
    object Loading: SealedClassEx(){
        var obj: String = "Empty"
    }
    companion object{

        fun getOutput(value: String): SealedClassEx{
           return when(value){
                "success" -> Success("Success")
                "loading" -> Loading
                "error" -> Error("Error")
               else -> Loading
           }
        }
    }
}