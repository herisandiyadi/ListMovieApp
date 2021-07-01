package com.herisand.submissionjp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.herisand.submissionjp.datafile.source.local.entity.TvData
import com.herisand.submissionjp.datafile.source.local.entity.TvEntity
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository
import com.herisand.submissionjp.resources.Resource

class TvShowViewModel(private val contentRepository: ListRepository): ViewModel() {
    fun getTvShow(): LiveData<Resource<PagedList<TvEntity>>> = contentRepository.loadTVShows()
}