package com.example.cinematickets.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cinematickets.R
import com.example.cinematickets.composables.SpaceVertical16
import com.example.cinematickets.composables.home.BackgroundContent
import com.example.cinematickets.composables.home.CustomNavButton
import com.example.cinematickets.composables.home.FilmChips
import com.example.cinematickets.composables.home.MovieInfo
import com.example.cinematickets.composables.home.PhotoPager
import com.example.cinematickets.screen.details.navigateToDetails
import com.example.cinematickets.screen.ticket.navigateToTickets
import com.example.cinematickets.ui.theme.Orange
import com.example.cinematickets.viewmodel.home.HomeInteractionListener
import com.example.cinematickets.viewmodel.home.HomeViewModel
import com.example.cinematickets.viewmodel.home.HomeUiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState()

    HomeContent(
        state,
        pagerState,
        listener = object : HomeInteractionListener {
            override fun onClickImage(movieId: String) {
                navController.navigateToDetails(movieId)
            }

            override fun onClickTicket(movieId: String) {
                navController.navigateToTickets(pagerState.currentPage.toString())
            }

            override fun onClick(movieId: String) {
                //
            }

        }
    )
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    state: HomeUiState,
    pagerState: PagerState,
    listener: HomeInteractionListener
) {

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundContent(state, pagerState)
        Column {
            FilmChips()
            SpaceVertical16()
            PhotoPager(state, pagerState, listener)
            MovieInfo(state, pagerState)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            CustomNavButton(
                painter = R.drawable.icon_video,
                pagerState = pagerState.currentPage.toString(),
                modifier = Modifier
                    .size(48.dp),
                backgroundColor = Orange,
                listener = listener
            )
            CustomNavButton(
                painter = R.drawable.icon_search,
                iconTint = Color.Gray,
                pagerState = pagerState.currentPage.toString(),
                modifier = Modifier
                    .size(48.dp),
                backgroundColor = Color.Transparent,
                listener = listener
            )
            CustomNavButton(
                painter = R.drawable.icon_ticket,
                pagerState = pagerState.currentPage.toString(),
                iconTint = Color.Gray,
                modifier = Modifier
                    .size(48.dp),
                backgroundColor = Color.Transparent,
                listener = listener
            )
            CustomNavButton(
                painter = R.drawable.icon_profile,
                pagerState = pagerState.currentPage.toString(),
                iconTint = Color.Gray,
                modifier = Modifier
                    .size(48.dp),
                backgroundColor = Color.Transparent,
                listener = listener
            )
        }
    }
}



