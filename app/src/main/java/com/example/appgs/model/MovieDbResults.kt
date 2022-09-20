package com.example.appgs.model

data class MovieDbResults(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)