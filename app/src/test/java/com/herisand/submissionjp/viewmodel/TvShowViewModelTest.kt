package com.herisand.submissionjp.viewmodel


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.herisand.submissionjp.datafile.source.local.entity.TvEntity
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository
import com.herisand.submissionjp.resources.Resource
import junit.framework.TestCase.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var listRepository: ListRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvEntity>>>

    @Mock
    private lateinit var tvPagedList: PagedList<TvEntity>

    @Before
    fun setTvShow(){
        viewModel = TvShowViewModel(listRepository)
    }

    @Test
    fun getTvShow() {
        val dummyData = Resource.success(tvPagedList)
        `when` (dummyData.data?.size).thenReturn(5)
        val tvShows = MutableLiveData<Resource<PagedList<TvEntity>>>()
        tvShows.value = dummyData

        `when`(listRepository.loadTVShows()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getTvShow().value?.data
        verify(listRepository).loadTVShows()
        assertNotNull(tvShows)
        assertEquals(5, tvShowEntities?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyData)
    }

}