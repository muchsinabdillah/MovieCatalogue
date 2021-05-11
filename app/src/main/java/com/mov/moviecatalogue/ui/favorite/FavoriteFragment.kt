package com.mov.moviecatalogue.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.mov.moviecatalogue.R
import com.mov.moviecatalogue.databinding.FragmentFavoriteBinding
import com.mov.moviecatalogue.ui.favorite.movie.MovieFavoriteFragment
import com.mov.moviecatalogue.ui.favorite.tvshow.TvShowFavoriteFragment
import com.mov.moviecatalogue.ui.home.HomeActivity
import com.mov.moviecatalogue.ui.home.SectionsPagerAdapter

class FavoriteFragment : Fragment() {

    private var _fragmentFavoriteBinding: FragmentFavoriteBinding? = null
    private val binding get() = _fragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavoriteBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentList = listOf(MovieFavoriteFragment(), TvShowFavoriteFragment())
        val tabTitle =
            listOf(resources.getString(R.string.movie), resources.getString(R.string.tv_show))
        (activity as HomeActivity).setActionBarTitle("Favorites List")
        binding?.viewpager?.adapter =
            SectionsPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        TabLayoutMediator(binding!!.tabLayout2, binding!!.viewpager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentFavoriteBinding = null
    }
}