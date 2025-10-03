package com.din.trademe.ui.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.din.trademe.R
import com.din.trademe.data.model.ListingItemResponse

@Composable
fun TradeMeListingItem(item: ListingItemResponse, onItemClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth().height(128.dp),
    ) {
        HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f), modifier = Modifier.padding(top = 3.dp, bottom = 3.dp))
        Row (modifier = Modifier.clickable(onClick = onItemClick)){
            AsyncImage(
                model = item.pictureHref,
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                error = painterResource(id = R.drawable.ic_launcher_background),
                modifier = Modifier
                    .size(120.dp)
            )
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(
                    text = item.region,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth().fillMaxHeight(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = item.priceDisplay,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = "Reserved Met",
                            style = MaterialTheme.typography.bodySmall,
                        )

                    }
                    if (item.hasBuyNow) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = item.priceDisplay,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.End,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            )
                            Text(
                                text = "Buy Now",
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.End,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListingItemPreview() {
    TradeMeListingItem(
        item = ListingItemResponse(
            listingId = 123456,
            title = "A Great Item for Sale",
            region = "Auckland",
            pictureHref = "https://example.com/image.jpg",
            priceDisplay = "$100.00",
            buyNowPrice = 100.0,
            isClassified = false,
            hasBuyNow = true
        ), onItemClick = {}
    )
}
