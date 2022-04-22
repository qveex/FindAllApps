package com.example.hdhg.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hdhg.R
import com.example.hdhg.ui.widgets.AppInfo
import com.example.hdhg.viewModel.MainViewModel

@Composable
fun AppScreen(viewModel: MainViewModel, navController: NavController, appId: Int) {

    val app = viewModel.getApp(appId)
    val smoothThemeGradient = Brush.linearGradient(
        listOf(
            MaterialTheme.colors.primaryVariant,
            MaterialTheme.colors.background
        )
    )
    Surface(
        color = MaterialTheme.colors.background,
    ) {
        Column(
            Modifier
                .padding(24.dp, 32.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            AppInfo(app = app)

            Spacer(modifier = Modifier.padding(20.dp))

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent
                ),
                contentPadding = PaddingValues(),
                shape = CircleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(shape = CircleShape, brush = smoothThemeGradient)
                        .fillMaxWidth()
                        .height(48.dp),
                    contentAlignment = Alignment.Center,

                ) {
                    Text(
                        text = stringResource(R.string.back_button)
                    )
                }
            }
        }
    }
}