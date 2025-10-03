package com.din.trademe.data

import com.din.trademe.data.model.ListingItemResponse

sealed interface ListingDataUiState {
    object Initial : ListingDataUiState
    object Loading : ListingDataUiState
    data class Success(val listingItems: List<ListingItemResponse>) : ListingDataUiState
    data class Error(val errorMessage: String) : ListingDataUiState
}