package com.example.testapplicationemotionalmodifier.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapplicationemotionalmodifier.models.EmotionRequest
import com.example.testapplicationemotionalmodifier.network.EndpointsEmotionModifierAPI
import com.example.testapplicationemotionalmodifier.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EmotionModifierAPIViewModel : ViewModel() {
    private val apiService: EndpointsEmotionModifierAPI = RetrofitClient.retrofit
    private val _emotions = MutableStateFlow<List<Int>>(emptyList())
    val emotions = _emotions.asStateFlow()

    fun sendEmotion(emotionalEntity: List<Int>, happinessAmount: Int) {
        viewModelScope.launch {
            try {
                val response =
                    apiService.postEmotion(EmotionRequest(emotionalEntity, happinessAmount))
                if (response.statusCode == 200) {
                    val result = response.body
                    _emotions.value = result
                } else {
                }
            } catch (e: Exception) {
            }
        }
    }
}
