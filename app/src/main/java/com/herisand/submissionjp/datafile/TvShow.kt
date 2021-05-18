package com.herisand.submissionjp.datafile

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow(
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
    val vote: Float,

    @SerializedName("first_air_date")
    val firstAirDate: String
):Parcelable
