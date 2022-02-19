package com.example.hdhg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Surface
import com.example.hdhg.screens.MainScreen
import com.example.hdhg.ui.theme.HdhgTheme
import com.example.hdhg.viewModel.MainViewModel


@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HdhgTheme(darkTheme = viewModel.isDarkThemeState.value) {
                Surface {
                    MainScreen(viewModel = viewModel)
                }
            }
        }
    }
}
