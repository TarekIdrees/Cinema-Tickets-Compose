package com.example.cinematickets.composables.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cinematickets.viewmodel.home.HomeUiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BackgroundContent(
    state: HomeUiState,
    pagerState: PagerState
) {
    var sizeImage by remember { mutableStateOf(IntSize.Zero) }
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.White),
        startY = sizeImage.height.toFloat() / 3,
        endY = sizeImage.height.toFloat()
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = rememberAsyncImagePainter(
                model = state.movies[pagerState.currentPage].imageUrl
            ),
            modifier = Modifier
                .fillMaxWidth()
                .blur(25.dp)
                .onGloballyPositioned {
                    sizeImage = it.size
                },
            contentDescription = "film logo",
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(gradient)
        )
    }

}