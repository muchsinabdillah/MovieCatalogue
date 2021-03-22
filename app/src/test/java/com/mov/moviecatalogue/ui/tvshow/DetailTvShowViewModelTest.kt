package com.mov.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.CatalogueRepository
import com.mov.moviecatalogue.utils.DataDummy
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvshow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvshow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var tvshowObserve: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(catalogueRepository)
        viewModel.tvShowId = tvShowId
    }

    @Test
    fun getTvShow() {
        val course = MutableLiveData<TvShowEntity>()
        course.value = dummyTvshow

        Mockito.`when`(catalogueRepository.getTvShow(tvShowId)).thenReturn(course)
        val courseEntity = viewModel.getTvShow().value as TvShowEntity
        Mockito.verify(catalogueRepository).getTvShow(tvShowId)
        TestCase.assertNotNull(courseEntity)
        TestCase.assertEquals(dummyTvshow.id, courseEntity.id)
        TestCase.assertEquals(dummyTvshow.firstAirDate, courseEntity.firstAirDate)
        TestCase.assertEquals(dummyTvshow.description, courseEntity.description)
        TestCase.assertEquals(dummyTvshow.poster, courseEntity.poster)
        TestCase.assertEquals(dummyTvshow.title, courseEntity.title)

        viewModel.getTvShow().observeForever(tvshowObserve)
        Mockito.verify(tvshowObserve).onChanged(dummyTvshow)
    }

}