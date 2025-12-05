package com.example.pwassignment.data.repository

import com.example.pwassignment.data.dto.StudentDashboard
import com.example.pwassignment.data.remote.QuizzyApi
import com.example.pwassignment.domain.repository.StudentDashboardRepository
import retrofit2.Response
import javax.inject.Inject

class StudentDashboardRepositoryImpl @Inject constructor(
    private val api: QuizzyApi
) : StudentDashboardRepository {
    override suspend fun getDashboardData(token: String): Response<StudentDashboard> {
        return api.getDashboardData(token = token)
    }
}