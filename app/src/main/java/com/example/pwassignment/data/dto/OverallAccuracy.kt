package com.example.pwassignment.data.dto

import com.google.gson.annotations.SerializedName

data class OverallAccuracy(
    @SerializedName("percentage") var percentage: Int? = null,
    @SerializedName("label") var label: String? = null
)