package com.mov.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.mov.moviecatalogue.data.model.TvShowEntity

data class TvShowResponse(
    @SerializedName("results")
    val result: MutableList<TvShowEntity>
)