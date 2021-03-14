package com.mov.moviecatalogue.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.databinding.FragmentMovieBinding
import com.mov.moviecatalogue.ui.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {
    private  lateinit var fragmentMovieBinding: FragmentMovieBinding
    private lateinit var adapter: MovieAdapter
    private lateinit var viewModel: MovieViewModel
    private var mMovies: MutableList<MovieEntity> = mutableListOf()
    private var page = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(activity != null) {
            viewModel = obtainViewModel(requireActivity())
            adapter = MovieAdapter()
            fragmentMovieBinding.progressBar.visibility = View.VISIBLE
            viewModel.page = page

            viewModel.getMovies().observe(viewLifecycleOwner, Observer { movies ->
                Log.d("myresponada",movies.toString())
                mMovies.addAll(movies)
                adapter.setMovies(mMovies)
                fragmentMovieBinding.progressBar.visibility = View.INVISIBLE
            })
            rv_movie.adapter = adapter
            rv_movie.layoutManager = LinearLayoutManager(context)
            rv_movie.setHasFixedSize(true)

        }

    }
    private fun obtainViewModel(activity: FragmentActivity): MovieViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(MovieViewModel::class.java)
    }
}