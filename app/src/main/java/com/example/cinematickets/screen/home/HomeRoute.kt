package com.example.cinematickets.screen.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.Screen

private val ROUTE = Screen.HomeScreen.route
fun NavController.navigateToHome() {
    navigate(ROUTE)
}

fun NavGraphBuilder.homeRoute(navController: NavController) {
    composable(ROUTE) { HomeScreen(navController = navController) }
}