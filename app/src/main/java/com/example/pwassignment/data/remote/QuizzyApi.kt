package com.example.pwassignment.data.remote

import com.example.pwassignment.data.dto.StudentDashboard
import com.example.pwassignment.utils.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizzyApi {
    @GET(AppConstants.DASHBOARD_DATA)
    suspend fun getDashboardData(
        @Query("alt") alt: String = "media",
        @Query("token") token: String
    ): Response<StudentDashboard>
}