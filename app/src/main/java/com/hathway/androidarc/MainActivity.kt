package com.hathway.androidarc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hathway.androidarc.database.Quote
import com.hathway.androidarc.database.QuoteDatabases
import com.hathway.androidarc.databinding.ActivityMainBinding
import com.hathway.androidarc.repo.QuoteRepository
import com.hathway.androidarc.viemModel.MainViewModel
import com.hathway.androidarc.viemModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = QuoteDatabases.getDatabasesObject(applicationContext).quoteDao()
        val repository = QuoteRepository(dao)
        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(repository)
        )[MainViewModel::class.java]

        mainViewModel.getQuotes().observe(this) {
            binding.quotes = it.toString()
        }

        binding.btnAddQuote.setOnClickListener {
            val quote = Quote(id = 0, "THis is testing", "chada")
            mainViewModel.insertQuote(quote)
        }
    }
}