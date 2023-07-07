package com.example.cinematickets.screen.details

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navigation.Screen

private val ROUTE = Screen.DetailsScreen.route
fun NavController.navigateToDetails(movieId: String) {
    navigate("$ROUTE/$movieId")
}

fun NavGraphBuilder.detailsRoute(navController: NavController) {
    composable(
        "$ROUTE/{${DetailsArgs.MOVIE_ID_ARG}}",
        arguments = listOf(
            navArgument(DetailsArgs.MOVIE_ID_ARG) { NavType.StringType },
        )
    ) { DetailsScreen(navController = navController) }
}

class DetailsArgs(savedStateHandle: SavedStateHandle) {
    val movieId: String? = savedStateHandle[MOVIE_ID_ARG]

    companion object {
        const val MOVIE_ID_ARG = "movieId"
    }
}