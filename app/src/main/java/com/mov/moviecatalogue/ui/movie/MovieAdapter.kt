package com.mov.moviecatalogue.ui.movie

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mov.moviecatalogue.R
import com.mov.moviecatalogue.data.model.ContentId
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.databinding.ItemsMovieBinding
import com.mov.moviecatalogue.ui.detail.DetailMovieActivity
import com.mov.moviecatalogue.utils.UtilsConstanta
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MoviewViewHolder>() {
    private var listMovie: MutableList<MovieEntity> = mutableListOf()

    fun setMovies(movies: List<MovieEntity>) {
        listMovie.clear()
        listMovie.addAll(movies)
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviewViewHolder {
        val itemsMovieBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviewViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MoviewViewHolder, position: Int) {
        val course = listMovie[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listMovie.size

    class MoviewViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
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
                val dividetwo : Float = movie.vote/2
                mvRating.rating = dividetwo
                 mvRating.stepSize =  .5f


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
                                    .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }

}