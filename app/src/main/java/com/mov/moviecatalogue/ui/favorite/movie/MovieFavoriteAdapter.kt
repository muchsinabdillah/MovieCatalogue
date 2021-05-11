package com.mov.moviecatalogue.ui.favorite.movie

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mov.moviecatalogue.R
import com.mov.moviecatalogue.data.model.ContentId
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.databinding.ItemsMovieBinding
import com.mov.moviecatalogue.ui.detail.DetailMovieActivity
import com.mov.moviecatalogue.utils.UtilsConstanta
import java.text.SimpleDateFormat
import java.util.*

class MovieFavoriteAdapter :
    PagedListAdapter<MovieEntity, MovieFavoriteAdapter.MoviewFavoriteViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviewFavoriteViewHolder {
        val itemsMovieBinding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviewFavoriteViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MoviewFavoriteViewHolder, position: Int) {
        val course = getItem(position)
        if (course != null) {
            holder.bind(course)
        }
    }

    fun getSwipedData(swipedPosition: Int): MovieEntity? = getItem(swipedPosition)

    class MoviewFavoriteViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SimpleDateFormat")
        fun bind(movie: MovieEntity) {
            with(binding) {
                mvItemTitle.text = movie.title
                var date: Date? = null
                var formatter = SimpleDateFormat("yyyy-MM-dd")
                date = formatter.parse(movie.releaseDate)
                formatter = SimpleDateFormat("dd-MM-yyyy")
                mvGenre.text = formatter.format(date)
                mvRating.numStars = 5
                val dividetwo: Float = movie.vote / 2
                mvRating.rating = dividetwo
                mvRating.stepSize = .5f


                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    val contentID = ContentId(movie.id)
                    intent.putExtra(DetailMovieActivity.EXTRA_TVSHOW, contentID)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(UtilsConstanta.IMG_URL + movie.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }

}