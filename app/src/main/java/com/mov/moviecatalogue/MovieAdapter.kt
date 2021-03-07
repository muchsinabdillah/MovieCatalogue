package com.mov.moviecatalogue

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mov.moviecatalogue.data.MovieEntity
import com.mov.moviecatalogue.databinding.ItemsMovieBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MoviewViewHolder>() {
    private var listMovie = ArrayList<MovieEntity>()

    fun setMoview(movie: List<MovieEntity>?) {
        if (movie == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movie)
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
        fun bind(movie: MovieEntity) {
            with(binding) {
                mvItemTitle.text = movie.title
                mvGenre.text = movie.genre
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    val datamovie = MovieEntity(movie.movieId,movie.title,movie.genre,movie.headline,movie.overview,movie.imagePath)
                    intent.putExtra(DetailMovieActivity.EXTRA_TVSHOW, datamovie)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movie.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }

}