package com.din.trademe.ui.compose.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.din.trademe.R

sealed class AppScreens(
    val route: String,
    @StringRes val screenLabel: Int,
    @StringRes val screenTabLabel: Int,
    @DrawableRes val screenIcon: Int
) {
    data object Listing : AppScreens(
        route = "latest_screen",
        screenLabel = R.string.browse,
        screenTabLabel = R.string.listing,
        screenIcon = R.drawable.search
    )

    data object Watchlist : AppScreens(
        route = "watchlist_screen",
        screenLabel = R.string.watchlist,
        screenTabLabel = R.string.watchlist,
        screenIcon = R.drawable.binoculars
    )

    data object MyTradeMe : AppScreens(
        route = "my_trade_me_screen",
        screenLabel = R.string.my_trade_me,
        screenTabLabel = R.string.my_trade_me,
        screenIcon = R.drawable.profile
    )
}

val mainScreens = listOf(AppScreens.Listing, AppScreens.Watchlist, AppScreens.MyTradeMe)
