package com.din.trademe.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.din.trademe.viewmodel.MainViewModel
import com.din.trademe.ui.compose.screens.AppScreens
import com.din.trademe.ui.compose.screens.mainScreens
import com.din.trademe.ui.theme.TradeMeTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TradeMeApp(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel<MainViewModel>()
    ) {
    TradeMeTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val currentScreen = mainScreens.find { it.route == currentDestination?.route } ?: AppScreens.Listing

        Scaffold(
            topBar = {
                TradeMeTopAppBar(modifier = modifier,currentScreen = currentScreen)
            },
            bottomBar = {
                TradeMeBottomBar(
                    modifier = modifier,
                    navController = navController,
                    currentDestination = currentDestination
                )
            }
        ) { innerPadding ->
            TradeMeNavHost(
                modifier = modifier.padding(innerPadding),
                navController = navController,
                startDestination = currentScreen.route,
                viewModel = viewModel

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TradeMeAppPreview() {
    TradeMeTheme {
        TradeMeApp()
    }
}
