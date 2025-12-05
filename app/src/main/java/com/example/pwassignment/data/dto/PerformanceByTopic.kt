package com.example.pwassignment.data.dto

import com.google.gson.annotations.SerializedName

data class PerformanceByTopic (
    @SerializedName("topic" ) var topic : String? = null,
    @SerializedName("trend" ) var trend : String? = null
)
