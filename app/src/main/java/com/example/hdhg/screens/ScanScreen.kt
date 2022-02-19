package com.example.hdhg.screens

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.drawable.toBitmap
import com.example.hdhg.models.App
import com.example.hdhg.ui.theme.Purple700
import com.example.hdhg.ui.theme.Teal200
import com.example.hdhg.ui.theme.grad
import com.example.hdhg.viewModel.MainViewModel
import com.example.hdhg.widgets.GradScanButton
import com.example.hdhg.widgets.ScanButton
import java.io.File

@Composable
fun ScanScreen(viewModel: MainViewModel) {

    val context = LocalContext.current

    Scaffold() {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            /*ScanButton(
                gradient = grad,
                onClicked = { viewModel.scan(context = context) }
            )*/
            GradScanButton(
                text = "SCAN",
                onClicked = { viewModel.scan(context = context) },
                gradient = grad,
                textColor = Color.White
            )
        }
    }
}