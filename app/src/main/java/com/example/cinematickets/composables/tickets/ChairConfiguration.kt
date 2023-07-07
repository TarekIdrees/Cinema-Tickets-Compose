package com.example.cinematickets.composables.tickets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChairConfiguration(
    text: String = "",
    circleTint: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Circle(tint = circleTint, modifier = Modifier.padding(end = 12.dp))
        Text(text = text, fontSize = 12.sp, color = Color.Gray)
    }
}