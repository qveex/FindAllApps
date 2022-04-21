package com.example.hdhg.ui.widgets

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.hdhg.models.App
import kotlinx.coroutines.launch

@Composable
fun AppItem(app: App, onClicked: () -> Unit) {

    val smoothThemeGradient = Brush.linearGradient(
        listOf(
            MaterialTheme.colors.primaryVariant,
            MaterialTheme.colors.background
        )
    )
    Button(
        onClick = { onClicked() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        shape = RoundedCornerShape(size = 32.dp),
        contentPadding = PaddingValues(1.dp),
        modifier = Modifier
            .background(shape = RoundedCornerShape(size = 32.dp), brush = smoothThemeGradient)
            .border(
                shape = RoundedCornerShape(size = 32.dp),
                border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant)
            )
            .width(LocalConfiguration.current.screenWidthDp.dp / 2 - 24.dp)
            .height(LocalConfiguration.current.screenHeightDp.dp / 4),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                bitmap = app.icon.asImageBitmap(),
                contentScale = ContentScale.Fit,
                contentDescription = "App Icon"
            )
            Spacer(modifier = Modifier.padding(1.dp))
            Text(
                text = app.label,
                fontSize = MaterialTheme.typography.body1.fontSize,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.padding(1.dp))
        }
    }
}