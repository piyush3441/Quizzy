package com.example.pwassignment.data.dto

import com.google.gson.annotations.SerializedName

data class RecommendedVideo(
    @SerializedName("title") var title: String? = null,
    @SerializedName("actionText") var actionText: String? = null
)
