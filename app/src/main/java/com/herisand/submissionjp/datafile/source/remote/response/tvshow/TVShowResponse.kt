package com.herisand.submissionjp.datafile.source.remote.response.tvshow

import com.google.gson.annotations.SerializedName

data class TVShowResponse(
    @SerializedName("results")
    val result : List<TVShowRemote>
)
