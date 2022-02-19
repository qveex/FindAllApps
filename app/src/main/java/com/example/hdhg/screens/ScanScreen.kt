package com.example.hdhg.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.hdhg.nav.Screen
import com.example.hdhg.ui.theme.grad
import com.example.hdhg.viewModel.MainViewModel
import com.example.hdhg.widgets.GradScanButton

@Composable
fun ScanScreen(viewModel: MainViewModel, navController: NavController) {

    val context = LocalContext.current

    Scaffold {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            GradScanButton(
                text = "SCAN",
                onClicked = {
                    viewModel.scan(context = context)
                    navController.navigate(route = Screen.AppsList.route)
                },
                gradient = grad,
                textColor = Color.White
            )
        }
    }
}