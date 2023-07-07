package com.example.cinematickets.composables.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun CharacterItem(imageUrl: String) {
    Image(
        painter = rememberAsyncImagePainter(model = imageUrl),
        contentScale = ContentScale.Crop,
        contentDescription = "character image",
        modifier = Modifier
            .size(72.dp)
            .clip(CircleShape)
    )
}