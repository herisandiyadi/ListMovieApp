package com.herisand.submissionjp.utils.network

import com.herisand.submissionjp.datafile.source.remote.response.movie.MoviesDetailResponse
import com.herisand.submissionjp.datafile.source.remote.response.movie.MoviesResponse
import com.herisand.submissionjp.datafile.source.remote.response.tvshow.TVShowResponse
import com.herisand.submissionjp.datafile.source.remote.response.tvshow.TVShowsDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitEndPoint {

    companion object{
        const val API_KEY = ApiConfig.API_KEY
    }

    @GET("movie/popular?api_key=$API_KEY")
    fun getListMovies(
        @Query("page") page: Int
    ): Call<MoviesResponse>

    @GET("tv/popular?api_key=$API_KEY")
    fun getListTVShows(
        @Query("page") page: Int
    ): Call<TVShowResponse>

    @GET("movie/{movie_id}?api_key=$API_KEY")
    fun getDetailMovies(
        @Path("movie_id") id: String
    ): Call<MoviesDetailResponse>

    @GET("tv/{tv_id}?api_key=$API_KEY")
    fun getDetailTVShows(
        @Path("tv_id") id: String
    ): Call<TVShowsDetailResponse>
}