package com.example.cinematickets.composables.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cinematickets.viewmodel.details.DetailsInteractionListener
import com.example.cinematickets.viewmodel.details.DetailsUiState


@Composable
fun DetailsContent(state: DetailsUiState, listener: DetailsInteractionListener) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (header, bottomSheet) = createRefs()
        val guideline = createGuidelineFromTop(0.4f)
        HeaderContent(
            state,
            Modifier.constrainAs(header) { top.linkTo(parent.top) },
            listener = listener
        )
        BottomSheet(
            state, Modifier.constrainAs(bottomSheet) { top.linkTo(guideline) },
            listener = listener
        )
    }
}