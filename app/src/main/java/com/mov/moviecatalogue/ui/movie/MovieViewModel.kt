package com.mov.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.source.CatalogueRepository

class MovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    var page = 1
    fun getMovies(): LiveData<List<MovieEntity>> {
        return catalogueRepository.getAllMovies(page)
    }
}