package com.din.trademe.data

import com.din.trademe.data.model.ListingsResponse


interface ListingRepository {
    suspend fun loadListing(): ListingsResponse
}

