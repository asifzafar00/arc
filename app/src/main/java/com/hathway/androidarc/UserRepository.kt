package com.hathway.androidarc

import android.util.Log
import javax.inject.Inject

class UserRepository @Inject constructor(){
    private val TAG = "UserRepository"
    fun saveUser(email: String, password: String) {
        Log.e(TAG, "saveUser: $email - $password")
    }
}