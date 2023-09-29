package com.hathway.androidarc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var obOfClassValidatePassword = ValidatePassword()
        var checkType = obOfClassValidatePassword.validatePassword("zxcdsasasasdws")
        Log.e(TAG, "Vcalid Password : " + checkType)
        println("Vcalid Password : " + checkType)
        println("stringReversal: " + obOfClassValidatePassword.stringReversal("asifhkkh"))
    }
}