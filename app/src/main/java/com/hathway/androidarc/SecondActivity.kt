package com.hathway.androidarc

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hathway.androidarc.data.Message
import com.hathway.androidarc.viewmodel.MyViewModel

class SecondActivity:AppCompatActivity() {
    private  val TAG = "SecondActivity"
    private val sharedViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message(firstName = "ASIF    ", secondName = "Zafar  "))
        }
        Log.e(TAG, "onCreate: "+sharedViewModel.flavor.value.toString() )
    }
    @Composable
    fun MessageCard(data: Message) {
        Text(
            text = data.firstName,
            fontSize = 18.sp, modifier = Modifier.padding(54.dp)
        )
    }
}