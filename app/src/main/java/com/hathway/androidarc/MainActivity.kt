package com.hathway.androidarc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    lateinit var mainViewModel: MainViewModel

    private val quoteText: TextView
        get() = findViewById(R.id.quote)

    private val authorText: TextView
        get() = findViewById(R.id.author)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun nextQuote(view: View) {
        Toast.makeText(this, "dad", Toast.LENGTH_LONG).show()
        quoteText.text="sddsd"
    }

}