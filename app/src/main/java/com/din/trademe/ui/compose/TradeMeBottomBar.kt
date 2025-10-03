package com.din.trademe.ui.compose

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.din.trademe.ui.compose.screens.mainScreens

@Composable
fun TradeMeBottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    currentDestination: NavDestination?
) {
    NavigationBar(modifier = modifier) {
        mainScreens.forEach { screen ->
            val screenLabel = stringResource(screen.screenTabLabel)
            NavigationBarItem(
                label = {
                    Text(screenLabel)
                },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = screen.screenIcon),
                        contentDescription = screenLabel
                    )
                },
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.tertiary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    selectedTextColor = MaterialTheme.colorScheme.tertiary,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }
    }

}