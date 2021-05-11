package com.mov.moviecatalogue.data.source.local.room

import androidx.paging.DataSource
import androidx.room.*
import com.mov.moviecatalogue.data.model.TvShowEntity

@Dao
interface TvShowDao {
    @Query("SELECT *FROM TvShow")
    fun getTvShowDao(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT *FROM TvShow WHERE id = :id")
    fun getTvShowDaoById(id: Int?): TvShowEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShowDao(movie: TvShowEntity): Long

    @Delete
    fun deleteTvShowDao(movie: TvShowEntity)

    @Query("DELETE FROM TvShow WHERE id = :id")
    fun deleteTvShowDaoById(id: Long): Int

    @Update
    fun update(movie: TvShowEntity): Int
}