package com.example.hdhg.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hdhg.R
import com.example.hdhg.nav.Screen
import com.example.hdhg.ui.widgets.GradScanButton
import com.example.hdhg.viewModel.MainViewModel

@Composable
fun ScanScreen(viewModel: MainViewModel, navController: NavController) {

    val context = LocalContext.current

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(24.dp))
            TextWithShadow(
                text = stringResource(id = R.string.app_title),
                modifier = Modifier.rotate(-10f)
            )
            Spacer(modifier = Modifier.padding(12.dp))
            Text(
                text = stringResource(id = R.string.app_description),
                fontSize = MaterialTheme.typography.body2.fontSize,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.rotate(10f)
            )
            Spacer(modifier = Modifier.padding(24.dp))
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                GradScanButton(
                    text = stringResource(id = R.string.scan_button),
                    onClicked = {
                        viewModel.scan(context = context)
                        navController.navigate(route = Screen.AppsList.route)
                    },
                    gradient = Brush.linearGradient(
                        listOf(
                            MaterialTheme.colors.primary,
                            MaterialTheme.colors.secondary
                        )
                    ),
                    textColor = Color.White
                )
            }
            Spacer(modifier = Modifier.padding(12.dp))
        }
    }
}


@Composable
fun TextWithShadow(
    text: String,
    modifier: Modifier
) {
    Box {
        Text(
            text = text,
            fontSize = MaterialTheme.typography.h5.fontSize,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .offset(
                    x = 1.75.dp,
                    y = 3.dp
                )
                .alpha(0.3f)
        )
        Text(
            text = text,
            fontSize = MaterialTheme.typography.h5.fontSize,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
    }

}