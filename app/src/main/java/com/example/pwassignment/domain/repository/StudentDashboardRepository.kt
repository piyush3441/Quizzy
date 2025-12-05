package com.example.pwassignment.domain.repository

import com.example.pwassignment.data.dto.StudentDashboard
import retrofit2.Response

interface StudentDashboardRepository {
    suspend fun getDashboardData(token: String): Response<StudentDashboard>
}
