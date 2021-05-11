package com.mov.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.CatalogueRepository

class DetailTvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    var tvShowId: Int = 0

    fun getTvShow(): LiveData<TvShowEntity> {
        return catalogueRepository.getTvShow(tvShowId)
    }

    fun insertFavorite(tvShowEntity: TvShowEntity) {
        catalogueRepository.insertFavoriteTvShow(tvShowEntity)
    }

    fun deleteFavorite(tvShowEntity: TvShowEntity) {
        catalogueRepository.deleteFavoriteTvShow(tvShowEntity)
    }

    fun isFavorited(tvShowEntity: TvShowEntity): Boolean {
        return catalogueRepository.isFavoriteTvshow(tvShowEntity)
    }
}