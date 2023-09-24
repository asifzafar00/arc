package com.hathway.androidarc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppTestViewModel : ViewModel() {

    lateinit var liveData: LiveData<Int>
    private lateinit var myObjLiveData: MutableLiveData<Int>

    fun addTwoNumber(a: Int = 10, b: Int = 20) {
        var re = a + b
        myObjLiveData.value = re
    }
}