package com.example.cinematickets.viewmodel.ticket

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.cinematickets.composables.tickets.ChairState
import com.example.cinematickets.data.FakeData
import com.example.cinematickets.screen.ticket.TicketsArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TicketViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _state = MutableStateFlow(TicketUiState())
    val state = _state.asStateFlow()

    private val args = TicketsArgs(savedStateHandle)

    init {
        getMovieImage()
        getColumnChairsNumber()
        getAvailableDays()
        getAvailableTime()
    }

    private fun getMovieImage() {
        _state.update {
            it.copy(
                movieImage = FakeData.Movies[args.movieId!!.toInt()].imageUrl
            )
        }
    }

    private fun getColumnChairsNumber() {
        _state.update {
            it.copy(
                columnChairsNumber = listOf(
                    Pair(ChairState.Available, ChairState.Available),
                    Pair(ChairState.Available, ChairState.Available),
                    Pair(ChairState.Available, ChairState.Available),
                    Pair(ChairState.Available, ChairState.Available),
                    Pair(ChairState.Available, ChairState.Available),
                )
            )
        }
    }

    fun onSelectTime(selectedTime: String) {
        _state.update {
            it.copy(
                selectedTime = selectedTime
            )
        }
    }

    fun onSelectDay(selectedDay: DateTime) {
        _state.update {
            it.copy(
                selectedDay = selectedDay
            )
        }
    }

    private fun getAvailableDays() {
        _state.update {
            it.copy(
                availableDays = listOf(
                    DateTime(
                        "14",
                        "Thu"
                    ),
                    DateTime(
                        "15",
                        "Fri"
                    ),
                    DateTime(
                        "16",
                        "Sat"
                    ),
                    DateTime(
                        "17",
                        "Sun"
                    ),
                    DateTime(
                        "18",
                        "Mon"
                    ),
                    DateTime(
                        "19",
                        "Tue"
                    ),
                    DateTime(
                        "20",
                        "Wed"
                    ),
                    DateTime(
                        "21",
                        "Thu"
                    )
                )
            )
        }
    }

    private fun getAvailableTime() {
        _state.update {
            it.copy(
                availableTimes = listOf(
                    "10:00",
                    "12:30",
                    "15:30",
                    "18:30",
                    "21:30",
                    "22:00",
                )
            )
        }
    }
}