package com.example.cinematickets.viewmodel.details

data class DetailsUiState(
    val movieImage: String = "",
    val movieTime: String = "",
    val movieRateInformation: List<MovieRateInformation> = emptyList(),
    val movieTitle: String = "",
    val movieCategories: List<String> = emptyList(),
    val actorsImages: List<String> = emptyList(),
    val movieDescription: String = ""
)

data class MovieRateInformation(
    val rateValue: String,
    val rateStander: String,
    val rateTitle: String,
)
