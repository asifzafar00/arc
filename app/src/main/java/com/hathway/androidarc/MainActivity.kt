package com.hathway.androidarc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.hathway.androidarc.data.DefaultData
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val presenter: UserPresenter by inject()
    private val viewModel : UserViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       title=viewModel.sayHello("hello sam")

        val name = DefaultData.DEFAULT_USER.name
        val textField = findViewById<TextView>(R.id.text)
        textField.text = "${presenter.sayHello(name)} \n ${viewModel.sayHello(name)}"
    }
}