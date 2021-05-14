package com.mov.moviecatalogue.data.source.local.room

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mov.moviecatalogue.data.model.MovieEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)

class TvShowTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var  database: TvShowDatabase
    private lateinit var  dao: MovieDao

    @Before
    fun TestSetup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TvShowDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.movieDao()
    }
    @After
    fun teardown(){
        database.close()
    }
    @Test
    fun insertFavoriteMovie() = runBlocking {
        val movieItem = MovieEntity(1,"","","","",
            .1f,"","","")
        dao.insertMoviesDao(movieItem)
       
    }

}