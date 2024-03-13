package com.example.testapplicationemotionalmodifier.network

import com.example.testapplicationemotionalmodifier.models.EmotionRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface EndpointsEmotionModifierAPI {
    @POST("updateHappiness")
    suspend fun postEmotion(@Body body: EmotionRequest): EmotionModifierResponse
}

data class EmotionModifierResponse(
    val statusCode: Int,
    val body: List<Int>
)