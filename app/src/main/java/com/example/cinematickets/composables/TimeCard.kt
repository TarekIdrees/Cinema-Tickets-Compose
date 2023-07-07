package com.example.cinematickets.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.ui.theme.LightGray
import com.example.cinematickets.ui.theme.TextWhite

@Composable
fun TimeCard(
    painter: Int,
    time: String,
    modifier: Modifier = Modifier,
    textColor: Color = TextWhite,
    iconColor: Color = Color.White,
    textSize : TextUnit = 12.sp,
    backgroundColor: Color = LightGray
) {
    Row(
        modifier = modifier
            .clip(CircleShape)
            .background(color = backgroundColor)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = painter),
            contentDescription = "time duration",
            tint = iconColor
        )
        SpacerHorizontal4()
        Text(
            text = time,
            color = textColor,
            fontSize = textSize
        )
    }

}