package com.mov.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.mov.moviecatalogue.data.MovieEntity
import com.mov.moviecatalogue.data.TvShowEntity
import com.mov.moviecatalogue.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvshows():List<TvShowEntity> = DataDummy.generateDummyTvShow()
}