package com.mov.moviecatalogue

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar
import com.mov.moviecatalogue.data.model.ContentId
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.mov.moviecatalogue.databinding.ContentDetailTvshowBinding
import com.mov.moviecatalogue.ui.ViewModelFactory
import com.mov.moviecatalogue.ui.tvshow.DetailTvShowViewModel
import com.mov.moviecatalogue.utils.UtilsConstanta
import java.text.SimpleDateFormat
import java.util.*

class DetailTvShow : AppCompatActivity() {
    companion object {
        const val EXTRA_TVSHOW = "x"
    }

    private var tvShowId: Int = 0
    private lateinit var TvShowEntity: TvShowEntity
    private lateinit var detailContentBinding: ContentDetailTvshowBinding
    private lateinit var viewModel: DetailTvShowViewModel

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvShowId = intent.getIntExtra("tvShowId", 0)
        val activityDetailTvshowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailTvshowBinding.detailContent
        setContentView(activityDetailTvshowBinding.root)

        detailContentBinding.tvdetilProgressBar.start()
        detailContentBinding.tvdetilProgressBar.loadingColor = R.color.black


        val TvId = intent.getParcelableExtra<ContentId>(EXTRA_TVSHOW)
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]
        viewModel.tvShowId = TvId!!.id

        viewModel.getTvShow().observe(this, { tv ->
            TvShowEntity = tv
            val date: Date?
            var formatter = SimpleDateFormat("yyyy-MM-dd")
            date = formatter.parse(TvShowEntity.firstAirDate)
            formatter = SimpleDateFormat("dd-MM-yyyy")
            detailContentBinding.tvdetilTextTitle.text = TvShowEntity.title
            detailContentBinding.tvdetilTextReleaseMovie.text = formatter.format(date)
            detailContentBinding.tvdetilTextTagLine.text = ""
            detailContentBinding.tvdetilTextDescription.text = TvShowEntity.description
            detailContentBinding.tvdetilRatingBar.numStars = 5
            val hasRating: Float = tv.rating / 2

            detailContentBinding.tvdetilRatingBar.rating = hasRating
            detailContentBinding.tvdetilRatingBar.stepSize = .5f
            Glide.with(this)
                .load(UtilsConstanta.IMG_URL + TvShowEntity.poster)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(detailContentBinding.tvdetilImagePoster)

            Glide.with(this)
                .load(UtilsConstanta.IMG_URL + TvShowEntity.backdrop)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(detailContentBinding.tvdetilImageBackdrop)

            detailContentBinding.tvdetilProgressBar.stop()
            checkFavorite()
        })
        detailContentBinding.fabFavtv.setOnClickListener { FavoriteAdd() }

    }

    private fun checkFavorite() {
        if (viewModel.isFavorited(TvShowEntity)) {
            detailContentBinding.fabFavtv.setImageResource(R.drawable.ic_tes_fav2)

        } else {
            detailContentBinding.fabFavtv.setImageResource(R.drawable.ic_tes_fav)
        }
    }

    private fun FavoriteAdd() {
        if (viewModel.isFavorited(TvShowEntity)) {
            viewModel.deleteFavorite(TvShowEntity)
            Snackbar.make(
                detailContentBinding.tvdetilProgressBar,
                getString(R.string.unfavorited, TvShowEntity.title),
                Snackbar.LENGTH_SHORT
            ).show()
            detailContentBinding.fabFavtv.setImageResource(R.drawable.ic_tes_fav)
        } else {
            viewModel.insertFavorite(TvShowEntity)
            Snackbar.make(
                detailContentBinding.tvdetilProgressBar,
                getString(R.string.favorited, TvShowEntity.title),
                Snackbar.LENGTH_SHORT
            ).show()
            detailContentBinding.fabFavtv.setImageResource(R.drawable.ic_tes_fav2)
        }
    }
}