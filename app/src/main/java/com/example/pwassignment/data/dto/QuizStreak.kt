package com.example.pwassignment.data.dto

import com.google.gson.annotations.SerializedName

data class QuizStreak(
    @SerializedName("day") var day: String? = null,
    @SerializedName("status") var status: String? = null
)
