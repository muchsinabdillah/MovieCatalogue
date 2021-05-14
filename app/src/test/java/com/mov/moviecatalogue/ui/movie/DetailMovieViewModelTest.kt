package com.mov.moviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.CatalogueRepository
import com.mov.moviecatalogue.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var movieObserve: Observer<MovieEntity>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(catalogueRepository)
        viewModel.movieId = movieId
    }

    @Test
    fun getMovie() {
        val course = MutableLiveData<MovieEntity>()
        course.value = dummyMovie
        `when`(catalogueRepository.getMovie(movieId)).thenReturn(course)
        val courseEntity = viewModel.getMovie().value as MovieEntity
        verify(catalogueRepository).getMovie(movieId)
        assertNotNull(courseEntity)
        assertEquals(dummyMovie.id, courseEntity.id)
        assertEquals(dummyMovie.status, courseEntity.status)
        assertEquals(dummyMovie.description, courseEntity.description)
        assertEquals(dummyMovie.poster, courseEntity.poster)
        assertEquals(dummyMovie.title, courseEntity.title)
        viewModel.getMovie().observeForever(movieObserve)
        verify(movieObserve).onChanged(dummyMovie)
    }



}