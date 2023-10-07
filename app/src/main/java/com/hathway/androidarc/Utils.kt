package com.hathway.androidarc

import kotlinx.coroutines.*

class Utils(val dispatcher: CoroutineDispatcher) {
    suspend fun getUserName(): String {
        delay(1000)
        return "HEllo Test"
    }

    suspend fun getUser(): String {
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
        }
        return "User India"

    }

    suspend fun getAddress(): String {
        withContext(dispatcher) {
            delay(2000)
        }
        return "User India"

    }

    var globalArg = false
    suspend fun getName(): String {
        CoroutineScope(dispatcher).launch {
            globalArg=true
        }
        return "User India"

    }
}