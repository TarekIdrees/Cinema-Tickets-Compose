package com.example.cinematickets.composables.tickets

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

@Composable
fun Circle(
    modifier: Modifier = Modifier,
    tint: Color,
    circleSize: Float = 15f
) {
    Canvas(
        modifier = modifier,
        onDraw = {
            val canvasWidth = size.width
            val canvasHeight = size.height

            drawCircle(
                color = tint,
                center = Offset(canvasWidth / 2, canvasHeight / 2),
                radius = circleSize,
            )
        }
    )
}