package com.herisand.submissionjp.datafile.source.remote.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.herisand.submissionjp.datafile.source.remote.source.RemoteDataSource
import com.herisand.submissionjp.utils.DataDummy
import com.herisand.submissionjp.utils.DetailDataDummy
import com.herisand.submissionjp.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito


class ListRepositoryTest {

    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val listRepository = FakeListRepository(remote)

    private val movieResponse = DataDummy.generateRemoteDataMovie()
    private val tvShowResponse = DataDummy.generateRemoteDataTv()

    private val movieId = movieResponse[0].id.toString()
    private val tvShowId = tvShowResponse[0].id.toString()

    private val detailMovie = DetailDataDummy.getRemoteDetailMovie()
    private val detaTVShow = DetailDataDummy.getRemoteDetailTVShow()

    @Test
    fun getMovies() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).getListMovies(any())

        val movieEntity = LiveDataTestUtil.getValue(listRepository.loadMovies())
        verify(remote).getListMovies(any())
        assertNotNull(movieEntity)
        assertEquals(movieResponse.size.toLong(), movieEntity.size.toLong())
    }

    @Test
    fun getTVShows() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadTVShowsCallback)
                .onAllTVShowReceived(tvShowResponse)
            null
        }.`when`(remote).getListTVShows(any())

        val tvEntity = LiveDataTestUtil.getValue(listRepository.loadTVShows())
        verify(remote).getListTVShows(any())
        assertNotNull(tvEntity)
        assertEquals(tvShowResponse.size.toLong(), tvEntity.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadDetailMoviesCallback)
                .onAllDetailMoviesReceived(detailMovie)
            null
        }.`when`(remote).getDetailMovies(any(), eq(movieId))

        val detailMovieEntity = LiveDataTestUtil.getValue(listRepository.loadDetailMovies(movieId))
        verify(remote).getDetailMovies(any(), eq(movieId))
        assertNotNull(detailMovieEntity)
        assertEquals(detailMovie.id, detailMovieEntity.id)
    }

    @Test
    fun getDetailTVShow() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadDetailTVShowsCallback)
                .onAllDetailTVShowsReceived(detaTVShow)
            null
        }.`when`(remote).getDetailTVShows(any(), eq(tvShowId))

        val detailTVEntity = LiveDataTestUtil.getValue(listRepository.loadDetailTVShows(tvShowId))
        verify(remote).getDetailTVShows(any(), eq(tvShowId))
        assertNotNull(detailTVEntity)
        assertEquals(detaTVShow.id, detailTVEntity.id)
    }

}