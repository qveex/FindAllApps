package com.example.hdhg.ui.widgets


import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainTopBar(
    isDarkTheme: Boolean,
    onThemeSwitch: () -> Unit,
    onScanClicked: () -> Unit,
    onAppsClicked: () -> Unit
) {
    TopAppBar(
        title = { },
        navigationIcon = {
            SwitchTheme(isDarkTheme = isDarkTheme) { onThemeSwitch() }
        },
        actions = {
            AppMenu(
                { onScanClicked() },
                { onAppsClicked() }
            )
        },
        backgroundColor = MaterialTheme.colors.background
    )
}

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun SwitchTheme(
    isDarkTheme: Boolean,
    onThemeSwitch: () -> Unit
) {

    IconToggleButton(
        checked = isDarkTheme,
        onCheckedChange = { onThemeSwitch() },
        modifier = Modifier.size(Icons.Outlined.DarkMode.defaultHeight * 2)
    ) {
        val transition = updateTransition(
            targetState = isDarkTheme,
            label = "theme indicator"
        )
        val tint by transition.animateColor(
            label = "Tint"
        ) { isChecked ->
            if (isChecked) Color.White else Color.Black
        }

        val size by transition.animateDp(
            transitionSpec = {
                keyframes {
                    durationMillis = 150
                    10.dp at 0 with LinearOutSlowInEasing // for 0-15 ms
                    15.dp at 15 with FastOutLinearInEasing // for 15-75 ms
                    20.dp at 75 // ms
                    25.dp at 150 // ms
                }
            },
            label = "Size"
        ) { 25.dp }

        FloatingActionButton(
            onClick = { onThemeSwitch() },
            backgroundColor = MaterialTheme.colors.primaryVariant,
        ) {
            Icon(
                imageVector = if (isDarkTheme) Icons.Outlined.DarkMode else Icons.Outlined.LightMode,
                contentDescription = "Theme Icon",
                tint = tint,
                modifier = Modifier.size(size)
            )
        }

    }
}


@Composable
fun AppMenu(
    onScanClicked: () -> Unit,
    onAppsClicked: () -> Unit
) {

    var expendedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expendedState) 180f else 0f)

    FloatingActionButton(
        onClick = {
            expendedState = !expendedState
        },
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = Modifier
            .size(Icons.Outlined.Menu.defaultHeight * 2)
            .rotate(rotationState)
    ) {
        Icon(
            imageVector = Icons.Outlined.Menu,
            contentDescription = "Theme Icon",
            tint = MaterialTheme.colors.onBackground,
            modifier = Modifier.size(25.dp)
        )
    }
    if (expendedState) {
        DropdownMenu(
            expanded = expendedState,
            onDismissRequest = { expendedState = false },
            modifier = Modifier
                .width(156.dp)
                .background(MaterialTheme.colors.primaryVariant)
        ) {
            MenuItems(onScanClicked, onAppsClicked)
        }
    }
}


@Composable
fun MenuItems(
    onScanClicked: () -> Unit,
    onAppsClicked: () -> Unit
) {
    DropdownMenuItem(onClick = { onScanClicked() }) {
        Icon(
            imageVector = Icons.Outlined.Search,
            contentDescription = "Scan Icon",
            tint = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text("Scan")
    }
    Divider()
    DropdownMenuItem(onClick = { onAppsClicked() }) {
        Icon(
            imageVector = Icons.Outlined.ListAlt,
            contentDescription = "List Icon",
            tint = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text("Apps")
    }
}

@Composable
@Preview
fun MainTopBarPreview() {
    MainTopBar(
        false,
        { },
        { },
        { }
    )
}