package com.example.pwassignment.features.auth_feature.state

data class AuthState(
    val isLoading: Boolean = true,
    val token: String? = null,
    val error: String = ""
)
