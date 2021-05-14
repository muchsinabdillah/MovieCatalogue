package com.mov.moviecatalogue.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.CatalogueRepository
import com.mov.moviecatalogue.ui.movie.MovieViewModel
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

class FavoriteMovieViewModelTest  {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: FavoriteMovieViewModel
    private var catalogueRepository = Mockito.mock(CatalogueRepository::class.java)

    @Before
    fun setUp() {
        viewModel = FavoriteMovieViewModel(catalogueRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyMovies = MutableLiveData<PagedList<MovieEntity>>()
        val pagedList: PagedList<MovieEntity> = Mockito.mock(PagedList::class.java) as PagedList<MovieEntity>
        dummyMovies.value = pagedList

        Mockito.`when`(catalogueRepository.getFavoriteMovies()).thenReturn(dummyMovies)
        val observer = Mockito.mock(Observer::class.java) as Observer<PagedList<MovieEntity>>

        viewModel.getFavoriteMovies().observeForever(observer)

        Mockito.verify(observer).onChanged(pagedList)
    }

    @Test
    fun testGetFavoriteTvShows() {
        val dummyShows = MutableLiveData<PagedList<TvShowEntity>>()
        val pagedList: PagedList<TvShowEntity> = Mockito.mock(PagedList::class.java) as PagedList<TvShowEntity>
        dummyShows.value = pagedList

        Mockito.`when`(catalogueRepository.getFavoriteTvShows()).thenReturn(dummyShows)
        val observer = Mockito.mock(Observer::class.java) as Observer<PagedList<TvShowEntity>>

        viewModel.getFavoriteTvShows().observeForever(observer)

        Mockito.verify(observer).onChanged(pagedList)
    }

    fun testDeleteFavoriteM() {

    }

    fun testInsertFavoriteM() {}

    fun testDeleteFavoriteT() {}

    fun testInsertFavoriteT() {}
}