package com.example.hdhg.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hdhg.screens.AppListScreen
import com.example.hdhg.screens.AppScreen
import com.example.hdhg.screens.ScanScreen
import com.example.hdhg.viewModel.MainViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Scan.route
    ) {

        composable(route = Screen.Scan.route) {
            ScanScreen(viewModel = viewModel)
        }

        composable(route = Screen.AppsList.route) {
            AppListScreen(viewModel = viewModel)
        }

        composable(route = Screen.App.route) {
            AppScreen(viewModel = viewModel)
        }

    }
}