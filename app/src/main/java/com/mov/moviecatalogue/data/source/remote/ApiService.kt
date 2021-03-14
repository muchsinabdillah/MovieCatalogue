package com.mov.moviecatalogue.data.source.remote

import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.remote.response.MoviesResponse
import com.mov.moviecatalogue.data.source.remote.response.TvShowResponse
import com.mov.moviecatalogue.utils.UtilsConstanta.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular?api_key=$API_KEY")
    fun getAllMovie(@Query("page") page: Int): Call<MoviesResponse>

    @GET("movie/{id}?api_key=$API_KEY")
    fun getMovieById(@Path("id") id: Int): Call<MovieEntity>

    @GET("tv/popular?api_key=$API_KEY")
    fun getAllTvShow(@Query("page") page: Int): Call<TvShowResponse>

    @GET("tv/{id}?api_key=$API_KEY")
    fun getTvShowById(@Path("id") id: Int): Call<TvShowEntity>
}