package com.din.trademe.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ListingData(
    val listItems: List<ListingItem>) {

    companion object {
        fun getHardcodedData(): ListingData {
            return ListingData(
                listItems = listOf(
                    ListingItem(
                        listingId = 6128739,
                        title = "Vintage Leather Jacket",
                        region = "Auckland",
                        priceDisplay = "$150.00",
                        pictureHref = "https://i.pravatar.cc/150?img=1",
                        isClassified = false,
                        buyNowPrice = 150.00,
                        hasBuyNow = true
                    ),
                    ListingItem(
                        listingId = 6128740,
                        title = "Antique Wooden Chair",
                        region = "Wellington",
                        priceDisplay = "$85.00",
                        pictureHref = "https://i.pravatar.cc/150?img=2",
                        isClassified = true,
                        buyNowPrice = null,
                        hasBuyNow = false
                    ),
                    ListingItem(
                        listingId = 6128741,
                        title = "Modern Art Print",
                        region = "Christchurch",
                        priceDisplay = "$45.00",
                        pictureHref = "https://i.pravatar.cc/150?img=3",
                        isClassified = false,
                        buyNowPrice = 45.00,
                        hasBuyNow = true
                    ),
                    ListingItem(
                        listingId = 6128742,
                        title = "Designer Handbag",
                        region = "Auckland",
                        priceDisplay = "$320.00",
                        pictureHref = "https://i.pravatar.cc/150?img=4",
                        isClassified = false,
                        buyNowPrice = 320.00,
                        hasBuyNow = true
                    ),
                    ListingItem(
                        listingId = 6128743,
                        title = "Electric Guitar",
                        region = "Dunedin",
                        priceDisplay = "$500.00",
                        pictureHref = "https://i.pravatar.cc/150?img=5",
                        isClassified = false,
                        buyNowPrice = null,
                        hasBuyNow = false
                    ),
                    ListingItem(
                        listingId = 6128744,
                        title = "Mountain Bike",
                        region = "Queenstown",
                        priceDisplay = "$750.00",
                        pictureHref = "https://i.pravatar.cc/150?img=6",
                        isClassified = true,
                        buyNowPrice = 750.00,
                        hasBuyNow = true
                    ),
                    ListingItem(
                        listingId = 6128745,
                        title = "Rare Stamp Collection",
                        region = "Hamilton",
                        priceDisplay = "$1200.00",
                        pictureHref = "https://i.pravatar.cc/150?img=7",
                        isClassified = false,
                        buyNowPrice = null,
                        hasBuyNow = false
                    ),
                    ListingItem(
                        listingId = 6128746,
                        title = "First Edition Book",
                        region = "Wellington",
                        priceDisplay = "$95.00",
                        pictureHref = "https://i.pravatar.cc/150?img=8",
                        isClassified = false,
                        buyNowPrice = 95.00,
                        hasBuyNow = true
                    ),
                    ListingItem(
                        listingId = 6128747,
                        title = "Professional Camera",
                        region = "Auckland",
                        priceDisplay = "$1500.00",
                        pictureHref = "https://i.pravatar.cc/150?img=9",
                        isClassified = false,
                        buyNowPrice = 1500.00,
                        hasBuyNow = true
                    ),
                    ListingItem(
                        listingId = 6128748,
                        title = "Handmade Pottery Set",
                        region = "Nelson",
                        priceDisplay = "$180.00",
                        pictureHref = "https://i.pravatar.cc/150?img=10",
                        isClassified = true,
                        buyNowPrice = null,
                        hasBuyNow = false
                    ),
                    ListingItem(
                        listingId = 6128749,
                        title = "Retro Video Game Console",
                        region = "Christchurch",
                        priceDisplay = "$250.00",
                        pictureHref = "https://i.pravatar.cc/150?img=11",
                        isClassified = false,
                        buyNowPrice = 250.00,
                        hasBuyNow = true
                    ),
                    ListingItem(
                        listingId = 6128750,
                        title = "Surfboard",
                        region = "Tauranga",
                        priceDisplay = "$400.00",
                        pictureHref = "https://i.pravatar.cc/150?img=12",
                        isClassified = false,
                        buyNowPrice = 400.00,
                        hasBuyNow = true
                    ),
                    ListingItem(
                        listingId = 6128751,
                        title = "Gourmet Coffee Beans",
                        region = "Wellington",
                        priceDisplay = "$30.00",
                        pictureHref = "https://i.pravatar.cc/150?img=13",
                        isClassified = true,
                        buyNowPrice = 30.00,
                        hasBuyNow = true
                    ),
                    ListingItem(
                        listingId = 6128752,
                        title = "Smartwatch",
                        region = "Auckland",
                        priceDisplay = "$280.00",
                        pictureHref = "https://i.pravatar.cc/150?img=14",
                        isClassified = false,
                        buyNowPrice = 280.00,
                        hasBuyNow = true
                    ),
                    ListingItem(
                        listingId = 6128753,
                        title = "Yoga Mat and Blocks",
                        region = "Nelson",
                        priceDisplay = "$60.00",
                        pictureHref = "https://i.pravatar.cc/150?img=15",
                        isClassified = false,
                        buyNowPrice = 60.00,
                        hasBuyNow = true
                    ),
                    ListingItem(
                        listingId = 6128754,
                        title = "Camping Tent for Four",
                        region = "Queenstown",
                        priceDisplay = "$220.00",
                        pictureHref = "https://i.pravatar.cc/150?img=16",
                        isClassified = true,
                        buyNowPrice = null,
                        hasBuyNow = false
                    ),
                    ListingItem(
                        listingId = 6128755,
                        title = "Drone with 4K Camera",
                        region = "Auckland",
                        priceDisplay = "$950.00",
                        pictureHref = "https://i.pravatar.cc/150?img=17",
                        isClassified = false,
                        buyNowPrice = null,
                        hasBuyNow = false
                    ),
                    ListingItem(
                        listingId = 6128756,
                        title = "Leather Sofa",
                        region = "Christchurch",
                        priceDisplay = "$1100.00",
                        pictureHref = "https://i.pravatar.cc/150?img=18",
                        isClassified = true,
                        buyNowPrice = 1100.00,
                        hasBuyNow = true
                    ),
                    ListingItem(
                        listingId = 6128757,
                        title = "Silver Necklace",
                        region = "Dunedin",
                        priceDisplay = "$130.00",
                        pictureHref = "https://i.pravatar.cc/150?img=19",
                        isClassified = false,
                        buyNowPrice = 130.00,
                        hasBuyNow = true
                    ),
                    ListingItem(
                        listingId = 6128758,
                        title = "Robot Vacuum Cleaner",
                        region = "Wellington",
                        priceDisplay = "$450.00",
                        pictureHref = "https://i.pravatar.cc/150?img=20",
                        isClassified = false,
                        buyNowPrice = 450.00,
                        hasBuyNow = true
                    )
                )
            )
        }
    }
}

