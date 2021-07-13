package com.herisand.submissionjp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.herisand.submissionjp.datafile.source.local.entity.MovieEntity
import com.herisand.submissionjp.datafile.source.local.entity.TvEntity
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository
import com.herisand.submissionjp.utils.DetailDataDummy
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var listRepository: ListRepository

    @Mock
    private lateinit var movieObserver: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<PagedList<TvEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tvShowPagedList: PagedList<TvEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(listRepository)
    }

    @Test
    fun setFavListMovies() {
        viewModel.setFavListMovie(DetailDataDummy.getDetailMovie())
        verify(listRepository).setMovieFav(DetailDataDummy.getDetailMovie(), true)
        verifyNoMoreInteractions(listRepository)
    }

    @Test
    fun setFavListTVShows() {
        viewModel.setFavListTVShow(DetailDataDummy.getDetailTVShow())
        verify(listRepository).setTVShowsFav(DetailDataDummy.getDetailTVShow(), true)
        verifyNoMoreInteractions(listRepository)
    }

    @Test
    fun getFavListMovies() {
        val dummyMovie = moviePagedList
        `when` (dummyMovie.size).thenReturn(5)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMovie

        `when` (listRepository.getMoviesFav()).thenReturn(movies)
        val favMovie = viewModel.getFavListMovie().value
        verify(listRepository).getMoviesFav()
        Assert.assertNotNull(favMovie)
        Assert.assertEquals(5, favMovie?.size)

        viewModel.getFavListMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getFavListTVShows() {
        val dummyTVShow = tvShowPagedList
        `when` (dummyTVShow.size).thenReturn(5)
        val tvShows = MutableLiveData<PagedList<TvEntity>>()
        tvShows.value = dummyTVShow

        `when` (listRepository.getTVShowsFav()).thenReturn(tvShows)
        val favTVShows = viewModel.getFavListTVShow().value
        verify(listRepository).getTVShowsFav()
        Assert.assertNotNull(favTVShows)
        Assert.assertEquals(5, favTVShows?.size)

        viewModel.getFavListTVShow().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTVShow)
    }

}