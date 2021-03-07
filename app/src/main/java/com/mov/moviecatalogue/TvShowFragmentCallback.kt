package com.mov.moviecatalogue

import com.mov.moviecatalogue.data.TvShowEntity

interface TvShowFragmentCallback {
    fun onShareClick(tvshow: TvShowEntity)
}
