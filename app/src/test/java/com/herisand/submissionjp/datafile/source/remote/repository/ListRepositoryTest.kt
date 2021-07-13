package com.herisand.submissionjp.datafile.source.remote.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.herisand.submissionjp.datafile.source.local.entity.MovieEntity
import com.herisand.submissionjp.datafile.source.local.entity.TvEntity
import com.herisand.submissionjp.datafile.source.local.room.LocalDataSource
import com.herisand.submissionjp.datafile.source.remote.source.RemoteDataSource
import com.herisand.submissionjp.resources.Resource
import com.herisand.submissionjp.utils.*
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock



class ListRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val listRepository = FakeListRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateRemoteDataMovie()
    private val tvShowResponse = DataDummy.generateRemoteDataTv()

    private val movieId = movieResponse[0].id
    private val tvSHowId = tvShowResponse[0].id

    private val detailMovie = DetailDataDummy.getDetailMovie()
    private val detailTvShow = DetailDataDummy.getDetailTVShow()

    @Test
    fun getMovies() {
        val dataSourceFactory = mock(androidx.paging.DataSource.Factory::class.java) as androidx.paging.DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovie()).thenReturn(dataSourceFactory)
        listRepository.loadMovies()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDataMovie()))
        verify(local).getAllMovie()
        assertNotNull(movieEntity.data)
        assertEquals(movieResponse.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getTVShows(){
        val dataSourceFactory = mock(androidx.paging.DataSource.Factory::class.java) as androidx.paging.DataSource.Factory<Int, TvEntity>
        `when`(local.getAllTv()).thenReturn(dataSourceFactory)
        listRepository.loadTVShows()

        val tvEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDataTv()))
        verify(local).getAllTv()
        assertNotNull(tvEntity.data)
        assertEquals(tvShowResponse.size.toLong(), tvEntity.data?.size?.toLong())

    }

    @Test
    fun getDetailMovie(){
        val dummyDetail = MutableLiveData<MovieEntity>()
        dummyDetail.value = DetailDataDummy.getDetailMovie()
        `when`(local.getMovieById(movieId)).thenReturn(dummyDetail)

        val movieDetailEntity = LiveDataTestUtil.getValue(listRepository.loadDetailMovies(movieId))
        verify(local).getMovieById(movieId)
        assertNotNull(movieDetailEntity)
        assertEquals(detailMovie.id, movieDetailEntity.data?.id)

    }

    @Test
    fun getDetailTVShow(){
        val dummyDetail = MutableLiveData<TvEntity>()
        dummyDetail.value = DetailDataDummy.getDetailTVShow()
        `when`(local.getTVShowById(tvSHowId)).thenReturn(dummyDetail)

        val tvDetailEntity = LiveDataTestUtil.getValue(listRepository.loadDetailTVShows(tvSHowId))
        verify(local).getTVShowById(tvSHowId)
        assertNotNull(tvDetailEntity)
        assertEquals(detailTvShow.id, tvDetailEntity.data?.id)
    }

    @Test
    fun setFavMovie() {
        listRepository.setMovieFav(DetailDataDummy.getDetailMovie(), true)
        verify(local).updateMovieFavorite(DetailDataDummy.getDetailMovie(), true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun getFavMovie() {
        val dataSourceFactory = mock(androidx.paging.DataSource.Factory::class.java) as androidx.paging.DataSource.Factory<Int, MovieEntity>
        `when` (local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        listRepository.getMoviesFav()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDataMovie()))
        verify(local).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size, movieEntities.data?.size)
    }

    @Test
    fun setFavTVShow() {
        listRepository.setTVShowsFav(DetailDataDummy.getDetailTVShow(), true)
        verify(local).updateTvShowFavorite(DetailDataDummy.getDetailTVShow(), true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun getFavTVShow() {
        val dataSourceFactory = mock(androidx.paging.DataSource.Factory::class.java) as androidx.paging.DataSource.Factory<Int, TvEntity>
        `when` (local.getFavoriteTvShow()).thenReturn(dataSourceFactory)
        listRepository.getTVShowsFav()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDataTv()))
        verify(local).getFavoriteTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size, tvShowEntities.data?.size)
    }

}