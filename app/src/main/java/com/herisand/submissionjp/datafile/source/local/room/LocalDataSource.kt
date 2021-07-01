package com.herisand.submissionjp.datafile.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.herisand.submissionjp.datafile.source.local.entity.MovieEntity
import com.herisand.submissionjp.datafile.source.local.entity.TvEntity
import com.herisand.submissionjp.datafile.source.local.room.database.ContentDAO

class LocalDataSource private constructor(private val mContentDAO: ContentDAO){

    companion object {
        private var INSTANCE : LocalDataSource? = null

        fun getInstance(contentDAO: ContentDAO): LocalDataSource =
            INSTANCE ?: LocalDataSource(contentDAO).apply {
                INSTANCE = this
            }
    }

    fun getAllMovie(): DataSource.Factory<Int, MovieEntity> = mContentDAO.getMovie()

    fun getAllTv(): DataSource.Factory<Int, TvEntity> = mContentDAO.getTvShow()

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = mContentDAO.getFavoriteMovie()

    fun getFavoriteTvShow(): DataSource.Factory<Int, TvEntity> = mContentDAO.getFavoriteTvShow()

    fun getMovieById(id: Int): LiveData<MovieEntity> = mContentDAO.getMovieById(id)

    fun getTVShowById(id: Int): LiveData<TvEntity> = mContentDAO.getTVShowById(id)

    fun insertMovie(movies: List<MovieEntity>) = mContentDAO.insertMovie(movies)

    fun insertTv(tvSHow:List<TvEntity>) = mContentDAO.insertTv(tvSHow)

    fun updateMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        mContentDAO.updateMovie(movie)
    }

    fun updateTvShowFavorite(tvSHow: TvEntity, newState: Boolean) {
        tvSHow.favorite = newState
        mContentDAO.updateTvShow(tvSHow)
    }
}