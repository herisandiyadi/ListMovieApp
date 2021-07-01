package com.herisand.submissionjp.datafile.source.remote.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.herisand.submissionjp.datafile.source.local.entity.*
import com.herisand.submissionjp.resources.Resource

interface ListDataSource {
    fun loadMovies(): LiveData<Resource<PagedList<MovieEntity>>>
    fun loadTVShows(): LiveData<Resource<PagedList<TvEntity>>>

    fun loadDetailMovies(movieID: Int): LiveData<Resource<MovieEntity>>
    fun loadDetailTVShows(tvShowID: Int): LiveData<Resource<TvEntity>>

    fun setMovieFav(movie: MovieEntity, state: Boolean)
    fun setTVShowsFav(tvShow : TvEntity, state: Boolean)

    fun getMoviesFav(): LiveData<PagedList<MovieEntity>>
    fun getTVShowsFav(): LiveData<PagedList<TvEntity>>
}