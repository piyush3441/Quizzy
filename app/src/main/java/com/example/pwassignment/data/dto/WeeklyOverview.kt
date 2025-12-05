package com.example.pwassignment.data.dto

import com.google.gson.annotations.SerializedName

data class WeeklyOverview (
    @SerializedName("quizStreak"         ) var quizStreak         : ArrayList<QuizStreak>         = arrayListOf(),
    @SerializedName("overallAccuracy"    ) var overallAccuracy    : OverallAccuracy?              = OverallAccuracy(),
    @SerializedName("performanceByTopic" ) var performanceByTopic : ArrayList<PerformanceByTopic> = arrayListOf()

)