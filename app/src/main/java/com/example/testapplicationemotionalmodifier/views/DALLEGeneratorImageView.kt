package com.example.testapplicationemotionalmodifier.views

import android.content.Context
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.testapplicationemotionalmodifier.components.ButtonComponent
import com.example.testapplicationemotionalmodifier.viewmodels.DALLEOpenAIViewModel

@Composable
fun DALLEGeneratorImageView(context: Context, viewModelOpenAI: DALLEOpenAIViewModel = viewModel()) {
    var imageURL by remember { mutableStateOf("") }

    ButtonComponent(
        text = "DALLE",
        icon = Icons.Filled.Face,
        description = "Genera imagen nueva"
    ) {
        viewModelOpenAI.generatorImages(context) {
            imageURL = it
        }
    }
    if (imageURL.isNotEmpty()) {
        AsyncImage(
            model = imageURL,
            contentDescription = "Pintar URL en pantalla",
            modifier = Modifier.size(100.dp)
        )
    }
}