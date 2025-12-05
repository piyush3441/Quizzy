package com.example.pwassignment.data.dto

import com.google.gson.annotations.SerializedName

data class StudentDashboard(
    @SerializedName("student") var student: Student? = Student(),
    @SerializedName("todaySummary") var todaySummary: TodaySummary? = TodaySummary(),
    @SerializedName("weeklyOverview") var weeklyOverview: WeeklyOverview? = WeeklyOverview()
)
