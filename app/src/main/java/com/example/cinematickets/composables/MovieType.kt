package com.example.cinematickets.composables


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.ui.theme.BorderColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieType(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    textColor: Color = Color.Black,
    borderColor: Color = BorderColor,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 14.sp,
    borderWidth: Dp = 1.0.dp,
    onClick: () -> Unit
) {
    AssistChip(
        onClick = onClick,
        colors = AssistChipDefaults.assistChipColors(backgroundColor),
        shape = CircleShape,
        border = AssistChipDefaults.assistChipBorder(
            borderColor = borderColor,
            borderWidth = borderWidth
        ),
        label = {
            Text(
                text = text,
                color = textColor,
                fontSize = fontSize,
                fontWeight = fontWeight,
                modifier = modifier.padding(8.dp)
            )
        },
    )
}