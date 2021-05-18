package com.herisand.submissionjp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.herisand.submissionjp.datafile.source.local.entity.MovieData
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository
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
    private lateinit var observer: Observer<List<MovieData>>

    @Before
    fun setMovie(){
        viewModel = MovieViewModel(listRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovie = DataDummy.generateDataMovie()
        val listMovies = MutableLiveData<List<MovieData>>()
        listMovies.value = dummyMovie

        `when`(listRepository.loadMovies()).thenReturn(listMovies)
        val movieData = viewModel.getMovie().value
        verify(listRepository).loadMovies()
        assertNotNull(movieData)
        assertEquals(20, movieData?.size)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}