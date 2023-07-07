package com.example.cinematickets.composables.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.R
import com.example.cinematickets.composables.MovieType
import com.example.cinematickets.composables.SpaceVertical8
import com.example.cinematickets.composables.SpacerHorizontal4
import com.example.cinematickets.composables.TimeCard
import com.example.cinematickets.viewmodel.home.HomeUiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieInfo(
    state: HomeUiState,
    pagerState: PagerState
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues(vertical = 16.dp, horizontal = 32.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimeCard(
            painter = R.drawable.icon_clock,
            time = stringResource(R.string.film_time),
            backgroundColor = Color.Transparent,
            textColor = Color.Black,
            iconColor = Color.Gray,
            textSize = 14.sp
        )
        SpaceVertical8()
        Text(
            text = state.movies[pagerState.currentPage].name,
            color = Color.Black,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 30.sp,
            lineHeight = 35.sp,
            textAlign = TextAlign.Center,
        )
        SpaceVertical8()
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            MovieType("Fantasy") {}
            SpacerHorizontal4()
            MovieType("Adventure") {}
        }
    }

}