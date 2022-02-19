package com.example.hdhg.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

const val APP_ARGUMENT_KEY = "appId"

sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Scan: Screen(
        route = "scan",
        title = "Scan",
        icon = Icons.Outlined.Search
    )

    object AppsList: Screen(
        route = "appsList",
        title = "AppsList",
        icon = Icons.Outlined.List
    )

    object App: Screen(
        route = "app/{$APP_ARGUMENT_KEY}",
        title = "App",
        icon = Icons.Outlined.AccountBox
    ) {
        fun passId(appId: Int) = "app/$appId"
    }
}
