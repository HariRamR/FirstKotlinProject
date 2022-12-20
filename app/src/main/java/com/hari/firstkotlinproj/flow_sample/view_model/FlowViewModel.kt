package com.hari.firstkotlinproj.flow_sample.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class FlowViewModel: ViewModel() {

    private val mutableStateFlow = MutableStateFlow("Default Text") // hot flow which will hold state
    var stateFlow = mutableStateFlow.asStateFlow()
    private val mutableSharedFlow = MutableSharedFlow<String>() // it will not hold state and emit single value
    var sharedFlow = mutableSharedFlow.asSharedFlow()

    val countDown = flow {       // cold flow which will just emits number of values over period of time

            var timerValue = 10
            while (timerValue >= 0){
                delay(1000L)
                emit(timerValue)
                timerValue--
            }
        }

    fun triggerStateFlow(){
        mutableStateFlow.value = "Mutable State Flow"
    }
    fun triggerSharedFlow(){
        viewModelScope.launch {

            mutableSharedFlow.emit("Mutable Shared Flow")
        }
    }
}