package com.mov.moviecatalogue.data.model

import com.google.gson.annotations.SerializedName

data class TvShowEntity (
        @SerializedName("id")
        val id: Int,

        @SerializedName("original_name")
        val title: String,

        @SerializedName("overview")
        val description: String,

        @SerializedName("poster_path")
        val poster: String,

        @SerializedName("backdrop_path")
        val backdrop: String,

        @SerializedName("vote_average")
        val rating: Float,

        @SerializedName("first_air_date")
        val firstAirDate: String
)