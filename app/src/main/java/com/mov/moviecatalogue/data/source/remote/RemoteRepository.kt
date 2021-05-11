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
        fun getInstance(): RemoteRepository {
            return RemoteRepository()
        }
    }

    fun getMovies(page: Int): LiveData<List<MovieEntity>> {
        val muviesResult: MutableLiveData<List<MovieEntity>> = MutableLiveData()
        EspressoIdlingResource.increment()
        myApiClient.getAllMovie(page).enqueue(
            object : Callback<MoviesResponse> {
                override fun onResponse(
                    call: Call<MoviesResponse>,
                    response: Response<MoviesResponse>
                ) {
                    muviesResult.value = response.body()?.result as List<MovieEntity>
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    Log.e("RemoteDataSource", "getMovies onFailure : ${t.message}")
                    EspressoIdlingResource.decrement()
                }
            }
        )
        return muviesResult
    }


    fun getMovieById(id: Int): LiveData<MovieEntity> {
        EspressoIdlingResource.increment()
        val resultmovieById: MutableLiveData<MovieEntity> = MutableLiveData()
        myApiClient.getMovieById(id).enqueue(
            object : Callback<MovieEntity> {
                override fun onResponse(call: Call<MovieEntity>, response: Response<MovieEntity>) {
                    resultmovieById.postValue(response.body())
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MovieEntity>, t: Throwable) {
                    Log.d("LogMe", t.localizedMessage)
                }
            }
        )
        return resultmovieById
    }

    fun getTvShows(page: Int): LiveData<List<TvShowEntity>> {
        val allTvShow: MutableLiveData<List<TvShowEntity>> = MutableLiveData()
        EspressoIdlingResource.increment()
        myApiClient.getAllTvShow(page).enqueue(
            object : Callback<TvShowResponse> {
                override fun onResponse(
                    call: Call<TvShowResponse>,
                    response: Response<TvShowResponse>
                ) {
                    response.body()?.let {
                        allTvShow.postValue(it.result)
                        Log.d("myrespon", it.toString())
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                    Log.d("LogMe", t.localizedMessage)
                }
            }
        )
        return allTvShow
    }

    fun getTvShowById(id: Int): LiveData<TvShowEntity> {
        val tvShowById: MutableLiveData<TvShowEntity> = MutableLiveData()
        EspressoIdlingResource.increment()
        myApiClient.getTvShowById(id).enqueue(
            object : Callback<TvShowEntity> {
                override fun onResponse(
                    call: Call<TvShowEntity>,
                    response: Response<TvShowEntity>
                ) {
                    tvShowById.postValue((response.body()))
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvShowEntity>, t: Throwable) {
                    Log.d("LogMe", t.localizedMessage)
                }

            }
        )
        return tvShowById
    }
}