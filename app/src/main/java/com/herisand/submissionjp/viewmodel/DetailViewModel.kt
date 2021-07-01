package com.herisand.submissionjp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.herisand.submissionjp.datafile.source.local.entity.MovieEntity
import com.herisand.submissionjp.datafile.source.local.entity.TvEntity
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository
import com.herisand.submissionjp.resources.Resource

class DetailViewModel(private  val listRepository: ListRepository): ViewModel() {

    private lateinit var detailMovie: LiveData<Resource<MovieEntity>>
    private lateinit var detailTVShow: LiveData<Resource<TvEntity>>

    fun setDetailMovie(movieId: Int) : LiveData<Resource<MovieEntity>> {
        detailMovie = listRepository.loadDetailMovies(movieId)
        return detailMovie
    }

    fun setDetailTVShow(tvShowId: Int) : LiveData<Resource<TvEntity>> {
        detailTVShow = listRepository.loadDetailTVShows(tvShowId)
        return detailTVShow
    }

    fun setMovieFav() {
        val dataMovie = detailMovie.value
        if (dataMovie?.data !=null) {
            val newState = !dataMovie.data.favorite
            listRepository.setMovieFav(dataMovie.data, newState)

        }
    }

    fun setTVShowFav() {
        val dataTVShow = detailTVShow.value
        if (dataTVShow?.data !=null) {
            val newState = !dataTVShow.data.favorite
            listRepository.setTVShowsFav(dataTVShow.data, newState)
        }
    }

}