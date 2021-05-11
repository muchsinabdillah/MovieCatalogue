package com.mov.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.CatalogueRepository

class TvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    var page = 1
    fun getTvshows(): LiveData<List<TvShowEntity>> {
        return catalogueRepository.getAllTvShow(page)
    }
}