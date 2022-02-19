package com.example.hdhg.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun ScanButton(
    onClicked: () -> Unit,
    gradient: Brush
) {
    ExtendedFloatingActionButton(
        modifier = Modifier
            .size(LocalConfiguration.current.screenWidthDp.dp - 64.dp)
            .shadow(24.dp, CircleShape),
        shape = CircleShape,
        text = { Text(text = "SCAN", fontSize = MaterialTheme.typography.h4.fontSize) },
        onClick = { onClicked() },
        icon = { Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search Ic", Modifier.size(MaterialTheme.typography.h4.fontSize.value.dp)) },
        backgroundColor = MaterialTheme.colors.primaryVariant,
    )
}


@Composable
fun GradScanButton(
    text: String,
    onClicked: () -> Unit,
    gradient: Brush,
    textColor: Color
) {

    Button(
        modifier = Modifier.size(LocalConfiguration.current.screenWidthDp.dp - 64.dp),
        onClick = { onClicked() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            modifier = Modifier
                .background(shape = CircleShape, brush = gradient)
                .fillMaxSize()
                .border(border = BorderStroke(4.dp, gradient), shape = CircleShape),  //
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(MaterialTheme.typography.h4.fontSize.value.dp),
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search Ic",
                    tint = textColor
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = text,
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    color = textColor
                )
            }
        }
    }
}