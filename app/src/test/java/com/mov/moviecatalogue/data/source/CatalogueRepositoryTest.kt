package com.mov.moviecatalogue.data.source
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.local.LocalRepository
import com.mov.moviecatalogue.data.source.remote.RemoteRepository
import com.mov.moviecatalogue.utils.AppExecutors
import com.mov.moviecatalogue.utils.DataDummy
import com.mov.moviecatalogue.utils.LiveDataTestUtil
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class CatalogueRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteRepository::class.java)
    private val local = Mockito.mock(LocalRepository::class.java)
    private val app = Mockito.mock(AppExecutors::class.java)
    private val academyRepository = FakeCatalogueRepository(remote,local,app)

    private val movieResponses = DataDummy.generateDummyMovie()
    private val movieId = movieResponses[0].id
    private val tvShowResponses = DataDummy.generateDummyTvShow()
    private val tvShowId = tvShowResponses[0].id
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    @Test
    fun testGetAllMovies() {
        val Dummymovies = MutableLiveData<List<MovieEntity>>()
        Dummymovies.value = DataDummy.generateDummyMovie()
        `when`(remote.getMovies(1)).thenReturn(Dummymovies)
        val movieEntities =  LiveDataTestUtil.getValue(academyRepository.getAllMovies(1))
        verify(remote).getMovies(1)
        assertNotNull(movieEntities.size)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }
    @Test
    fun testGetAllTvShow() {
        val DummyTvShow = MutableLiveData<List<TvShowEntity>>()
        DummyTvShow.value = DataDummy.generateDummyTvShow()
        `when`(remote.getTvShows(1)).thenReturn(DummyTvShow)
        val tvShowEntities =  LiveDataTestUtil.getValue(academyRepository.getAllTvShow(1))
        verify(remote).getTvShows(1)
        assertNotNull(tvShowEntities.size)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.size.toLong())
    }
    @Test
    fun testGetMovie() {
        val dummyMvEntity = MutableLiveData<MovieEntity>()
        dummyMvEntity.value = dummyMovie
        `when`(remote.getMovieById(movieId)).thenReturn(dummyMvEntity)
        val courseEntitiesContent = LiveDataTestUtil.getValue(academyRepository.getMovie(movieId))
        verify(remote).getMovieById(movieId)
        assertNotNull(courseEntitiesContent)
        assertEquals(dummyMovie.id, courseEntitiesContent.id)
    }
    @Test
    fun testGetTvShow() {
        val dummyTvEntity = MutableLiveData<TvShowEntity>()
        dummyTvEntity.value = dummyTvShow
        `when`(remote.getTvShowById(tvShowId)).thenReturn(dummyTvEntity)
        val courseEntitiesContent =  LiveDataTestUtil.getValue(academyRepository.getTvShow(tvShowId))
        verify(remote).getTvShowById(tvShowId)
        assertNotNull(courseEntitiesContent)
        assertEquals(dummyTvShow.id, courseEntitiesContent.id)
    }
    @Test
    fun testInsertFavoriteMovie() {
        //`when`(local.insertFavoriteMovie(dummyMovie)).thenReturn(dummyMovie)
        //val courseEntitiesContent = academyRepository.isFavoriteMovie(dummyMovie)
        //verify(local).insertFavoriteMovie(dummyMovie)
        //assertNotNull(courseEntitiesContent)
        //assertEquals(xx, courseEntitiesContent)

    }
    fun testInsertFavoriteTvShow() {}
    fun testIsFavoriteMovie() {}
    fun testIsFavoriteTvshow() {}
    fun testDeleteFavoriteMovie() {}
    fun testDeleteFavoriteTvShow() {}
    fun testGetFavoriteMovies() {}
    fun testGetFavoriteTvShows() {}


}