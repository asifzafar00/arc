package com.hathway.androidarc.api

import com.hathway.androidarc.model.ProductListItem
import retrofit2.Response
import retrofit2.http.GET

interface ProductAPI {
    @GET("/products")
    suspend fun getProducts(): Response<List<ProductListItem>>
}