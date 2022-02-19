package com.example.hdhg.screens

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hdhg.models.App
import com.example.hdhg.nav.Screen
import com.example.hdhg.viewModel.MainViewModel
import com.example.hdhg.widgets.AppItem
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun AppListScreen(viewModel: MainViewModel, navController: NavController) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxSize()
        ) {
            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()
            val showButton = listState.firstVisibleItemIndex > 4

            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(all = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        text = "SCAN RESULT",
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                }

                val apps = viewModel.appsList.value

                for (i in 0 until apps.size step 2) {
                    item {
                        if (i == apps.indices.last) {
                            AppItem(app = apps[i]) {
                                navController.navigate(Screen.App.passId(i))
                            }
                        } else {
                            Row {
                                AppItem(app = apps[i]) {
                                    navController.navigate(Screen.App.passId(i))
                                }
                                Spacer(modifier = Modifier.padding(12.dp))
                                AppItem(app = apps[i + 1]) {
                                    navController.navigate(Screen.App.passId(i + 1))
                                }
                            }
                        }
                    }
                }
            }

            AnimatedVisibility(
                visible = showButton,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                FloatingActionButton(
                    onClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(index = 0)
                        }
                    },
                    backgroundColor = MaterialTheme.colors.primaryVariant
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowUpward,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }
        }
    }
}