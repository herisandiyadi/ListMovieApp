package com.herisand.submissionjp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.herisand.submissionjp.datafile.source.local.entity.MovieData
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository

class MovieViewModel(private val listRepository: ListRepository): ViewModel() {
    fun getMovie(): LiveData<List<MovieData>> = listRepository.loadMovies()
}