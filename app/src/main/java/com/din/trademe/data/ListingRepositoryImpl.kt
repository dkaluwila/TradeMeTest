package com.din.trademe.data

import com.din.trademe.data.model.ListingItemResponse
import com.din.trademe.data.model.ListingsResponse
import com.din.trademe.data.network.TradeMeApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListingRepositoryImpl(private val apiService: TradeMeApiService) : ListingRepository {

    override suspend fun loadListing(): ListingsResponse {
        // Execute api access in a background thread
        return withContext(Dispatchers.IO) {
            try {
                // Fetch data from the TradeMe API
                val response = apiService.getLatestListings()

                // Map the API response model to UI model
                val listItems = response.listItems.map { apiItem ->
                    ListingItemResponse(
                        listingId = apiItem.listingId,
                        pictureHref = apiItem.pictureHref ?: "",
                        title = apiItem.title,
                        priceDisplay = apiItem.priceDisplay,
                        region = apiItem.region,
                        isClassified = apiItem.isClassified,
                        buyNowPrice = apiItem.buyNowPrice,
                        hasBuyNow = apiItem.hasBuyNow
                    )
                }
                // Return the data wrapped in ListingData class
                ListingsResponse(listItems)
            } catch (e: Exception) {
                throw e
            }
        }
    }
}
