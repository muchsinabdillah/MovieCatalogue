package com.mov.moviecatalogue.ui.movie
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.source.CatalogueRepository
import com.mov.moviecatalogue.utils.DataDummy
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var catalogueRepository : CatalogueRepository

    @Mock
    private   var observer= Mockito.mock(Observer::class.java) as Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(catalogueRepository)
    }


    @Test
    fun testGetMovies() {
        val dummyCourses = DataDummy.generateDummyMovie()
        val courses = MutableLiveData<List<MovieEntity>>()
        courses.value = dummyCourses

        `when`(catalogueRepository.getAllMovies(1)).thenReturn(courses)
        val courseEntities = viewModel.getMovies().value
        verify(catalogueRepository).getAllMovies(1)
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }
}