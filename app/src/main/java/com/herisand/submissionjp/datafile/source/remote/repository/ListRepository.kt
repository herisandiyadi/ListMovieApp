package com.herisand.submissionjp.datafile.source.remote.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.herisand.submissionjp.datafile.source.local.entity.DetailData
import com.herisand.submissionjp.datafile.source.local.entity.MovieData
import com.herisand.submissionjp.datafile.source.local.entity.TvData
import com.herisand.submissionjp.datafile.source.remote.response.movie.MovieRemote
import com.herisand.submissionjp.datafile.source.remote.response.movie.MoviesDetailResponse
import com.herisand.submissionjp.datafile.source.remote.response.tvshow.TVShowRemote
import com.herisand.submissionjp.datafile.source.remote.response.tvshow.TVShowsDetailResponse
import com.herisand.submissionjp.datafile.source.remote.source.ListDataSource
import com.herisand.submissionjp.datafile.source.remote.source.RemoteDataSource

class ListRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    ListDataSource{

    companion object{
        @Volatile
        private var instance: ListRepository? = null

        fun getInstance(remote: RemoteDataSource): ListRepository =
            instance ?: synchronized(this) {
                ListRepository(remote).apply { instance = this }
            }
    }
    override fun loadMovies(): LiveData<List<MovieData>> {
        val getMovie = MutableLiveData<List<MovieData>>()

        remoteDataSource.getListMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(moviesResponse: List<MovieRemote>?) {

                val listMovie = ArrayList<MovieData>()
                if (moviesResponse != null) {
                    for (movies in moviesResponse) {
                        movies.apply {
                            val movie = MovieData(id, title, image, description, scores, date, background)
                            listMovie.add(movie)
                        }
                    }
                    getMovie.postValue(listMovie)
                }
            }

        })
        return getMovie
    }

    override fun loadDetailMovies(movieID: String): LiveData<DetailData> {
        val getDetailMovie = MutableLiveData<DetailData>()

        remoteDataSource.getDetailMovies(object : RemoteDataSource.LoadDetailMoviesCallback {
            override fun onAllDetailMoviesReceived(moviesDetail: MoviesDetailResponse?) {
                lateinit var detailMovie: DetailData
                moviesDetail?.apply {
                    val listGenre = ArrayList<String>()
                    for (genre in genres) {
                        listGenre.add(genre.name)
                    }

                    detailMovie = DetailData(
                        id = id,
                        title = title,
                        date = date,
                        image = image,
                        description = description,
                        scores = scores,
                        background = background,
                        genres = listGenre

                    )
                    getDetailMovie.postValue(detailMovie)
                }
            }

        }, movieID)
        return getDetailMovie
    }

    override fun loadTVShows(): LiveData<List<TvData>> {
        val getTVShow = MutableLiveData<List<TvData>>()

        remoteDataSource.getListTVShows(object : RemoteDataSource.LoadTVShowsCallback {
            override fun onAllTVShowReceived(tvShowResponse: List<TVShowRemote>?) {
                val listTVShow = ArrayList<TvData>()
                if (tvShowResponse !=null) {
                    for (tvShow in tvShowResponse) {
                        tvShow.apply {
                            val tvData = TvData(id, title, description, image, scores, date, background)
                            listTVShow.add(tvData)
                        }
                    }
                    getTVShow.postValue(listTVShow)
                }
            }

        })
        return getTVShow
    }

    override fun loadDetailTVShows(tvShowID: String): LiveData<DetailData>{
        val getDetailTVShow = MutableLiveData<DetailData>()

        remoteDataSource.getDetailTVShows(object  : RemoteDataSource.LoadDetailTVShowsCallback {
            override fun onAllDetailTVShowsReceived(tvShowDetail: TVShowsDetailResponse?) {
                lateinit var detailTVShow: DetailData
                tvShowDetail?.apply {
                    val listGenre = ArrayList<String>()
                    for (genre in genres) {
                        listGenre.add(genre.name)
                    }

                    detailTVShow = DetailData(
                        id = id,
                        title = title,
                        date = date,
                        image = image,
                        description = description,
                        scores = scores,
                        background = background,
                        genres = listGenre
                    )
                    getDetailTVShow.postValue(detailTVShow)
                }
            }

        }, tvShowID)
        return getDetailTVShow
    }
}