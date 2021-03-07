package com.mov.moviecatalogue

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mov.moviecatalogue.data.MovieEntity
import com.mov.moviecatalogue.data.TvShowEntity
import com.mov.moviecatalogue.databinding.ItemsTvshowBinding

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var listTvshow = ArrayList<TvShowEntity>()

    fun setTvshow(tvshow: List<TvShowEntity>?) {
        if (tvshow == null) return
        this.listTvshow.clear()
        this.listTvshow.addAll(tvshow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsTvShowBinding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvshow2 = listTvshow[position]
        holder.bind(tvshow2)
    }

    override fun getItemCount(): Int = listTvshow.size

    class TvShowViewHolder(private val binding: ItemsTvshowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvshow: TvShowEntity) {
            with(binding) {
                tvItemTitle.text = tvshow.title
                tvGenre.text = tvshow.genre
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    val datamovie = MovieEntity(tvshow.movieId,tvshow.title,tvshow.genre,tvshow.headline,tvshow.overview,tvshow.imagePath)
                    intent.putExtra(DetailMovieActivity.EXTRA_TVSHOW, datamovie)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tvshow.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }

}