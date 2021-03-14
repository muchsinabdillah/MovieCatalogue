package com.mov.moviecatalogue.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mov.moviecatalogue.databinding.FragmentTvShowBinding


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
            val viewmodel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
            val tvshows = viewmodel.getTvshows()
            val tvshowadapter = TvShowAdapter()
            tvshowadapter.setTvshow(tvshows)
            with(fragmentTvshowBinding.rvTvshow) {
                layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvshowadapter
            }
        }

    }

}