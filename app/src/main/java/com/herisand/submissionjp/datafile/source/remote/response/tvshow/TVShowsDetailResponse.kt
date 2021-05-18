package com.herisand.submissionjp.datafile.source.remote.response.tvshow

import com.google.gson.annotations.SerializedName
import com.herisand.submissionjp.datafile.source.remote.response.GenreResponse

data class TVShowsDetailResponse(
    @field:SerializedName("id")
    val id : Int,

    @field:SerializedName("name")
    val title : String,

    @field:SerializedName("overview")
    val description : String,

    @field:SerializedName("poster_path")
    val image : String,

    @field:SerializedName("vote_average")
    val scores : Double,

    @field:SerializedName("first_air_date")
    val date : String,

    @field:SerializedName("backdrop_path")
    val background: String,

    @SerializedName("genres")
    val genres: List<GenreResponse>
)
