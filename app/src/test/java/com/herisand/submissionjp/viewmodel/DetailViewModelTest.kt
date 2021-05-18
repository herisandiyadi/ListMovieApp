package com.herisand.submissionjp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.herisand.submissionjp.datafile.source.local.entity.DetailData
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository
import com.herisand.submissionjp.utils.DataDummy
import com.herisand.submissionjp.viewmodel.DetailViewModel.Companion.MOVIE
import com.herisand.submissionjp.viewmodel.DetailViewModel.Companion.TV_SHOW
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
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
    private val dummyDetailTv = DataDummy.getDetailMovie()
    private val movieID = dummyDetailMovie.id.toString()
    private val tvShowID = dummyDetailTv.id.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var listRepository: ListRepository

    @Mock
    private lateinit var movieObserver: Observer<DetailData>

    @Mock
    private lateinit var tvShowObserver: Observer<DetailData>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(listRepository)
    }

    @Test
    fun getDetailMovie() {
        val movie = MutableLiveData<DetailData>()
        movie.value = dummyDetailMovie

        `when`(listRepository.loadDetailMovies(movieID)).thenReturn(movie)
        viewModel.setDetailContent(movieID, MOVIE)
        val detailMovie = viewModel.getDetailContent().value
        verify(listRepository).loadDetailMovies(movieID)
        assertNotNull(detailMovie)

        dummyDetailMovie.apply {
            assertEquals(id, detailMovie?.id)
            assertEquals(title, detailMovie?.title)
            assertEquals(date, detailMovie?.date)
            assertEquals(description, detailMovie?.description)
            assertEquals(image, detailMovie?.image)
            assertEquals(background, detailMovie?.background)
            assertEquals(genres, detailMovie?.genres)
        }

        viewModel.getDetailContent().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyDetailMovie)

    }

    @Test
    fun getDetailTVShow() {
        val tvShow = MutableLiveData<DetailData>()
        tvShow.value = dummyDetailTv

        `when`(listRepository.loadDetailTVShows(tvShowID)).thenReturn(tvShow)
        viewModel.setDetailContent(tvShowID, TV_SHOW)
        val detailTVShow = viewModel.getDetailContent().value
        verify(listRepository).loadDetailTVShows(tvShowID)
        assertNotNull(detailTVShow)

        dummyDetailMovie.apply {
            assertEquals(id, detailTVShow?.id)
            assertEquals(title, detailTVShow?.title)
            assertEquals(date, detailTVShow?.date)
            assertEquals(description, detailTVShow?.description)
            assertEquals(image, detailTVShow?.image)
            assertEquals(background, detailTVShow?.background)
            assertEquals(genres, detailTVShow?.genres)
        }

        viewModel.getDetailContent().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyDetailMovie)
    }

}