package com.example.appgs.model

data class TvDbResults(
    val page: Int,
    val results: List<Tv>,
    val total_pages: Int,
    val total_results: Int
)