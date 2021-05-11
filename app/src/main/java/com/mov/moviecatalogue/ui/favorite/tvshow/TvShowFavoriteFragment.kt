package com.mov.moviecatalogue.ui.favorite.tvshow

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
import com.mov.moviecatalogue.databinding.FragmentTvShowFavoriteBinding
import com.mov.moviecatalogue.ui.ViewModelFactory
import com.mov.moviecatalogue.ui.favorite.FavoriteMovieViewModel
import com.mov.moviecatalogue.utils.MarginItemDecoration

class TvShowFavoriteFragment : Fragment() {
    private lateinit var tvshowFavoriteBinding: FragmentTvShowFavoriteBinding
    private lateinit var adapter: TvShowFavoriteAdapter
    private lateinit var viewModel: FavoriteMovieViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tvshowFavoriteBinding =
            FragmentTvShowFavoriteBinding.inflate(layoutInflater, container, false)
        return tvshowFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(tvshowFavoriteBinding.rvTvshowFav)
        tvshowFavoriteBinding.progressBar.visibility = View.VISIBLE
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]
            adapter = TvShowFavoriteAdapter()
            viewModel.getFavoriteTvShows().observe(viewLifecycleOwner, { favmovies ->
                if (favmovies != null) {
                    adapter.submitList(favmovies)
                    tvshowFavoriteBinding.progressBar.visibility = View.INVISIBLE
                }
            })
            val marginVertical = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                16f,
                resources.displayMetrics
            )
            tvshowFavoriteBinding.rvTvshowFav.addItemDecoration(MarginItemDecoration(marginVertical.toInt()))
            tvshowFavoriteBinding.rvTvshowFav.layoutManager = LinearLayoutManager(context)
            tvshowFavoriteBinding.rvTvshowFav.setHasFixedSize(true)
            tvshowFavoriteBinding.rvTvshowFav.adapter = adapter
            tvshowFavoriteBinding.progressBar.visibility = View.INVISIBLE
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
                tvShowEntity?.let { viewModel.deleteFavoriteT(it) }
                val snackBar = Snackbar.make(requireView(), R.string.undo, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.ok) { _ ->
                    tvShowEntity?.let { viewModel.insertFavoriteT(it) }
                }
                snackBar.show()
            }
        }
    })
}