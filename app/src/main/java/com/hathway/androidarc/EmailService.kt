package com.hathway.androidarc

import android.util.Log
import javax.inject.Inject

class EmailService  @Inject constructor(){
    private val TAG = "EmailService"
    fun send(to: String, from: String, body: String) {
        Log.e(TAG, "send: $to -$from -$body")
    }
}