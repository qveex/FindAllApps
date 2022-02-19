package com.example.hdhg.screens

import android.content.pm.PackageManager
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.hdhg.nav.NavGraph
import com.example.hdhg.nav.Screen
import com.example.hdhg.viewModel.MainViewModel
import com.example.hdhg.widgets.MainTopBar


@Composable
fun MainScreen(viewModel: MainViewModel) {

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            MainTopBar(
                isDarkTheme = viewModel.isDarkThemeState.value,
                onThemeSwitch = { viewModel.changeThemeState() },
                onScanClicked = { navController.navigate(route = Screen.Scan.route) },
                onAppsClicked = { navController.navigate(route = Screen.AppsList.route) }
            )
        }
    ) {
        NavGraph(navController = navController, viewModel = viewModel)
    }

}