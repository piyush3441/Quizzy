package com.example.pwassignment.navigation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.stylusHoverIcon
import androidx.compose.ui.res.painterResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.pwassignment.Graph
import com.example.pwassignment.R
import com.example.pwassignment.Screen
import com.example.pwassignment.Screen.NotificationScreen
import com.example.pwassignment.features.home.viewmodel.HomeViewmodel
import com.example.pwassignment.features.home.screen.HomeScreen
import com.example.pwassignment.features.home.screen.NotificationAndSettingsScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.appNavGraph(
    navController: NavController,
) {
    navigation(
        startDestination = Screen.HomeScreen.route,
        route = Graph.AppGraph.route
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.NotificationScreen.route
        ) {
            Scaffold(
                topBar = {

                    CenterAlignedTopAppBar(
                        title = {
                            Text(
                                text = "Notifications & Settings"
                            )
                        },
                        navigationIcon = {
                            IconButton(
                                onClick = {
                                    navController.popBackStack()
                                }
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.back_btn_icon),
                                    contentDescription = null
                                )
                            }
                        }
                    )
                }

            ) { innerPadding ->
                NotificationAndSettingsScreen(
                    modifier = Modifier.padding(innerPadding),
                    onLogout = {
                        navController.navigate(Graph.AuthGraph.route) {
                            popUpTo(Graph.AppGraph.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }

        }
    }
}