package com.herisand.submissionjp.datafile.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("results")
    val result: List<MovieRemote>
)
