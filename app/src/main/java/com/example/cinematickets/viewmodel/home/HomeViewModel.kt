package com.example.cinematickets.viewmodel.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getImages()
    }

    private fun getImages() {
        _state.update {
            it.copy(
                movies = listOf(
                    Movie(
                        "Fantastic Beasts: The Secrets of Dumbledore",
                        "https://images.ctfassets.net/usf1vwtuqyxm/1soIBawzwa52bYit498iYy/8b67c35d5116f96c187e8ba27f4cc264/fb3-poster-jude-law-full.jpg"
                    ),
                    Movie(
                        "The GodFather",
                        "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQ6EAZYpFPv-j-msWE7uFUueby2qiH_lz67ryBOJ41kg4nKHJ6y"
                    ),
                    Movie(
                        "The Dark Knight",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOH1Z3WEv-NS_ahc7NSQRz1LTh813Z6sMmI_E7d1_FYpQd0MxY"
                    ),
                    Movie(
                        "Spider-Man: Across the Spider-Verse",
                        "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQFHMCMi3SM6HVf0M-Ua0zLlXgBvdsyTT8JL47mVS58uxEaEPse"
                    ),
                    Movie(
                        "The Lord Of The Rings: The Fellowship of the Ring",
                        "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcT9J7XACn3tlD6v4UXRMvT2wJN8FGCCPeh8U3RkZ6__tR4wGhSo"
                    )
                )
            )
        }
    }
}