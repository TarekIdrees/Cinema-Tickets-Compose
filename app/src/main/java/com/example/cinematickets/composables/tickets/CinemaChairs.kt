package com.example.cinematickets.composables.tickets


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematickets.viewmodel.ticket.TicketUiState


@Composable
fun CinemaChairs(state: TicketUiState) {
    Row(
        modifier = Modifier.fillMaxWidth().
        padding(start = 28.dp, end = 28.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy((-60).dp),
        ) {
            state.columnChairsNumber.forEach {
                PairChairs(
                    pair = it,
                    modifier = Modifier.graphicsLayer {
                        val rotateDegree = 10f
                        rotationZ = rotateDegree
                    }
                )
            }
        }
        Column(
            modifier = Modifier.padding(top = 10.dp),
            verticalArrangement = Arrangement.spacedBy((-60).dp)
        ) {
            state.columnChairsNumber.forEach {
                PairChairs(
                    pair = it,
                    modifier = Modifier.graphicsLayer {
                        val rotateDegree = 0f
                        rotationZ = rotateDegree
                    }
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy((-60).dp),
        ) {
            state.columnChairsNumber.forEach {
                PairChairs(
                    pair = it,
                    modifier = Modifier.graphicsLayer {
                        val rotateDegree = -10f
                        rotationZ = rotateDegree
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewChairs(){
    CinemaChairs(state = TicketUiState())
}