package com.example.pwassignment

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")

    object HomeScreen : Screen("home_screen")
    object NotificationScreen : Screen("notification_settings_screen")

}