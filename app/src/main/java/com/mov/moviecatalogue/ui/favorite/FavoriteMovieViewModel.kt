package com.mov.moviecatalogue.ui.favorite

import androidx.lifecycle.ViewModel
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.CatalogueRepository

class FavoriteMovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getFavoriteMovies() = catalogueRepository.getFavoriteMovies()
    fun getFavoriteTvShows() = catalogueRepository.getFavoriteTvShows()
    fun deleteFavoriteM(movieEntity: MovieEntity) {
        catalogueRepository.deleteFavoriteMovie(movieEntity)
    }

    fun insertFavoriteM(movieEntity: MovieEntity) {
        catalogueRepository.insertFavoriteMovie(movieEntity)
    }

    fun deleteFavoriteT(tvShowEntity: TvShowEntity) {
        catalogueRepository.deleteFavoriteTvShow(tvShowEntity)
    }

    fun insertFavoriteT(tvShowEntity: TvShowEntity) {
        catalogueRepository.insertFavoriteTvShow(tvShowEntity)
    }
}