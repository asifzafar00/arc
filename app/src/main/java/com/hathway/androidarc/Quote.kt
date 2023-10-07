package com.hathway.androidarc

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(
    @PrimaryKey
    val id: Int,
    val text: String,
    val author: String
)
