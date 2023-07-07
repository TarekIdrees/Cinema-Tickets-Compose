package com.example.cinematickets.composables.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.composables.MovieType
import com.example.cinematickets.composables.SpacerHorizontal4
import com.example.cinematickets.ui.theme.BorderColor
import com.example.cinematickets.ui.theme.Orange

@Composable
fun FilmChips() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 48.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        MovieType(
            text = "Now Showing",
            backgroundColor = Orange,
            textColor = Color.White,
            borderColor = BorderColor,
            fontWeight = FontWeight.Normal,
            borderWidth = 0.dp,
            fontSize = 16.sp,
        ) {}
        SpacerHorizontal4()
        MovieType(
            text = "Coming Soon",
            backgroundColor = Color.Transparent,
            textColor = Color.White,
            borderColor = BorderColor,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        ) {}
    }
}