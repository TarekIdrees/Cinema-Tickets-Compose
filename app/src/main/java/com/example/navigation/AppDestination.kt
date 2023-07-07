package com.example.navigation

sealed class Screen(val route: String) {
    object DetailsScreen: Screen("detailsScreen")
    object HomeScreen: Screen("homeScreen")
    object TicketsScreen: Screen("ticketsScreen")
}