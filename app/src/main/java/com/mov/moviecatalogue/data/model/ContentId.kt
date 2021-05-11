package com.mov.moviecatalogue.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class ContentId(
    @SerializedName("id")
    val id: Int,
) : Parcelable