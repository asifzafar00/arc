package com.hathway.androidarc

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.*

class QuoteDaoTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var quoteDatabase: QuoteDatabase
    lateinit var quoteDao: QuoteDao



    @Before
    fun setUp() {
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()
        quoteDao=quoteDatabase.quoteDao()
    }

    @Test
    fun insertQuote_expectedSingleQuotes() = runBlocking {
        val quote = Quote(0, "This is a test quote", "Hathway")
        quoteDao.insertQuote(quote = quote)
        val result = quoteDao.getQuotes().getOrAwaitValue()
        Assert.assertEquals(1, result.size)
        Assert.assertEquals("This is a test quote", result[0].text)
    }


    @Test
    fun deletetQuote_expectedSingleQuotes() = runBlocking {
        val quote = Quote(0, "This is a test quote", "Hathway")
        quoteDao.insertQuote(quote = quote)
        quoteDao.delete()
        val result = quoteDao.getQuotes().getOrAwaitValue()

        Assert.assertEquals(0, result.size)
    }


    @After
    fun tearDown() {
       // quoteDatabase.close()
    }
}