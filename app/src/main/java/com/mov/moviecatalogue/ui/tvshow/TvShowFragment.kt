package com.mov.moviecatalogue.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mov.moviecatalogue.MovieAdapter
import com.mov.moviecatalogue.R
import com.mov.moviecatalogue.TvShowAdapter
import com.mov.moviecatalogue.TvShowFragmentCallback
import com.mov.moviecatalogue.databinding.FragmentMovieBinding
import com.mov.moviecatalogue.databinding.FragmentTvShowBinding
import com.mov.moviecatalogue.databinding.ItemsTvshowBinding
import com.mov.moviecatalogue.utils.DataDummy

class TvShowFragment : Fragment() {
    private  lateinit var fragmentTvshowBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvshowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvshowBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val tvshow = DataDummy.generateDummyTvShow()
            val tvshowadapter = TvShowAdapter()
            tvshowadapter.setTvshow(tvshow)
            with(fragmentTvshowBinding.rvTvshow) {
                layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvshowadapter
            }
        }
    }

}