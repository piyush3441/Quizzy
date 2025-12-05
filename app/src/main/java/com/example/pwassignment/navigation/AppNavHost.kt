package com.example.pwassignment.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.pwassignment.features.home.viewmodel.HomeViewmodel

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        authNavGraph(
            navController = navController
        )
        appNavGraph(
            navController = navController,

            )
    }
}