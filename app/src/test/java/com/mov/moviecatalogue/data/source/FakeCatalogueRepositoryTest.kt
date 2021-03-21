package com.mov.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.remote.RemoteRepository
import junit.framework.TestCase

class FakeCatalogueRepositoryTest (
    private val remoteRepository: RemoteRepository
): MovieCatalogueDataSource {
    companion object {
        fun getInstance(remoteRepository: RemoteRepository): CatalogueRepository {
            return CatalogueRepository(remoteRepository)
        }
    }
    override fun getAllMovies(page: Int): LiveData<List<MovieEntity>> {
        return remoteRepository.getMovies(page)
    }

    override fun getMovie(id: Int): LiveData<MovieEntity> {
        return remoteRepository.getMovieById(id)
    }

    override fun getAllTvShow(page: Int): LiveData<List<TvShowEntity>> {
        return remoteRepository.getTvShows(page)
    }

    override fun getTvShow(id: Int): LiveData<TvShowEntity> {
        return remoteRepository.getTvShowById(id)
    }

}