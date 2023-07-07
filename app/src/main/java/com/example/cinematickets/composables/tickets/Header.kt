package com.example.cinematickets.composables.tickets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R
import com.example.cinematickets.composables.CustomButton
import com.example.cinematickets.viewmodel.ticket.TicketInteractionListener
import com.example.cinematickets.viewmodel.ticket.TicketUiState

@Composable
fun Header(state: TicketUiState, modifier: Modifier,listener: TicketInteractionListener) {
    Box() {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 74.dp, start = 16.dp, end = 16.dp),
            painter = painterResource(R.drawable.background),
            contentDescription = "film logo"
        )
        CustomButton(
            modifier = Modifier.padding(top = 28.dp, start = 16.dp),
            painter = R.drawable.icon_close,
            listener = listener
        )
    }
}