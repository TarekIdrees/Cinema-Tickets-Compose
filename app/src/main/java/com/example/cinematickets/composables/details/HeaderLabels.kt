package com.example.cinematickets.composables.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cinematickets.R
import com.example.cinematickets.composables.CustomButton
import com.example.cinematickets.composables.TimeCard
import com.example.cinematickets.ui.theme.Orange
import com.example.cinematickets.viewmodel.details.DetailsInteractionListener
import com.example.cinematickets.viewmodel.details.DetailsUiState

@Composable
fun HeaderContent(state: DetailsUiState, modifier: Modifier = Modifier,listener: DetailsInteractionListener) {
    Box(
        modifier = modifier
            .aspectRatio(8f / 7.5f)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberAsyncImagePainter(model = state.movieImage),
            contentScale = ContentScale.Crop,
            contentDescription = "film logo"
        )
        HeaderLabels(state, listener = listener)
        CustomButton(
            painter = R.drawable.icon_play,
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.Center),
            backgroundColor = Orange,
            listener = listener
        )
    }
}

@Composable
private fun HeaderLabels(state: DetailsUiState,listener: DetailsInteractionListener) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 48.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CustomButton(painter = R.drawable.icon_close, listener = listener)
        TimeCard(painter = R.drawable.icon_clock, time = state.movieTime)
    }
}