package com.example.cinematickets.viewmodel.home

import com.example.cinematickets.viewmodel.BaseInteractionListener

interface HomeInteractionListener: BaseInteractionListener {
    fun onClickImage(movieId: String)
    fun onClickTicket(movieId: String)
}