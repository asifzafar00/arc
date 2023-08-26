package com.hathway.androidarc.repo

import androidx.lifecycle.LiveData
import com.hathway.androidarc.database.Quote
import com.hathway.androidarc.database.QuoteDao

class QuoteRepository(private val quoteDao: QuoteDao) {

    fun getQuotes(): LiveData<List<Quote>> {
        return quoteDao.getQuotes()
    }

    suspend fun insertQuotes(quote: Quote) {
        return quoteDao.insertQuote(quote)
    }
}