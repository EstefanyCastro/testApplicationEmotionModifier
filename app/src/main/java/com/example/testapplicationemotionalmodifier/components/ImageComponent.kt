package com.example.testapplicationemotionalmodifier.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun ImageComponent(
    imageId: Int,
    contentDescription: String,
    imageSize: Dp,
) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = contentDescription,
        modifier = Modifier.size(imageSize)
    )
}
