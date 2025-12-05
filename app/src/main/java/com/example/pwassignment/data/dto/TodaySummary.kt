package com.example.pwassignment.data.dto

import com.google.gson.annotations.SerializedName

data class TodaySummary(

    @SerializedName("mood") var mood: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("recommendedVideo") var recommendedVideo: RecommendedVideo? = RecommendedVideo(),
    @SerializedName("characterImage") var characterImage: String? = null

)
