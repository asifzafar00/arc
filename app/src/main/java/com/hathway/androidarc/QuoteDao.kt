package com.hathway.androidarc

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QuoteDao {

    @Insert
    suspend fun insertQuote(quote: Quote)

    @Update
    suspend fun updateQuote(quote: Quote)

    @Query("DELETE FROM quote")
    suspend fun delete()

    @Query("SELECT * FROM quote")
    fun getQuotes(): LiveData<List<Quote>>

    @Query("SELECT * FROM quote where id = :quoteId")
    suspend fun getQuoteByID(quoteId: Int): Quote

}