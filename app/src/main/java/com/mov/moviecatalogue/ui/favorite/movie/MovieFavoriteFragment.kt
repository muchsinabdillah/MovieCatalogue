package com.mov.moviecatalogue.ui.favorite.movie

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mov.moviecatalogue.R
import com.mov.moviecatalogue.databinding.FragmentMovieFavoriteBinding
import com.mov.moviecatalogue.ui.ViewModelFactory
import com.mov.moviecatalogue.ui.favorite.FavoriteMovieViewModel
import com.mov.moviecatalogue.utils.MarginItemDecoration

class MovieFavoriteFragment : Fragment() {
    private lateinit var movieFavoriteBinding: FragmentMovieFavoriteBinding
    private lateinit var adapter: MovieFavoriteAdapter
    private lateinit var viewModel: FavoriteMovieViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        movieFavoriteBinding =
            FragmentMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return movieFavoriteBinding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        itemTouchHelper.attachToRecyclerView(movieFavoriteBinding.rvMovieFav)
        movieFavoriteBinding.progressBar.start()
        movieFavoriteBinding.progressBar.loadingColor = R.color.black
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]
            adapter = MovieFavoriteAdapter()
            viewModel.getFavoriteMovies().observe(viewLifecycleOwner, { favmovies ->
                if (favmovies != null) {
                    adapter.submitList(favmovies)
                    movieFavoriteBinding.progressBar.stop()
                }
            })
            val marginVertical = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                16f,
                resources.displayMetrics
            )
            movieFavoriteBinding.rvMovieFav.addItemDecoration(MarginItemDecoration(marginVertical.toInt()))
            movieFavoriteBinding.rvMovieFav.layoutManager = LinearLayoutManager(context)
            movieFavoriteBinding.rvMovieFav.setHasFixedSize(true)
            movieFavoriteBinding.rvMovieFav.adapter = adapter

        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvShowEntity = adapter.getSwipedData(swipedPosition)
                tvShowEntity?.let { viewModel.deleteFavoriteM(it) }

                val snackBar = Snackbar.make(requireView(), R.string.undo, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.undo) { _ ->
                    tvShowEntity?.let { viewModel.insertFavoriteM(it) }
                }
                snackBar.show()
            }
        }
    })

}