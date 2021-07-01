package com.herisand.submissionjp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.herisand.submissionjp.datafile.source.local.entity.MovieEntity
import com.herisand.submissionjp.datafile.source.local.entity.TvEntity
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository

class FavoriteViewModel(private val listRepository: ListRepository) : ViewModel(){
    fun getFavListMovie(): LiveData<PagedList<MovieEntity>> = listRepository.getMoviesFav()
    fun getFavListTVShow(): LiveData<PagedList<TvEntity>> = listRepository.getTVShowsFav()

    fun setFavListMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.favorite
        listRepository.setMovieFav(movieEntity, newState)
    }

    fun setFavListTVShow(tvEntity: TvEntity) {
        val newState = !tvEntity.favorite
        listRepository.setTVShowsFav(tvEntity, newState)
    }
}