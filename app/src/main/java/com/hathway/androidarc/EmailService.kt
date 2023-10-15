package com.hathway.androidarc

import android.util.Log
import javax.inject.Inject

interface NotificationService {
    fun send(to: String, from: String, body: String)
}

class EmailService @Inject constructor() : NotificationService {
    private val TAG = "EmailService"
    override fun send(to: String, from: String, body: String) {
        Log.e(TAG, "send Via Email Service: $to -$from -$body")
    }
}
class MessageService @Inject constructor():NotificationService{
    private  val TAG = "EmailService"
    override fun send(to: String, from: String, body: String) {
        Log.e(TAG, "send Via FireBase: $to -$from -$body")

    }

}