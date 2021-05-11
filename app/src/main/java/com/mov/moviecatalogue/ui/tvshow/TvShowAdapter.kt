package com.mov.moviecatalogue.ui.tvshow

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mov.moviecatalogue.DetailTvShow
import com.mov.moviecatalogue.R
import com.mov.moviecatalogue.data.model.ContentId
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.databinding.ItemsTvshowBinding
import com.mov.moviecatalogue.utils.UtilsConstanta
import java.text.SimpleDateFormat
import java.util.*

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var listTvshow: MutableList<TvShowEntity> = mutableListOf()
    fun setTvshow(tvshow: List<TvShowEntity>) {
        this.listTvshow.clear()
        this.listTvshow.addAll(tvshow)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsTvShowBinding =
            ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvshow2 = listTvshow[position]
        holder.bind(tvshow2)
    }

    override fun getItemCount(): Int = listTvshow.size

    class TvShowViewHolder(private val binding: ItemsTvshowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SimpleDateFormat")
        fun bind(tvshow: TvShowEntity) {
            with(binding) {
                tvItemTitle.text = tvshow.title
                var date: Date? = null
                var formatter = SimpleDateFormat("yyyy-MM-dd")
                date = formatter.parse(tvshow.firstAirDate)
                formatter = SimpleDateFormat("dd-MM-yyyy")
                tvGenre.text = formatter.format(date)
                mvRating.numStars = 5
                val bagidua: Float = tvshow.rating / 2
                mvRating.rating = bagidua
                mvRating.stepSize = .5f
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShow::class.java)
                    val contentID = ContentId(tvshow.id)
                    intent.putExtra(DetailTvShow.EXTRA_TVSHOW, contentID)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(UtilsConstanta.IMG_URL + tvshow.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }

    }

}