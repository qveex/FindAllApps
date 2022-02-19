package com.example.hdhg.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.graphics.scale
import com.example.hdhg.models.App

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
        contentPadding = PaddingValues(1.dp)
    ) {
        Box(
            modifier = Modifier
                .background(shape = RoundedCornerShape(size = 32.dp), brush = smoothThemeGradient)
                .border(
                    shape = RoundedCornerShape(size = 32.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant)
                )
                .width(LocalConfiguration.current.screenWidthDp.dp / 2 - 24.dp)
                .height(LocalConfiguration.current.screenHeightDp.dp / 4),  //
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    bitmap = app.icon.scale(150, 150).asImageBitmap(),
                    contentDescription = "App Icon"
                )
                Spacer(modifier = Modifier.padding(1.dp))
                Text(
                    text = if (app.label.length > 14) app.label.substring(0, 14) + "..." else app.label,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    overflow = TextOverflow.Clip,
                    maxLines = 1,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.padding(1.dp))
            }
        }
    }
}