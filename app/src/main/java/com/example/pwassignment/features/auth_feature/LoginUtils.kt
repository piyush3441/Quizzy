package com.example.pwassignment.features.auth_feature

object LoginUtils {
    fun validateUsername(username: String): String? {
        return when {
            username.isEmpty() -> "Username is required"
            else -> null
        }
    }

    fun validatePassword(password: String): String? {
        return when {
            password.isEmpty() -> "Password is required"
            else -> null
        }
    }

}