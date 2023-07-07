package com.example.cinematickets.screen.ticket


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cinematickets.composables.tickets.BodyContent
import com.example.cinematickets.composables.tickets.BottomSheetTickets
import com.example.cinematickets.viewmodel.ticket.DateTime
import com.example.cinematickets.viewmodel.ticket.TicketInteractionListener
import com.example.cinematickets.viewmodel.ticket.TicketViewModel
import com.example.cinematickets.viewmodel.ticket.TicketUiState

@Composable
fun TicketsScreen(
    navController: NavController,
    viewModel: TicketViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    TicketsContent(
        state,
        listener = object : TicketInteractionListener {
            override fun onSelectTimeItem(selectedTime: String) {
                viewModel.onSelectTime(selectedTime)
            }

            override fun onSelectDay(selectedDay: DateTime) {
                viewModel.onSelectDay(selectedDay)
            }

            override fun onClickExit() {
                navController.popBackStack()
            }

            override fun onClick(movieId: String) {
                navController.popBackStack()
            }
        }
    )
}

@Composable
fun TicketsContent(
    state: TicketUiState,
    listener: TicketInteractionListener
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val (body, bottomSheet) = createRefs()
        val guideline = createGuidelineFromTop(0.67f)
        BodyContent(state, Modifier.constrainAs(body) {
            top.linkTo(parent.top)
        }, listener)
        BottomSheetTickets(
            state,
            Modifier.constrainAs(bottomSheet) { top.linkTo(guideline) },
            listener
        )
    }
}







