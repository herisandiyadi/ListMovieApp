package com.herisand.submissionjp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.herisand.submissionjp.datafile.source.local.entity.DetailData
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository

class DetailViewModel(private  val listRepository: ListRepository): ViewModel() {

    private lateinit var detailContent: LiveData<DetailData>

    companion object{
        const val MOVIE = "detail_movie"
        const val TV_SHOW = "detail_tv"
    }

    fun setDetailContent(id: String, select: String) {
        when(select) {
            MOVIE -> {
                detailContent = listRepository.loadDetailMovies(id)
            }
            TV_SHOW -> {
                detailContent = listRepository.loadDetailTVShows(id)
            }
        }
    }

    fun getDetailContent() = detailContent

}