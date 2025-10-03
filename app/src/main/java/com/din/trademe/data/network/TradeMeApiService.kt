package com.din.trademe.data.network

import com.din.trademe.data.model.ListingsResponse
import retrofit2.http.GET

interface TradeMeApiService {
    @GET("v1/Listings/Latest.json")
    suspend fun getLatestListings(): ListingsResponse
}