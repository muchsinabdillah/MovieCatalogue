package com.mov.moviecatalogue.ui.tvshow
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest   {

    private lateinit var viewModel: TvShowViewModel
    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun testGetTvshows() {
        val tvshowentity = viewModel.getTvshows()
        Assert.assertNotNull(tvshowentity)
        Assert.assertEquals(10, tvshowentity.size)
    }
}