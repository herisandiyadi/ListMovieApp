package com.herisand.submissionjp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.herisand.submissionjp.datafile.source.local.entity.MovieEntity
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository
import com.herisand.submissionjp.resources.Resource

class MovieViewModel(private val listRepository: ListRepository): ViewModel() {
    fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>> = listRepository.loadMovies()
}