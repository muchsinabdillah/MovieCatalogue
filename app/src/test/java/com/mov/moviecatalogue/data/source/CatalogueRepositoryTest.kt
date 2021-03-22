package com.mov.moviecatalogue.data.source

import androidx.lifecycle.MutableLiveData
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.remote.RemoteRepository
import com.mov.moviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class CatalogueRepositoryTest {
    private val remote = mock(RemoteRepository::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote)

    private val dummyMovies = DataDummy.generateRemoteDummyMovies()
    private val movieId = dummyMovies[0].id
    //private val movieDetail = DataDummy.getRemoteDetailMovie()

    private val dummyTvShow = DataDummy.generateRemoteDummyTvShow()
    private val tvShowId = dummyTvShow[0].id
    //private val tvShowDetail = DataDummy.getRemoteDetailTvShow()

    @Test
    fun getAllMovies() {
        val page = 1
        val dummyMovies = DataDummy.generateRemoteDummyMovies()
        val movies: MutableLiveData<List<MovieEntity>> = MutableLiveData()
        movies.postValue(dummyMovies)
        `when`(remote.getMovies(page)).thenReturn(movies)
        val movieEntitty = catalogueRepository.getAllMovies(page)
        verify<RemoteRepository>(remote).getMovies(page)
        assertNotNull(movieEntitty)
        assertEquals(movies.value?.size?.toLong(), movieEntitty.value?.size?.toLong())
    }

    @Test
    fun getAllTvShow() {
        val page = 1
        val dummyTvShow = DataDummy.generateRemoteDummyTvShow()
        val tvshows: MutableLiveData<List<TvShowEntity>> = MutableLiveData()
        tvshows.postValue(dummyTvShow)
        `when`(remote.getTvShows(page)).thenReturn(tvshows)
        val tvshowEntity = catalogueRepository.getAllTvShow(page)
        verify<RemoteRepository>(remote).getTvShows(page)
        assertNotNull(tvshowEntity)
        assertEquals(tvshows.value?.size?.toLong(), tvshowEntity.value?.size?.toLong())
    }


}