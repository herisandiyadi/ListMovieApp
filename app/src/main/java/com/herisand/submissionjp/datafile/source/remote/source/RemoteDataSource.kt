package com.herisand.submissionjp.datafile.source.remote.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.herisand.submissionjp.datafile.source.remote.response.ApiResponse
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

    fun getListMovies(): LiveData<ApiResponse<List<MovieRemote>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<MovieRemote>>>()
        RetrofitClient.getRetrofitService().getListMovies(1)
            .enqueue(object : Callback<MoviesResponse> {
                override fun onResponse(
                    call: Call<MoviesResponse>,
                    response: Response<MoviesResponse>
                ) {
                    result.value = ApiResponse.success(response.body()?.result as List<MovieRemote>)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    Log.e(TAG, "Failure ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
        return result
    }

    fun getDetailMovies(id: String): LiveData<ApiResponse<MoviesDetailResponse>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<MoviesDetailResponse>>()
        RetrofitClient.getRetrofitService().getDetailMovies(id)
            .enqueue(object : Callback<MoviesDetailResponse>{
                override fun onResponse(
                    call: Call<MoviesDetailResponse>,
                    response: Response<MoviesDetailResponse>
                ) {
                    result.value = ApiResponse.success(response.body() as MoviesDetailResponse)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MoviesDetailResponse>, t: Throwable) {
                    Log.e(TAG, "getDetailMovies on Failure : ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
        return result
    }

    fun getListTVShows(): LiveData<ApiResponse<List<TVShowRemote>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<TVShowRemote>>>()
        RetrofitClient.getRetrofitService().getListTVShows(1)
            .enqueue(object : Callback<TVShowResponse>{
                override fun onResponse(
                    call: Call<TVShowResponse>,
                    response: Response<TVShowResponse>
                ) {
                    result.value = ApiResponse.success(response.body()?.result as List<TVShowRemote>)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TVShowResponse>, t: Throwable) {
                    Log.e(TAG, "Failure ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
        return result
    }

    fun getDetailTVShows(id: String): LiveData<ApiResponse<TVShowsDetailResponse>>{
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<TVShowsDetailResponse>>()
        RetrofitClient.getRetrofitService().getDetailTVShows(id)
            .enqueue(object : Callback<TVShowsDetailResponse>{
                override fun onResponse(
                    call: Call<TVShowsDetailResponse>,
                    response: Response<TVShowsDetailResponse>
                ) {
                    result.value = ApiResponse.success(response.body() as TVShowsDetailResponse)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TVShowsDetailResponse>, t: Throwable) {
                    Log.e(TAG, "getDetailsTVShows onFailure : ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
        return result
    }

}