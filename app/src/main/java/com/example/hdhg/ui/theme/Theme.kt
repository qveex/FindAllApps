package com.example.hdhg.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(

    background = EDarkBackground,
    onBackground = Color.White,


    primary = EDarkBackground,
    onPrimary = Color.White,
    primaryVariant = EDarkExtraBackground,
    secondary = Teal200,
)

private val LightColorPalette = lightColors(

    background = EBackground,
    onBackground = Color.Black,


    primary = Purple500,
    primaryVariant = EExtraBackground,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun HdhgTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val systemUiController = rememberSystemUiController()
    val colors = if (darkTheme) {
        systemUiController.setSystemBarsColor(color = EDarkBackground)
        DarkColorPalette
    } else {
        systemUiController.setSystemBarsColor(color = EBackground)
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}