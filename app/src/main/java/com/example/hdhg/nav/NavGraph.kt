@file:OptIn(ExperimentalFoundationApi::class)

package com.example.hdhg.nav

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.hdhg.ui.screens.AppListScreen
import com.example.hdhg.ui.screens.AppScreen
import com.example.hdhg.ui.screens.ScanScreen
import com.example.hdhg.viewModel.MainViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Scan.route
    ) {

        composable(
            route = Screen.Scan.route,
            enterTransition = { fadeIn(animationSpec = tween(600)) },
            exitTransition = { fadeOut(animationSpec = tween(600)) },
        ) {
            ScanScreen(viewModel = viewModel, navController = navController)
        }

        composable(
            route = Screen.AppsList.route,
            enterTransition = { fadeIn(animationSpec = tween(600)) },
            exitTransition = { fadeOut(animationSpec = tween(600)) },
        ) {
            AppListScreen(viewModel = viewModel, navController = navController)
        }

        composable(
            route = Screen.App.route,
            enterTransition = { fadeIn(animationSpec = tween(600)) },
            exitTransition = { fadeOut(animationSpec = tween(600)) },
            arguments = listOf(navArgument("appId") { type = NavType.IntType })
        ) {
            AppScreen(
                viewModel = viewModel,
                navController = navController,
                it.arguments!!.getInt("appId")
            )
        }

    }
}