package com.example.appgs.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDBService {

    @GET("movie/popular")
    suspend fun listPopularMovies(@Query("api_key") apiKey : String) : MovieDbResults

    @GET("tv/popular")
    suspend fun listPopularTV(@Query("api_key") apiKey : String) : TvDbResults
}