package com.mov.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mov.moviecatalogue.R
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.databinding.FragmentMovieBinding
import com.mov.moviecatalogue.ui.ViewModelFactory
import com.mov.moviecatalogue.ui.home.HomeActivity
import com.mov.moviecatalogue.utils.InfiniteScrollListener

class MovieFragment : Fragment() {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private lateinit var adapter: MovieAdapter
    private lateinit var viewModel: MovieViewModel
    private var mMovies: MutableList<MovieEntity> = mutableListOf()
    private var page = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            (activity as HomeActivity).setActionBarTitle("Movies List")
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            adapter = MovieAdapter()
            loadDataMovies()
            fragmentMovieBinding.rvMovie.adapter = adapter
            fragmentMovieBinding.rvMovie.layoutManager = LinearLayoutManager(context)
            fragmentMovieBinding.rvMovie.setHasFixedSize(true)

        }

        fragmentMovieBinding.rvMovie.addOnScrollListener(scrollData())
    }

    private fun loadDataMovies() {
        fragmentMovieBinding.progressBarM.start()
        fragmentMovieBinding.progressBarM.loadingColor = R.color.black
        viewModel.page = page
        viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
            mMovies.addAll(movies)
            adapter.setMovies(mMovies)
            fragmentMovieBinding.progressBarM.stop()
        })

    }

    private fun scrollData(): InfiniteScrollListener {
        return object : InfiniteScrollListener() {
            override fun onLoadMore() {
                page += 1
                loadDataMovies()
            }
        }
    }



}