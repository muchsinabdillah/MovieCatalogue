package com.mov.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.source.CatalogueRepository

class DetailMovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    var movieId: Int = 0

    fun getMovie(): LiveData<MovieEntity> {
        return catalogueRepository.getMovie(movieId)
    }

    fun insertFavorite(movieEntity: MovieEntity) {
        catalogueRepository.insertFavoriteMovie(movieEntity)
    }

    fun deleteFavorite(movieEntity: MovieEntity) {
        catalogueRepository.deleteFavoriteMovie(movieEntity)
    }

    fun isFavorited(movieEntity: MovieEntity): Boolean {
        return catalogueRepository.isFavoriteMovie(movieEntity)
    }
}