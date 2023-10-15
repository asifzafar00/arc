package com.hathway.androidarc

import android.util.Log
import javax.inject.Inject

interface UserRepository {
    fun saveUser(email: String, password: String)
}
class SQlUserRepository @Inject constructor() : UserRepository {
    private val TAG = "UserRepository"
    override fun saveUser(email: String, password: String) {
        Log.e(TAG, "saveUser: $email - $password")
    }
}
class FireBaseUserRepository  : UserRepository {
    private val TAG = "UserRepository"
    override fun saveUser(email: String, password: String) {
        Log.e(TAG, "saveUser in Firebase: $email - $password")
    }
}