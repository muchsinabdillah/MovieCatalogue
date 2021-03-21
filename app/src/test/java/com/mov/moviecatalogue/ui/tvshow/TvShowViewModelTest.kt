package com.mov.moviecatalogue.ui.tvshow
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.CatalogueRepository
import com.mov.moviecatalogue.ui.movie.MovieViewModel
import com.mov.moviecatalogue.utils.DataDummy
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest   {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository : CatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<TvShowEntity>>


    @Before
    fun setUp() {
        viewModel = TvShowViewModel(catalogueRepository)
    }

    @Test
    fun testGetTvshows() {
        val dummyCourses = DataDummy.generateDummyTvShow()
        val courses = MutableLiveData<List<TvShowEntity>>()
        courses.value = dummyCourses

        Mockito.`when`(catalogueRepository.getAllTvShow(1)).thenReturn(courses)
        val courseEntities = viewModel.getTvshows().value
        Mockito.verify(catalogueRepository).getAllTvShow(1)
        Assert.assertNotNull(courseEntities)
        TestCase.assertEquals(10, courseEntities?.size)

        viewModel.getTvshows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyCourses)

    }
}