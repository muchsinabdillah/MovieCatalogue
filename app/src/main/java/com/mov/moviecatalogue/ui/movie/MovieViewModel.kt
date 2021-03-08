package com.mov.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.mov.moviecatalogue.data.MovieEntity
import com.mov.moviecatalogue.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies():List<MovieEntity> = DataDummy.generateDummyMovie()
}