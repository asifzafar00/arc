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

    @Composable
    fun MessageCard(data: Message) {
        val passwordString = remember { mutableStateOf("") }
        val usernameString = remember { mutableStateOf("") }
        val valueText = remember { viewModel.userName_password }
        //  var valueText by remember { mutableStateOf(viewModel.userName_password) }

        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .height(350.dp)
                    .padding(16.dp)

            ) {
                Row(
                    horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Activity One",
                        style = MaterialTheme.typography.h4,
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Name",
                        fontSize = 18.sp
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()
                ) {

                    OutlinedTextField(
                        value = usernameString.value,
                        onValueChange = { usernameString.value = it },
                        label = { Text("Name Input") }
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Password",
                        fontSize = 18.sp
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()
                ) {

                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.None,
                            autoCorrect = true,
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        value = passwordString.value,
                        onValueChange = {
                            passwordString.value = it

                        },
                        label = { Text("Password Input") },
                        placeholder = { Text(text = "Your Placeholder/Hint") }
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                ) {
                    Button(
                        onClick = { myButtonOnClick(usernameString.value, passwordString.value) },
                        colors = ButtonDefaults.buttonColors(Color.Blue)
                    ) {
                        Text(text = "click me")
                    }

                }
                Row(
                    horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()
                ) {
                    // Text(text = valueText)
                    Log.e(TAG, "IND: " + valueText.value)
                    Text(text = valueText.value ?: "")


                }
            }
        }

    }

    private val TAG = "MainActivity"
    fun myButtonOnClick(username: String, password: String) {
        viewModel.setFlavor(username)
        viewModel.savedButtonData(username, password)
        Log.e(TAG, "myButtonOnClick: " + viewModel.userName_password.value)
        //startActivity(Intent(this,SecondActivity::class.java))
        Toast.makeText(this, viewModel.userName_password.value, Toast.LENGTH_LONG).show()
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(Message(firstName = "Asif", secondName = "Zafar"))
    }
}