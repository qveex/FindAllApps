package com.example.hdhg.ui.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.hdhg.R
import com.example.hdhg.models.App

@Composable
fun AppInfo(app: App) {

    val smoothThemeGradient = Brush.linearGradient(
        listOf(
            MaterialTheme.colors.primaryVariant,
            MaterialTheme.colors.background
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(size = 32.dp),
                brush = smoothThemeGradient
            )
            .border(
                shape = RoundedCornerShape(size = 32.dp),
                border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant)
            ),
    ) {
        Spacer(modifier = Modifier.padding(20.dp))
        Image(
            bitmap = app.icon.asImageBitmap(),
            contentScale = ContentScale.Crop,
            contentDescription = "App Icon"
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = app.label,
            fontSize = MaterialTheme.typography.h5.fontSize,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.padding(20.dp))


        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            InfoRow(
                label = stringResource(R.string.app_item_size),
                text = app.getSizeInMB().toString() + " MB"
            )
            Divider(thickness = 2.dp, modifier = Modifier.padding(0.dp, 8.dp))
            InfoRow(
                label = stringResource(R.string.app_item_sdk),
                text = app.targetSdk.toString()
            )
            Divider(thickness = 2.dp, modifier = Modifier.padding(0.dp, 8.dp))
            InfoRow(
                label = stringResource(R.string.app_item_date),
                text = app.getInstallDate()
            )
        }

        Spacer(modifier = Modifier.padding(20.dp))
    }
}


@Composable
fun InfoRow(label: String, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = label,
            fontSize = MaterialTheme.typography.body2.fontSize,
            fontWeight = FontWeight.Light,
        )
        Text(
            text = text,
            fontSize = MaterialTheme.typography.body1.fontSize,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
        )
    }
}