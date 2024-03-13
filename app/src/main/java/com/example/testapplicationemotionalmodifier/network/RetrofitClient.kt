package com.example.testapplicationemotionalmodifier.network

import com.example.testapplicationemotionalmodifier.utils.EmotionModifierAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val retrofit: EndpointsEmotionModifierAPI by lazy {
        Retrofit
            .Builder()
            .baseUrl(EmotionModifierAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EndpointsEmotionModifierAPI::class.java)
    }
}