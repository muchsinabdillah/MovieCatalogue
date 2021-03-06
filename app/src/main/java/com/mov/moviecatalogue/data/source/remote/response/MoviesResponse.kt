package com.mov.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.mov.moviecatalogue.data.model.MovieEntity

data class MoviesResponse (
    @SerializedName("results")
    val result:MutableList<MovieEntity>
)