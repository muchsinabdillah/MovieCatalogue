package com.mov.moviecatalogue.ui.movie
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel
    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun testGetMovies() {
        val movieentity = viewModel.getMovies()
        assertNotNull(movieentity)
        assertEquals(10, movieentity.size)
    }
}