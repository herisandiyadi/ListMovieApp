package com.herisand.submissionjp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.herisand.submissionjp.datafile.source.local.entity.MovieData
import com.herisand.submissionjp.datafile.source.local.entity.MovieEntity
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository
import com.herisand.submissionjp.resources.Resource
import com.herisand.submissionjp.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest{

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var listRepository: ListRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Before
    fun setMovie(){
        viewModel = MovieViewModel(listRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovie = Resource.success(moviePagedList)
        `when` (dummyMovie.data?.size).thenReturn(5)
        val listMovies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        listMovies.value = dummyMovie

        `when`(listRepository.loadMovies()).thenReturn(listMovies)
        val movieEntity = viewModel.getMovie().value?.data
        verify(listRepository).loadMovies()
        assertNotNull(movieEntity)
        assertEquals(5, movieEntity?.size)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}