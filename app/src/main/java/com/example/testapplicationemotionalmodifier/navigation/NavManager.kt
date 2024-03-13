package com.example.testapplicationemotionalmodifier.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testapplicationemotionalmodifier.viewmodels.DALLEOpenAIViewModel
import com.example.testapplicationemotionalmodifier.viewmodels.EmotionModifierAPIViewModel
import com.example.testapplicationemotionalmodifier.views.HomeView

@Composable
fun NavManager(
    viewModelAPI: EmotionModifierAPIViewModel,
    viewModelOpenAI: DALLEOpenAIViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeView(navController, viewModelAPI, viewModelOpenAI)
        }
    }
}