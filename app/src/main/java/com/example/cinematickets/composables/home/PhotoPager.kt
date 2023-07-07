package com.example.cinematickets.composables.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cinematickets.viewmodel.home.HomeInteractionListener
import com.example.cinematickets.viewmodel.home.HomeUiState
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PhotoPager(
    state: HomeUiState,
    pagerState: PagerState,
    listener: HomeInteractionListener,
) {
    HorizontalPager(
        pageCount = state.movies.size,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 32.dp),
        beyondBoundsPageCount = 2,
        pageSpacing = 16.dp
    ) { pageIndex ->

        Card(
            modifier = Modifier
                .aspectRatio(4f / 5f)
                .clip(RoundedCornerShape(24.dp))
                .clickable {
                    listener.onClickImage(pageIndex.toString())
                }
                .graphicsLayer {
                    val pageOffset =
                        ((pagerState.currentPage - pageIndex) + pagerState.currentPageOffsetFraction).absoluteValue
                    lerp(
                        start = 0.7f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                    scaleY = lerp(
                        start = 0.8f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                },
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(state.movies[pageIndex].imageUrl)
                    .build(),
                contentDescription = "film logo",
                contentScale = ContentScale.Crop,
            )
        }

    }
}