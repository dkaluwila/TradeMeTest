package com.din.trademe.data.model

import com.google.gson.annotations.SerializedName
/**
 * Represents listing items from the TradeMe API.
 */
data class ListingsResponse(
    @SerializedName("List")
    val listItems: List<ListingItemResponse>
)
