package com.din.trademe.ui.compose

import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.din.trademe.R
import com.din.trademe.ui.compose.screens.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TradeMeTopAppBar(modifier: Modifier = Modifier, currentScreen: AppScreens){
    val context = LocalContext.current
    TopAppBar(
        title = {
            Text(
                text = stringResource(
                    id = currentScreen.screenLabel
                )
            )
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Search clicked", Toast.LENGTH_SHORT).show()
            }) {
                Icon(ImageVector.vectorResource(id = R.drawable.search), tint = MaterialTheme.colorScheme.tertiary, contentDescription = stringResource(
                    R.string.search))
            }
            IconButton(onClick = {
                Toast.makeText(context, "Cart clicked", Toast.LENGTH_SHORT).show()
            }) {
                Icon(ImageVector.vectorResource(id = R.drawable.cart), tint = MaterialTheme.colorScheme.tertiary, contentDescription = stringResource(
                    R.string.shopping_cart))
            }
        }
    )
}