package com.example.pwassignment.data.dto

import com.google.gson.annotations.SerializedName

data class Availability(
    @SerializedName("status") var status: String? = null
)
