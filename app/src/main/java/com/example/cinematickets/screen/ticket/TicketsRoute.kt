package com.example.cinematickets.screen.ticket

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navigation.Screen

private val ROUTE = Screen.TicketsScreen.route
fun NavController.navigateToTickets(movieId: String) {
    navigate("$ROUTE/$movieId")
}

fun NavGraphBuilder.ticketsRoute(navController: NavController) {
    composable(
        "$ROUTE/{${TicketsArgs.MOVIE_ID_ARG}}",
        arguments = listOf(
            navArgument(TicketsArgs.MOVIE_ID_ARG) { NavType.StringType }
        )
    ) { TicketsScreen(navController = navController) }
}

class TicketsArgs(savedStateHandle: SavedStateHandle) {
    val movieId: String? = savedStateHandle[MOVIE_ID_ARG]

    companion object {
        const val MOVIE_ID_ARG = "movieId"
    }
}