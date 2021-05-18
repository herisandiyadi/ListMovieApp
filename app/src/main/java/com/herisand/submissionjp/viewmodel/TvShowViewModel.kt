package com.herisand.submissionjp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.herisand.submissionjp.datafile.source.local.entity.TvData
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository

class TvShowViewModel(private val contentRepository: ListRepository): ViewModel() {
    fun getTvShow(): LiveData<List<TvData>> = contentRepository.loadTVShows()
}