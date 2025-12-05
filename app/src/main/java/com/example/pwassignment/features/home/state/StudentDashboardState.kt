package com.example.pwassignment.features.home.state

import com.example.pwassignment.data.dto.StudentDashboard

data class StudentDashboardState(
    val isLoading: Boolean = false,
    val studentDashboard: StudentDashboard? = null,
    val error: String = ""
)