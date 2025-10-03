package com.din.trademe.data.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


interface ListingRepository {
    suspend fun loadListing(): ListingData
}

