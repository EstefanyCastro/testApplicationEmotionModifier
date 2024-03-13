package com.example.testapplicationemotionalmodifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.testapplicationemotionalmodifier.navigation.NavManager
import com.example.testapplicationemotionalmodifier.ui.theme.TestApplicationEmotionalModifierTheme
import com.example.testapplicationemotionalmodifier.viewmodels.DALLEOpenAIViewModel
import com.example.testapplicationemotionalmodifier.viewmodels.EmotionModifierAPIViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelAPI: EmotionModifierAPIViewModel by viewModels()
        val viewModelOpenAI: DALLEOpenAIViewModel by viewModels()

        setContent {
            TestApplicationEmotionalModifierTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavManager(viewModelAPI, viewModelOpenAI)
                }
            }
        }
    }
}
