package com.example.cinematickets.viewmodel.ticket

import com.example.cinematickets.composables.tickets.ChairState

data class TicketUiState(
    val movieImage: String = "",
    val ticketsNumber: Int = 0,
    val availableDays: List<DateTime> = emptyList(),
    val availableTimes: List<String> = emptyList(),
    val selectedTime: String = "",
    val selectedDay: DateTime = DateTime("", ""),
    val totalPrice: String = "$100.00",
    val totalTickets: String = "4 tickets",
    val columnChairsNumber: List<Pair<ChairState, ChairState>> = emptyList()
)

data class DateTime(
    val dayNumber: String = "",
    val day: String = ""
)