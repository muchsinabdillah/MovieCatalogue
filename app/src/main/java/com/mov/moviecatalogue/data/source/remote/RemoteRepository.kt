package com.mov.moviecatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.data.source.remote.response.MoviesResponse
import com.mov.moviecatalogue.data.source.remote.response.TvShowResponse
import com.mov.moviecatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {
    private val myApiClient = ApiConfig.getApiConfig().create(ApiService::class.java)
    companion object {
        fun getInstance(): RemoteRepository{
            return  RemoteRepository()
        }
    }

    fun getMovies(page: Int): LiveData<List<MovieEntity>>{
        val allmoview: MutableLiveData<List<MovieEntity>> = MutableLiveData()
        EspressoIdlingResource.increment()
        myApiClient.getAllMovie(page).enqueue(
            object : Callback<MoviesResponse>{
                override fun onResponse(
                    call: Call<MoviesResponse>,
                    response: Response<MoviesResponse>
                ) {
                    response.body()?.let {
                        allmoview.postValue(it.result)
                        Log.d("myrespon",it.toString())
                       EspressoIdlingResource.decrement()
                    }
                }

                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    Log.d("LogMe",t.localizedMessage)
                }

            }
        )
        return allmoview
    }
    fun getMovieById(id: Int): LiveData<MovieEntity>{
        val movieById: MutableLiveData<MovieEntity> =  MutableLiveData()
         EspressoIdlingResource.increment()
        myApiClient.getMovieById(id).enqueue(
            object : Callback<MovieEntity>{
                override fun onResponse(call: Call<MovieEntity>, response: Response<MovieEntity>) {
                    movieById.postValue(response.body())
                    EspressoIdlingResource.decrement()
                }
                override fun onFailure(call: Call<MovieEntity>, t: Throwable) {
                    Log.d("LogMe",t.localizedMessage)
                }
            }
        )
        return movieById
    }
    fun getTvShows(page: Int): LiveData<List<TvShowEntity>>{
        val allTvShow: MutableLiveData<List<TvShowEntity>> = MutableLiveData()
        EspressoIdlingResource.increment()
        myApiClient.getAllTvShow(page).enqueue(
            object : Callback<TvShowResponse>{
                override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                    response.body()?.let { allTvShow.postValue(it.result)
                    Log.d("myrespon",it.toString())
                    }
                    EspressoIdlingResource.decrement()
                }
                override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                    Log.d("LogMe",t.localizedMessage)
                }
            }
        )
        return allTvShow
    }

    fun getTvShowById(id: Int): LiveData<TvShowEntity>{
        val tvShowById: MutableLiveData<TvShowEntity> = MutableLiveData()
         EspressoIdlingResource.increment()
        myApiClient.getTvShowById(id).enqueue(
            object : Callback<TvShowEntity>{
                override fun onResponse(
                    call: Call<TvShowEntity>,
                    response: Response<TvShowEntity>
                ) {
                    tvShowById.postValue((response.body()))
                    EspressoIdlingResource.decrement()
                }
                override fun onFailure(call: Call<TvShowEntity>, t: Throwable) {
                    Log.d("LogMe",t.localizedMessage)
                }

            }
        )
        return tvShowById
    }
}