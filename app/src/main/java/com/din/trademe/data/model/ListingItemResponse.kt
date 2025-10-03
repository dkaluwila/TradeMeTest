package com.din.trademe.data.model

import com.google.gson.annotations.SerializedName

/**
 * Represents a single listing item from the TradeMe API.
 */
data class ListingItemResponse(
    @SerializedName("ListingId")
    val listingId: Long,

    @SerializedName("Title")
    val title: String,

    @SerializedName("Region")
    val region: String,

    @SerializedName("PriceDisplay")
    val priceDisplay: String,

    @SerializedName("PictureHref")
    val pictureHref: String?,

    @SerializedName("IsClassified")
    val isClassified: Boolean,

    @SerializedName("BuyNowPrice")
    val buyNowPrice: Double?,

    @SerializedName("HasBuyNow")
    val hasBuyNow: Boolean
)