package com.example.pwassignment

sealed class Graph(val route: String) {
    object AuthGraph : Graph("auth_graph")
    object AppGraph : Graph("app_graph")
}