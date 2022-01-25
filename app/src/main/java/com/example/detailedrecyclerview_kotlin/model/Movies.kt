package com.example.detailedrecyclerview_kotlin.model

import java.io.Serializable

data class Movies(
    var movieId: Int,
    var movieName: String,
    var movieImage: String,
    var movieYear: Int,
    var moviePrice: Double,
    var movieDirector: String
) : Serializable