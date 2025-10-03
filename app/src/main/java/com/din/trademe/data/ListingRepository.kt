package com.din.trademe.data

import com.din.trademe.data.model.ListingData


interface ListingRepository {
    suspend fun loadListing(): ListingData
}

