package com.mov.moviecatalogue.data.source.local.room

import androidx.paging.DataSource
import androidx.room.*
import com.mov.moviecatalogue.data.model.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT *FROM Movie")
    fun getMoviesDao(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT *FROM Movie WHERE id = :id")
    fun getMoviesDaoById(id: Int?): MovieEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMoviesDao(movie: MovieEntity): Long

    @Delete
    fun deleteMoviesDao(movie: MovieEntity)

    @Query("DELETE FROM Movie WHERE id = :id")
    fun deleteMoviesDaoById(id: Long): Int

    @Update
    fun update(movie: MovieEntity): Int
}