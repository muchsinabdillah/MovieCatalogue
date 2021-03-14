package com.mov.moviecatalogue.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mov.moviecatalogue.data.source.CatalogueRepository
import com.mov.moviecatalogue.di.Injection
import com.mov.moviecatalogue.ui.movie.DetailMovieViewModel
import com.mov.moviecatalogue.ui.movie.MovieViewModel
import com.mov.moviecatalogue.ui.tvshow.DetailTvShowViewModel
import com.mov.moviecatalogue.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val catalogueRepository: CatalogueRepository) : ViewModelProvider.NewInstanceFactory() {
    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(catalogueRepository) as (T)
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> DetailMovieViewModel(catalogueRepository) as (T)
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(catalogueRepository) as (T)
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> DetailTvShowViewModel(catalogueRepository) as (T)
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}