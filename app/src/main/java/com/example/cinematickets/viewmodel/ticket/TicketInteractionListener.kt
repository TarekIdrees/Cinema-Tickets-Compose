package com.example.cinematickets.viewmodel.ticket

import com.example.cinematickets.viewmodel.BaseInteractionListener

interface TicketInteractionListener: BaseInteractionListener {
    fun onSelectTimeItem(selectedTime: String)
    fun onSelectDay(selectedDay: DateTime)
    fun onClickExit()
}