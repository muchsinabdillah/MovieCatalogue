package com.mov.moviecatalogue.ui.tvshow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.databinding.FragmentMovieBinding
import com.mov.moviecatalogue.databinding.FragmentTvShowBinding
import com.mov.moviecatalogue.ui.ViewModelFactory
import com.mov.moviecatalogue.ui.movie.MovieAdapter
import com.mov.moviecatalogue.ui.movie.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_tv_show.*


class TvShowFragment : Fragment() {
    private  lateinit var fragmentTvshowBinding: FragmentTvShowBinding
    private lateinit var adapter: TvShowAdapter
    private lateinit var viewModel: TvShowViewModel
    private var mTvShow: MutableList<TvShowEntity> = mutableListOf()
    private var page = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvshowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvshowBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            viewModel = obtainViewModel(requireActivity())
            adapter = TvShowAdapter()
            fragmentTvshowBinding.progressBar.visibility = View.VISIBLE
            viewModel.page = page

            viewModel.getTvshows().observe(viewLifecycleOwner, Observer { tv ->
                Log.d("myresponada",tv.toString())
                mTvShow.addAll(tv)
                adapter.setTvshow(mTvShow)
                fragmentTvshowBinding.progressBar.visibility = View.INVISIBLE
            })
            rv_tvshow.adapter = adapter
            rv_tvshow.layoutManager = LinearLayoutManager(context)
            rv_tvshow.setHasFixedSize(true)
        }
    }
    private fun obtainViewModel(activity: FragmentActivity): TvShowViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(TvShowViewModel::class.java)
    }
}