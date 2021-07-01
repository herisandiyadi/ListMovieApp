package com.herisand.submissionjp.datafile.source.local.room.database

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.herisand.submissionjp.datafile.source.local.entity.MovieEntity
import com.herisand.submissionjp.datafile.source.local.entity.TvEntity

@Dao
interface ContentDAO {

    @Query("SELECT * FROM movieentity")
    fun getMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tventity")
    fun getTvShow(): DataSource.Factory<Int, TvEntity>

    @Query("SELECT * FROM movieentity where favorite = 1")
    fun getFavoriteMovie() : DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tventity where favorite = 1")
    fun getFavoriteTvShow(): DataSource.Factory<Int, TvEntity>

    @Query("SELECT * FROM movieentity where id = :id")
    fun getMovieById(id: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM tventity where id = :id")
    fun getTVShowById(id: Int): LiveData<TvEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieEntity: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTv(tvEntity: List<TvEntity>)

    @Delete
    fun delete(movieEntity: MovieEntity)

    @Delete
    fun delete(tvEntity: TvEntity)

    @Query("SELECT * FROM movieentity WHERE id = :id")
    fun getDetailMovie(id: String): LiveData<MovieEntity>

    @Query("SELECT * FROM tventity WHERE id = :id")
    fun getDetailTvShow(id: String): LiveData<TvEntity>

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvShow: TvEntity)

}