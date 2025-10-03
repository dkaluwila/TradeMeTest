package com.din.trademe.data

import com.din.trademe.data.model.ListingItem

sealed interface ListingDataUiState {
    object Initial : ListingDataUiState
    object Loading : ListingDataUiState
    data class Success(val listingData: List<ListingItem>) : ListingDataUiState
    data class Error(val errorMessage: String) : ListingDataUiState
}