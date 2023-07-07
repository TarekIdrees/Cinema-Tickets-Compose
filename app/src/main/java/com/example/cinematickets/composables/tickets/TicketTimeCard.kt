package com.example.cinematickets.composables.tickets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TicketTimeCard(
    modifier: Modifier = Modifier,
    time: String,
    isSelected: Boolean = false,
    backgroundColor: Color = Color.White,
    timeColor: Color = Color.Black,
    onSelectTime: (String) -> Unit
) {
    val background : Color
    val dateColor: Color
     if (isSelected){
         background = Color.DarkGray
         dateColor = Color.White
     } else {
         background =  backgroundColor
         dateColor = timeColor
     }
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(background)
            .clickable { onSelectTime(time) }
            .border(0.1.dp, Gray, RoundedCornerShape(20.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = time,
            color = dateColor,
            fontSize = 16.sp,
        )
    }
}