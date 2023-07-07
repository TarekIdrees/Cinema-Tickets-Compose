package com.example.cinematickets.composables.tickets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.R
import com.example.cinematickets.composables.CustomButton
import com.example.cinematickets.ui.theme.Orange
import com.example.cinematickets.viewmodel.ticket.TicketInteractionListener
import com.example.cinematickets.viewmodel.ticket.TicketUiState


@Composable
fun BottomSheetTickets(
    state: TicketUiState,
    modifier: Modifier = Modifier,
    listener: TicketInteractionListener
) {
    Box(
        modifier = modifier
            .aspectRatio(4f / 6f)
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(
                Color.White,
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
            )
    ) {
        BottomSheetContent(state, listener)
    }
}

@Composable
private fun BottomSheetContent(state: TicketUiState, listener: TicketInteractionListener) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(top = 32.dp, start = 32.dp, end = 32.dp, bottom = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            state.availableDays.forEach {
                item {
                    TicketDayCard(
                        isSelected = it == state.selectedDay,
                        dayNumber = it.dayNumber,
                        day = it.day,
                        onSelectDay = listener::onSelectDay
                    )
                }
            }
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(start = 32.dp, end = 32.dp, bottom = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            state.availableTimes.forEach {
                item {
                    TicketTimeCard(
                        isSelected = it == state.selectedTime,
                        time = it,
                        onSelectTime = listener::onSelectTimeItem
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = state.totalPrice,
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = Color.Black
                )
                Text(
                    text = state.totalTickets,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
            CustomButton(
                painter = R.drawable.icon_booking,
                backgroundColor = Orange,
                text = "Buy tickets",
                iconPadding = 16.dp,
                listener = listener
            )
        }
    }
}