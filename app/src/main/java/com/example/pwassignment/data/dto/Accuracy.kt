package com.example.pwassignment.data.dto

import com.google.gson.annotations.SerializedName

data class Accuracy(
    @SerializedName("current") var current: String? = null
)