package com.example.cinematickets.viewmodel.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.cinematickets.data.FakeData
import com.example.cinematickets.screen.details.DetailsArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(DetailsUiState())
    val state = _state.asStateFlow()

    private val args = DetailsArgs(savedStateHandle)

    init {
        getMovieImage()
        getMovieTitle()
        getMovieTime()
        getMovieRateInformation()
        getMovieCategories()
        getMovieDescription()
        getActorsImages()
    }

    private fun getMovieImage() {
        _state.update {
            it.copy(
                movieImage = FakeData.Movies[args.movieId!!.toInt()].imageUrl
            )

        }
    }

    private fun getMovieTitle() {
        _state.update {
            it.copy(
                movieTitle = FakeData.Movies[args.movieId!!.toInt()].name
            )
        }
    }

    private fun getMovieTime() {
        _state.update {
            it.copy(
                movieTime = "2h 23m"
            )
        }
    }

    private fun getMovieRateInformation() {
        _state.update {
            it.copy(
                movieRateInformation = listOf(
                    MovieRateInformation(
                        rateTitle = "IMDb",
                        rateValue = "6.8",
                        rateStander = "/10"
                    ),
                    MovieRateInformation(
                        rateTitle = "Rotten Tomatoes",
                        rateValue = "63",
                        rateStander = "%"
                    ),
                    MovieRateInformation(
                        rateTitle = "IGN",
                        rateValue = "4",
                        rateStander = "/10"
                    ),
                )
            )
        }
    }

    private fun getMovieCategories() {
        _state.update {
            it.copy(
                movieCategories = listOf(
                    "Fantasy",
                    "Adventure"
                )
            )
        }
    }

    private fun getMovieDescription() {
        _state.update {
            it.copy(
                movieDescription = "Professor Albus Dumbledore knows the powerful, dark wizard Gellert Gindelwald is moving to seize control of the wizarding world. Unable to stop him from controlling the world"
            )
        }
    }

    private fun getActorsImages() {
        _state.update {
            it.copy(
                actorsImages = listOf(
                    "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcSTqcPNmQAwO1FHeiDf1ammRiuUbRyrvo6j4lPpdKd4iMhsj8-6cIYHyCfN3GUwm5t726Z1-vo2jk7JFeI",
                    "https://m.media-amazon.com/images/M/MV5BMTQ0Mjc3NDA1OV5BMl5BanBnXkFtZTcwMTg3MDEyOA@@._V1_.jpg",
                    "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcRioKqtF-c-YBQwqK8tG7srXfphPn3r1uAmg4xooUO0LF5_WhV6CEGyTqBwyn-3ceHTahDUXbYtog2LUuk",
                    "https://qph.cf2.quoracdn.net/main-qimg-2b7cb3c08cf73719a430d83beed805cf-lq",
                    "https://static.wikia.nocookie.net/themorningshow/images/b/b3/NestorCarbonell.jpg/revision/latest?cb=20190823073203",
                    "https://static.wikia.nocookie.net/batman/images/d/d4/AaronEckhart.jpg/revision/latest/thumbnail/width/360/height/450?cb=20101202222302"
                )
            )
        }
    }

}