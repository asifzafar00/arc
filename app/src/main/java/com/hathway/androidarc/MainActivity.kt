package com.hathway.androidarc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hathway.androidarc.adapter.ProductAdapter
import com.hathway.androidarc.utils.NetworkResult
import com.hathway.androidarc.viewmodels.MainViewModel
import com.hathway.androidarc.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ProductAdapter
    private  val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.productList)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val repository = (application as StoreApplication).productRepository
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]
        mainViewModel.getProduct()

        mainViewModel.products.observe(this, Observer {
            when(it){
                is NetworkResult.Success ->{
                    Log.e(TAG, "IND: "+it.data.toString() )
                    adapter = ProductAdapter(it.data!!)
                    recyclerView.adapter =adapter
                }
                is NetworkResult.Error ->{}
                else -> {
                    Log.e(TAG, "loading error : ", )}
            }

        })

    }
}