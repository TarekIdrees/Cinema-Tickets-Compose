package com.example.cinematickets.composables.tickets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematickets.ui.theme.Gray
import com.example.cinematickets.ui.theme.Orange
import com.example.cinematickets.viewmodel.ticket.DateTime
import com.example.cinematickets.viewmodel.ticket.TicketInteractionListener
import com.example.cinematickets.viewmodel.ticket.TicketUiState

@Composable
fun BodyContent(
    state: TicketUiState,
    modifier: Modifier = Modifier,
    listener: TicketInteractionListener
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Header(state, modifier, listener)
        CinemaChairs(state = state)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ChairConfiguration(text = "Available", circleTint = Color.White)
            ChairConfiguration(text = "Taken", circleTint = Gray)
            ChairConfiguration(text = "Selected", circleTint = Orange)
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun Preview() {
    BodyContent(state = TicketUiState(), listener = object : TicketInteractionListener {
        override fun onSelectTimeItem(selectedTime: String) {
            TODO("Not yet implemented")
        }

        override fun onSelectDay(selectedDay: DateTime) {
            TODO("Not yet implemented")
        }

        override fun onClickExit() {
            TODO("Not yet implemented")
        }

        override fun onClick(movieId: String) {
            TODO("Not yet implemented")
        }
    })
}