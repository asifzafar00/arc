package com.hathway.androidarc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hathway.androidarc.composeUI.MessageCard
import com.hathway.androidarc.data.Message
import com.hathway.androidarc.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {
    class TextFieldState() {
        var twoText: String by mutableStateOf("")
        var passwordString: String by mutableStateOf("")
        var usernameString: String by mutableStateOf("")
    }

    val viewModel: MyViewModel by viewModels()
    private val sharedViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message(firstName = "ASIF    ", secondName = "Zafar  "))
        }
        viewModel.flavor.observeForever { Log.e(TAG, "MessageCard: " + it) }
    }



    private val TAG = "MainActivity"
   

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(Message(firstName = "Asif", secondName = "Zafar"))
    }
}