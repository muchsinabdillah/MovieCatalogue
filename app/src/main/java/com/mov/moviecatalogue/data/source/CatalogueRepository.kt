package com.mov.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.local.LocalRepository
import com.mov.moviecatalogue.data.source.remote.RemoteRepository
import com.mov.moviecatalogue.utils.AppExecutors

class CatalogueRepository(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository,
    private val appExecutors: AppExecutors
) : MovieCatalogueDataSource {

    companion object {
        fun getInstance(
            remoteRepository: RemoteRepository,
            localRepository: LocalRepository,
            appExecutors: AppExecutors
        ): CatalogueRepository {
            return CatalogueRepository(remoteRepository, localRepository, appExecutors)
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

    override fun insertFavoriteMovie(movieEntity: MovieEntity) {
        localRepository.insertFavoriteMovie(movieEntity)
    }

    override fun insertFavoriteTvShow(tvShowEntity: TvShowEntity) {
        localRepository.insertFavoriteTvShow(tvShowEntity)
    }

    override fun isFavoriteMovie(movieEntity: MovieEntity) =
        localRepository.isFavoriteMovie(movieEntity)

    override fun isFavoriteTvshow(tvShowEntity: TvShowEntity) =
        localRepository.isFavoriteTvshow(tvShowEntity)


    override fun deleteFavoriteMovie(movieEntity: MovieEntity) {
        appExecutors.diskIO().execute {
            localRepository.deleteFavoriteMovie(movieEntity)
        }
    }

    override fun deleteFavoriteTvShow(tvShowEntity: TvShowEntity) {
        appExecutors.diskIO().execute {
            localRepository.deleteFavoriteTvShow(tvShowEntity)
        }
    }

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localRepository.getFavoriteMovies(), config).build()
    }

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localRepository.getFavoriteTvShows(), config).build()
    }

}