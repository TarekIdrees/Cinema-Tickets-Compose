package com.example.cinematickets.composables.tickets

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.cinematickets.R
import com.example.cinematickets.ui.theme.DarkGray
import com.example.cinematickets.ui.theme.PrimaryLight
import com.example.cinematickets.ui.theme.White87

@Composable
fun ChairItem(
    chairState: ChairState,
    modifier: Modifier = Modifier,
    ocClickChair: (ChairState) -> Unit,
) {
    val tintColor = when (chairState) {
        ChairState.Available -> White87
        ChairState.Taken -> DarkGray
        ChairState.Selected -> PrimaryLight
    }

    val animatedTintColor by animateColorAsState(
        targetValue = tintColor,
        animationSpec = tween(200, easing = FastOutSlowInEasing)
    )

    Crossfade(
        targetState = chairState,
        animationSpec = tween(200, easing = FastOutSlowInEasing),
    ) { state ->
        IconButton(
            onClick = { ocClickChair(state) },
            modifier = modifier,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_seat),
                contentDescription = null,
                tint = animatedTintColor,
                modifier = modifier,
            )
        }
    }
}