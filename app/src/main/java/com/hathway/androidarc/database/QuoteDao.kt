package com.hathway.androidarc.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {
    @Query("SELECT * from quote")
    fun getQuotes(): LiveData<List<Quote>>// by default Live data is work ion background

    @Insert
    suspend fun insertQuote(quote: Quote)
}