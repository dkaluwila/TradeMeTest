package com.din.trademe.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.din.trademe.data.ListingDataUiState
import com.din.trademe.data.ListingRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(private val listingRepository: ListingRepositoryImpl) : ViewModel() {
    private val _listingDataUiState =
        MutableStateFlow<ListingDataUiState>(ListingDataUiState.Loading)

    val listingDataUiState: StateFlow<ListingDataUiState> = _listingDataUiState.asStateFlow()


    init {
        loadListing()
    }

    fun loadListing() {
        _listingDataUiState.value = ListingDataUiState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _listingDataUiState.update {
                    ListingDataUiState.Success(listingRepository.loadListing().listItems)
                }
            } catch (e: Exception) {
                _listingDataUiState.value = ListingDataUiState.Error(e.localizedMessage ?: "")
            }

        }
    }

}