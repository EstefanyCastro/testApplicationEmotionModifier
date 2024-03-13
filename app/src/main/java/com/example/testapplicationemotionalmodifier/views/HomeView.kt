package com.example.testapplicationemotionalmodifier.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.testapplicationemotionalmodifier.components.TopBarComponent
import com.example.testapplicationemotionalmodifier.viewmodels.DALLEOpenAIViewModel
import com.example.testapplicationemotionalmodifier.viewmodels.EmotionModifierAPIViewModel

@Composable
fun HomeView(
    navController: NavController,
    viewModelAPI: EmotionModifierAPIViewModel = viewModel(),
    viewModelOpenAI: DALLEOpenAIViewModel = viewModel()
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopBarComponent(titulo = "My Pet")
        }
    ) { padding ->
        Column(Modifier.padding(padding)) {
            DALLEGeneratorImageView(context, viewModelOpenAI)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeViewPreview() {
    val navController = rememberNavController()
    val viewModelAPI = EmotionModifierAPIViewModel()
    val viewModelOpenAI = DALLEOpenAIViewModel()

    HomeView(
        navController = navController,
        viewModelAPI = viewModelAPI,
        viewModelOpenAI = viewModelOpenAI
    )
}