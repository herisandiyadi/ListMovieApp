package com.herisand.submissionjp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.herisand.submissionjp.datafile.source.local.entity.MovieEntity
import com.herisand.submissionjp.datafile.source.local.entity.TvEntity
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository
import com.herisand.submissionjp.resources.Resource
import com.herisand.submissionjp.utils.DataDummy
import com.herisand.submissionjp.utils.DetailDataDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest{

    private lateinit var viewModel: DetailViewModel
    private val dummyDetailMovie = DataDummy.getDetailMovie()
    private val dummyDetailTv = DataDummy.getDetailTV()

    private val movieID = dummyDetailMovie.id
    private val tvShowID = dummyDetailTv.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var listRepository: ListRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(listRepository)
    }

    @Test
    fun getDetailMovie() {
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = Resource.success(DetailDataDummy.getDetailMovie())

        `when`(listRepository.loadDetailMovies(movieID)).thenReturn(movie)
        viewModel.setDetailMovie(movieID).observeForever(movieObserver)
        verify(movieObserver).onChanged(movie.value)

    }

    @Test
    fun getDetailTVShow() {
        val tvShow = MutableLiveData<Resource<TvEntity>>()
        tvShow.value = Resource.success(DetailDataDummy.getDetailTVShow())

        `when`(listRepository.loadDetailTVShows(tvShowID)).thenReturn(tvShow)
        viewModel.setDetailTVShow(tvShowID).observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(tvShow.value)
    }

}