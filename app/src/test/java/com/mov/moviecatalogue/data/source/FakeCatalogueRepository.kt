package com.mov.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.remote.RemoteRepository

class FakeCatalogueRepository(
    private val remoteRepository: RemoteRepository
) : MovieCatalogueDataSource {

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