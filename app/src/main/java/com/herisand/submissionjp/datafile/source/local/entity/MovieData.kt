package com.herisand.submissionjp.datafile.source.local.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val image: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("vote_average")
    val scores: Double,
    @SerializedName("release_date")
    val date: String,
    @SerializedName("backdrop_path")
    val background: String
):Parcelable


