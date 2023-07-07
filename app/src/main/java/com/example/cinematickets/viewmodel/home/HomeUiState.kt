package com.example.cinematickets.viewmodel.home

data class HomeUiState(
    val movies: List<Movie> = emptyList(),
    val movieIndex: Int = 0
)

data class Movie(
    val name: String = "",
    val imageUrl: String = "",
)