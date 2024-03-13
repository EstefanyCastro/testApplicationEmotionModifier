package com.example.testapplicationemotionalmodifier.models

import com.google.gson.annotations.SerializedName

data class EmotionRequest(
    @SerializedName("emotional_entity") val emotionalEntity: List<Int>,
    @SerializedName("happiness_amount") val happinessAmount: Int,
)
