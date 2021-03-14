package com.mov.moviecatalogue

import com.mov.moviecatalogue.data.model.TvShowEntity

interface TvShowFragmentCallback {
    fun onShareClick(tvshow: TvShowEntity)
}
