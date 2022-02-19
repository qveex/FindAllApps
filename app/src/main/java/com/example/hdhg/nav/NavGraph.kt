package com.example.hdhg.nav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.hdhg.screens.AppListScreen
import com.example.hdhg.screens.AppScreen
import com.example.hdhg.screens.ScanScreen
import com.example.hdhg.viewModel.MainViewModel

@ExperimentalAnimationApi
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
            ScanScreen(viewModel = viewModel, navController = navController)
        }

        composable(route = Screen.AppsList.route) {
            AppListScreen(viewModel = viewModel, navController = navController)
        }

        composable(
            route = Screen.App.route,
            arguments = listOf(navArgument("appId") { type = NavType.IntType })
        ) {
            AppScreen(viewModel = viewModel, navController = navController, it.arguments!!.getInt("appId"))
        }

    }
}