package com.herisand.submissionjp.datafile.source.remote.source

import androidx.lifecycle.LiveData
import com.herisand.submissionjp.datafile.source.local.entity.DetailData
import com.herisand.submissionjp.datafile.source.local.entity.MovieData
import com.herisand.submissionjp.datafile.source.local.entity.TvData

interface ListDataSource {
    fun loadMovies(): LiveData<List<MovieData>>
    fun loadTVShows(): LiveData<List<TvData>>
    fun loadDetailMovies(movieID: String): LiveData<DetailData>
    fun loadDetailTVShows(tvShowID: String): LiveData<DetailData>
}