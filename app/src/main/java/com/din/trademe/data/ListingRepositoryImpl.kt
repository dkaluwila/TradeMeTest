package com.din.trademe.data.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListingRepositoryImpl() : ListingRepository {

    override suspend fun loadListing(): ListingData {

        return withContext(Dispatchers.IO) {
            try {
                val response  = ListingData.getHardcodedData()
                response
            } catch (e: Exception) {
                throw e
            }
        }
    }
}