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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.viewmodel.ticket.DateTime

@Composable
fun TicketDayCard(
    modifier: Modifier = Modifier,
    dayNumber: String,
    day: String,
    isSelected: Boolean = false,
    backgroundColor: Color = Color.White,
    dayNumberTextColor: Color = Color.Black,
    dayTextColor: Color = Gray,
    onSelectDay: (DateTime) -> Unit
) {
    val background : Color
    val dayNumberColor: Color
    if (isSelected){
        background = Color.DarkGray
        dayNumberColor = Color.White
    } else {
        background =  backgroundColor
        dayNumberColor = dayNumberTextColor
    }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable { onSelectDay(DateTime(dayNumber = dayNumber, day = day)) }
            .background(background)
            .border(0.1.dp, Gray, RoundedCornerShape(20.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = dayNumber,
            color = dayNumberColor,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        Text(
            text = day,
            color = dayTextColor,
            fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
    }
}