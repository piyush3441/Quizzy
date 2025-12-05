package com.example.pwassignment.data.dto

import com.google.gson.annotations.SerializedName

data class Student(
    @SerializedName("name") var name: String? = null,
    @SerializedName("class") var standard: String? = null,
    @SerializedName("availability") var availability: Availability? = Availability(),
    @SerializedName("quiz") var quiz: Quiz? = Quiz(),
    @SerializedName("accuracy") var accuracy: Accuracy? = Accuracy()
)
