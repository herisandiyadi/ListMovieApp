package com.herisand.submissionjp.datafile.source.remote.source

import android.util.Log
import com.herisand.submissionjp.datafile.source.remote.response.movie.MovieRemote
import com.herisand.submissionjp.datafile.source.remote.response.movie.MoviesDetailResponse
import com.herisand.submissionjp.datafile.source.remote.response.movie.MoviesResponse
import com.herisand.submissionjp.datafile.source.remote.response.tvshow.TVShowRemote
import com.herisand.submissionjp.datafile.source.remote.response.tvshow.TVShowResponse
import com.herisand.submissionjp.datafile.source.remote.response.tvshow.TVShowsDetailResponse
import com.herisand.submissionjp.utils.EspressoIdlingResource
import com.herisand.submissionjp.utils.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object{
        const val TAG = "Remote Data Source"

        @Volatile
        private var instance : RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {
            RemoteDataSource().apply { instance = this }
        }

    }

    fun getListMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        RetrofitClient.getRetrofitService().getListMovies(1)
            .enqueue(object : Callback<MoviesResponse> {
                override fun onResponse(
                    call: Call<MoviesResponse>,
                    response: Response<MoviesResponse>
                ) {
                    callback.onAllMoviesReceived(response.body()?.result)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    Log.e(TAG, "Failure ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
    }

    fun getDetailMovies(callback: LoadDetailMoviesCallback, id: String) {
        EspressoIdlingResource.increment()
        RetrofitClient.getRetrofitService().getDetailMovies(id)
            .enqueue(object : Callback<MoviesDetailResponse>{
                override fun onResponse(
                    call: Call<MoviesDetailResponse>,
                    response: Response<MoviesDetailResponse>
                ) {
                    callback.onAllDetailMoviesReceived(response.body())
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MoviesDetailResponse>, t: Throwable) {
                    Log.e(TAG, "getDetailMovies on Failure : ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
    }

    fun getListTVShows(callback: LoadTVShowsCallback) {
        EspressoIdlingResource.increment()
        RetrofitClient.getRetrofitService().getListTVShows(1)
            .enqueue(object : Callback<TVShowResponse>{
                override fun onResponse(
                    call: Call<TVShowResponse>,
                    response: Response<TVShowResponse>
                ) {
                    callback.onAllTVShowReceived(response.body()?.result)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TVShowResponse>, t: Throwable) {
                    Log.e(TAG, "Failure ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
    }

    fun getDetailTVShows(callback: LoadDetailTVShowsCallback, id: String){
        EspressoIdlingResource.increment()
        RetrofitClient.getRetrofitService().getDetailTVShows(id)
            .enqueue(object : Callback<TVShowsDetailResponse>{
                override fun onResponse(
                    call: Call<TVShowsDetailResponse>,
                    response: Response<TVShowsDetailResponse>
                ) {
                    callback.onAllDetailTVShowsReceived(response.body())
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TVShowsDetailResponse>, t: Throwable) {
                    Log.e(TAG, "getDetailsTVShows onFailure : ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
    }

    interface LoadMoviesCallback{
        fun onAllMoviesReceived(moviesResponse: List<MovieRemote>?)
    }

    interface LoadTVShowsCallback{
        fun onAllTVShowReceived(tvShowResponse: List<TVShowRemote>?)
    }

    interface LoadDetailMoviesCallback {
        fun onAllDetailMoviesReceived(moviesDetail: MoviesDetailResponse?)
    }

    interface LoadDetailTVShowsCallback {
        fun onAllDetailTVShowsReceived(tvShowDetail: TVShowsDetailResponse?)
    }
}