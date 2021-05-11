package com.mov.moviecatalogue.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mov.moviecatalogue.R
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.databinding.FragmentTvShowBinding
import com.mov.moviecatalogue.ui.ViewModelFactory
import com.mov.moviecatalogue.ui.home.HomeActivity
import com.mov.moviecatalogue.utils.InfiniteScrollListener

class TvShowFragment : Fragment() {
    private lateinit var fragmentTvshowBinding: FragmentTvShowBinding
    private lateinit var adapter: TvShowAdapter
    private lateinit var viewModel: TvShowViewModel
    private var mTvShow: MutableList<TvShowEntity> = mutableListOf()
    private var page = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvshowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvshowBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            (activity as HomeActivity).setActionBarTitle("TvShow List")
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            adapter = TvShowAdapter()
            checkTvShow()
            fragmentTvshowBinding.rvTvshow.adapter = adapter
            fragmentTvshowBinding.rvTvshow.layoutManager = LinearLayoutManager(context)
            fragmentTvshowBinding.rvTvshow.setHasFixedSize(true)
        }
        fragmentTvshowBinding.rvTvshow.addOnScrollListener(scrollData())
    }

    private fun checkTvShow() {
        fragmentTvshowBinding.progressBarM.start()
        fragmentTvshowBinding.progressBarM.loadingColor = R.color.black
        viewModel.page = page
        viewModel.getTvshows().observe(viewLifecycleOwner, { tv ->
            mTvShow.addAll(tv)
            adapter.setTvshow(mTvShow)
            fragmentTvshowBinding.progressBarM.stop()
        })

    }

    private fun scrollData(): InfiniteScrollListener {
        return object : InfiniteScrollListener() {
            override fun onLoadMore() {
                page += 1
                checkTvShow()
            }
        }
    }
}