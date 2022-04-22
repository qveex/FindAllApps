package com.example.hdhg.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hdhg.nav.Screen
import com.example.hdhg.ui.widgets.AppItem
import com.example.hdhg.viewModel.MainViewModel
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun AppListScreen(viewModel: MainViewModel, navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val listState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()
        val showButton = listState.firstVisibleItemIndex > 4
        val apps = viewModel.appsList

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
            items(
                count = apps.size,
                key = { apps[it].id },
                itemContent = { index ->

                    if (index % 2 == 0 && index != apps.lastIndex) {
                        Row(
                            Modifier.animateItemPlacement(
                                animationSpec = tween(600)
                            )
                        ) {
                            AppItem(app = apps[index]) {
                                navController.navigate(Screen.App.passId(apps[index].id))
                            }
                            Spacer(modifier = Modifier.padding(12.dp))
                            AppItem(app = apps[index + 1]) {
                                navController.navigate(Screen.App.passId(apps[index + 1].id))
                            }
                        }
                    } else if (index == apps.lastIndex && apps.size % 2 != 0) {
                        AppItem(app = apps[index]) {
                            navController.navigate(Screen.App.passId(apps[index].id))
                        }
                    }

                }
            )
        }

        Box(modifier = Modifier.fillMaxSize()) {
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