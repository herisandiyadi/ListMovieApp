package com.herisand.submissionjp.viewmodel


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.herisand.submissionjp.datafile.source.local.entity.TvData
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository
import com.herisand.submissionjp.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
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
    private lateinit var observer: Observer<List<TvData>>

    @Before
    fun setTvShow(){
        viewModel = TvShowViewModel(listRepository)
    }

    @Test
    fun getTvShow() {
        val dummyData = DataDummy.generateDataTv()
        val tvShows = MutableLiveData<List<TvData>>()
        tvShows.value = dummyData

        `when`(listRepository.loadTVShows()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getTvShow().value
        verify(listRepository).loadTVShows()
        assertNotNull(tvShows)
        assertEquals(20, tvShowEntities?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyData)
    }

}