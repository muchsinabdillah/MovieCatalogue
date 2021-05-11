package com.mov.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity

interface MovieCatalogueDataSource {
    fun getAllMovies(page: Int): LiveData<List<MovieEntity>>

    fun getMovie(id: Int): LiveData<MovieEntity>

    fun getAllTvShow(page: Int): LiveData<List<TvShowEntity>>

    fun getTvShow(id: Int): LiveData<TvShowEntity>

    fun insertFavoriteMovie(movieEntity: MovieEntity)

    fun insertFavoriteTvShow(tvShowEntity: TvShowEntity)

    fun isFavoriteMovie(movieEntity: MovieEntity): Boolean

    fun isFavoriteTvshow(tvShowEntity: TvShowEntity): Boolean

    fun deleteFavoriteMovie(movieEntity: MovieEntity)

    fun deleteFavoriteTvShow(tvShowEntity: TvShowEntity)
}