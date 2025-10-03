package com.din.trademe.ui.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.din.trademe.data.ListingDataUiState
import com.din.trademe.viewmodel.MainViewModel
import com.din.trademe.ui.compose.ListingItem

@Composable
fun ListingScreen(
    viewModel: MainViewModel = viewModel(),
    onItemClick: (itemId: String, itemTitle: String) -> Unit = { _, _ -> }

) {
    val uiState by viewModel.listingDataUiState.collectAsState()
    when (uiState) {
        is ListingDataUiState.Loading, is ListingDataUiState.Initial -> {
            Box(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
                CircularProgressIndicator()
            }
        }
        is ListingDataUiState.Success -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize().padding(16.dp)
            ) {
                items((uiState as ListingDataUiState.Success).listingData) { item ->
                    ListingItem(
                        item = item,
                        onItemClick = { onItemClick(item.listingId.toString(),item.title) }
                    )
                }
            }
        }
        is ListingDataUiState.Error -> {
            Box(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
                Text(text = (uiState as ListingDataUiState.Error).errorMessage)
                Button(onClick = { viewModel.loadListing() }) {
                    Text("Retry")
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LatestScreenPreview() {
    ListingScreen()
}