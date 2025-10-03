package com.din.trademe.ui.compose

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.din.trademe.ui.compose.screens.AppScreens
import com.din.trademe.viewmodel.MainViewModel
import com.din.trademe.ui.compose.screens.ListingScreen
import com.din.trademe.ui.compose.screens.MyTradeMeScreen
import com.din.trademe.ui.compose.screens.WatchlistScreen

@Composable
fun TradeMeNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = "latest_screen",
    viewModel: MainViewModel
) {
    val uiState by viewModel.listingDataUiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(AppScreens.Listing.route) {
            ListingScreen(
                viewModel = viewModel,
                onItemClick = { listingId,listingTitle ->
                    Toast.makeText(context, "Clicked item : $listingTitle with item Id : $listingId", Toast.LENGTH_SHORT).show()
                }
            )
        }
        composable(AppScreens.Watchlist.route) {
            WatchlistScreen()
        }
        composable(AppScreens.MyTradeMe.route) {
            MyTradeMeScreen()
        }
    }

}