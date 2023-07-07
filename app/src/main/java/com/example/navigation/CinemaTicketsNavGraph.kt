package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.example.cinematickets.screen.details.detailsRoute
import com.example.cinematickets.screen.home.homeRoute
import com.example.cinematickets.screen.ticket.ticketsRoute

@Composable
fun CinemaTicketsNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        homeRoute(navController)
        detailsRoute(navController)
        ticketsRoute(navController)
    }
}