package com.example.testapplicationemotionalmodifier.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aallam.openai.api.file.FileSource
import com.aallam.openai.api.image.ImageEdit
import com.aallam.openai.api.image.ImageSize
import com.aallam.openai.api.logging.LogLevel
import com.aallam.openai.client.LoggingConfig
import com.aallam.openai.client.OpenAI
import com.example.testapplicationemotionalmodifier.R
import com.example.testapplicationemotionalmodifier.utils.DALLEOpenAI
import kotlinx.coroutines.launch
import okio.source

class DALLEOpenAIViewModel : ViewModel() {
    private var openAI =
        OpenAI(
            token = DALLEOpenAI.OPENAI_API_KEY,
            logging = LoggingConfig(LogLevel.All)
        )

    fun generatorImages(context: Context, imageURL: (String) -> Unit) = viewModelScope.launch {
        val prompt =
            "Genera una imagen de un perro de caricatura con las siguientes emociones en porcentajes: " +
                    "alegria: 10%, " +
                    "tristeza: 50%, " +
                    "miedo: 20%, " +
                    "enojo: 10%, " +
                    "asco: 5%, " +
                    "sorpresa: 5%"

        val images = openAI.imageURL(
            ImageEdit(
                image = FileSource(
                    name = "ic_dog_principal.png",
                    source = context.resources.openRawResource(R.raw.ic_dog_principal).source()
                ),
                mask = FileSource(
                    name = "ic_mask_dog_principal.png",
                    source = context.resources.openRawResource(R.raw.ic_mask_dog_principal).source()
                ),
                prompt = prompt,
                n = 1,
                size = ImageSize.is1024x1024
            )
        )
        println("URL de la imagen: ${images.first().url}")
        imageURL(images.first().url)
    }
}