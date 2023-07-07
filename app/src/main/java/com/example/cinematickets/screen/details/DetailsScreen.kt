package com.example.cinematickets.screen.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cinematickets.composables.details.DetailsContent
import com.example.cinematickets.viewmodel.details.DetailsInteractionListener
import com.example.cinematickets.viewmodel.details.DetailsViewModel

@Composable
fun DetailsScreen(
    navController: NavController,
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    DetailsContent(
        state = state,
        listener = object : DetailsInteractionListener {
            override fun onClick(movieId: String) {
                navController.popBackStack()
            }

        })
}



