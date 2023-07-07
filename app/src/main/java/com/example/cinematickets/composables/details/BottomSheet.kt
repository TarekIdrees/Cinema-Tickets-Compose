package com.example.cinematickets.composables.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.R
import com.example.cinematickets.composables.CustomButton
import com.example.cinematickets.composables.MovieType
import com.example.cinematickets.composables.SpacerHorizontal4
import com.example.cinematickets.ui.theme.Orange
import com.example.cinematickets.viewmodel.details.DetailsInteractionListener
import com.example.cinematickets.viewmodel.details.DetailsUiState


@Composable
fun BottomSheet(
    state: DetailsUiState,
    modifier: Modifier = Modifier,
    listener: DetailsInteractionListener
) {
    Box(
        modifier = modifier
            .aspectRatio(4f / 6f)
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(
                Color.White,
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
            )
    ) {
        BottomSheetContain(state,listener)
    }
}

@Composable
private fun BottomSheetContain(state: DetailsUiState, listener: DetailsInteractionListener) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            state.movieRateInformation.forEach {
                MovieInfoText(it.rateValue,it.rateStander, it.rateTitle)
            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = state.movieTitle,
                color = Color.Black,
                fontSize = 30.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 35.sp,
                textAlign = TextAlign.Center,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            state.movieCategories.forEach {
                MovieType(it) {}
                SpacerHorizontal4()
            }
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            state.actorsImages.forEach {
                item {
                    CharacterItem(imageUrl = it)
                }
            }
        }
        Text(
            text = state.movieDescription,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            maxLines = 3,
            color = Color.Black,
            lineHeight = 20.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(32.dp)
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomButton(
                painter = R.drawable.icon_booking,
                backgroundColor = Orange,
                text = "Booking",
                listener = listener
            )
        }

    }
}