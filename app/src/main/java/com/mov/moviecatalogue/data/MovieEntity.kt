package com.mov.moviecatalogue.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity (
    var movieId: String,
    var title: String,
    var genre: String,
    var headline: String,
    var overview: String,
    var imagePath: String
):Parcelable