package com.example.hdhg.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.hdhg.viewModel.MainViewModel

@Composable
fun AppScreen(viewModel: MainViewModel) {
    Scaffold() {
        Box(
            Modifier.fillMaxSize()
        ) {
            Text(text = "App")
        }
    }
}