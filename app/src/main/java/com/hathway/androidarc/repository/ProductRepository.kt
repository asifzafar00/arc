package com.hathway.androidarc.repository

import com.hathway.androidarc.api.ProductAPI
import com.hathway.androidarc.model.ProductListItem
import com.hathway.androidarc.utils.NetworkResult

class ProductRepository(private val productAPI: ProductAPI) {

    suspend fun getProducts(): NetworkResult<List<ProductListItem>> {
        val response = productAPI.getProducts()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkResult.Success(responseBody)
            } else {
                NetworkResult.Error("Something went wrong")
            }
        } else {
            NetworkResult.Error("Something went wrong")
        }
    }
}