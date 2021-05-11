package com.mov.moviecatalogue.data.source.local

import android.content.Context
import androidx.paging.DataSource
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.local.room.MovieDao
import com.mov.moviecatalogue.data.source.local.room.TvShowDao
import com.mov.moviecatalogue.data.source.local.room.TvShowDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LocalRepository(context: Context) {
    private val movieDao: MovieDao
    private val tvShowDao: TvShowDao

    init {
        val db = TvShowDatabase.getInstance(context)
        movieDao = db.movieDao()
        tvShowDao = db.tvshowDao()
    }

    companion object {
        fun getInstance(context: Context): LocalRepository {
            return LocalRepository(context)
        }
    }

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> {
        return movieDao.getMoviesDao()
    }

    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity> {
        return tvShowDao.getTvShowDao()
    }

    fun insertFavoriteMovie(movieEntity: MovieEntity) {
        GlobalScope.launch(Dispatchers.Main) { movieDao.insertMoviesDao(movieEntity) }
    }

    fun insertFavoriteTvShow(tvShowEntity: TvShowEntity) {
        GlobalScope.launch(Dispatchers.Main) { tvShowDao.insertTvShowDao(tvShowEntity) }
    }

    fun isFavoriteMovie(movieEntity: MovieEntity): Boolean {
        return movieDao.getMoviesDaoById(movieEntity.id) != null
    }

    fun isFavoriteTvshow(tvShowEntity: TvShowEntity): Boolean {
        return tvShowDao.getTvShowDaoById(tvShowEntity.id) != null
    }

    fun deleteFavoriteMovie(movieEntity: MovieEntity) {
        GlobalScope.launch(Dispatchers.Main) { movieDao.deleteMoviesDao(movieEntity) }
    }

    fun deleteFavoriteTvShow(tvShowEntity: TvShowEntity) {
        GlobalScope.launch(Dispatchers.Main) { tvShowDao.deleteTvShowDao(tvShowEntity) }
    }


}