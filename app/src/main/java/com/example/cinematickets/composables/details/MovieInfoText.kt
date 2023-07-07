package com.example.cinematickets.composables.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun MovieInfoText(rate: String, standerRate: String, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            Text(
                text = rate,
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = standerRate,
                fontSize = 16.sp,
                color = Color.Black,
            )
        }
        Text(
            text = title,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}