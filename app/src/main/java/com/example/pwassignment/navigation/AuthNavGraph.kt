package com.example.pwassignment.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.pwassignment.Graph
import com.example.pwassignment.Screen
import com.example.pwassignment.features.auth_feature.screen.LoginScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavController,
) {
    navigation(
        startDestination = Screen.LoginScreen.route,
        route = Graph.AuthGraph.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            Scaffold { innerPadding ->
                LoginScreen(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}