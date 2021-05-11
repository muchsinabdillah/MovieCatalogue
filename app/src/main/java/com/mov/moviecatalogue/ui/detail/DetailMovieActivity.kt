package com.mov.moviecatalogue.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar
import com.mov.moviecatalogue.R
import com.mov.moviecatalogue.data.model.ContentId
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.mov.moviecatalogue.databinding.ContentDetailMovieBinding
import com.mov.moviecatalogue.ui.ViewModelFactory
import com.mov.moviecatalogue.ui.movie.DetailMovieViewModel
import com.mov.moviecatalogue.utils.UtilsConstanta
import java.text.SimpleDateFormat
import java.util.*

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TVSHOW = "x"
    }

    private var movieId: Int = 0
    private lateinit var MovieEntities: MovieEntity
    private lateinit var detailContentBinding: ContentDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieId = intent.getIntExtra("movieId", 0)
        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContentMovie
        setContentView(activityDetailMovieBinding.root)


        detailContentBinding.progressBar.start()
        detailContentBinding.progressBar.loadingColor = R.color.black

        val mvId = intent.getParcelableExtra<ContentId>(EXTRA_TVSHOW)
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]
        viewModel.movieId = mvId!!.id

        viewModel.getMovie().observe(this, { movie ->
            MovieEntities = movie
            var date: Date? = null
            var formatter = SimpleDateFormat("yyyy-MM-dd")
            date = formatter.parse(MovieEntities.releaseDate)
            formatter = SimpleDateFormat("dd-MM-yyyy")
            detailContentBinding.textTitle.text = MovieEntities.title
            detailContentBinding.textReleaseMovie.text = formatter.format(date)
            detailContentBinding.textStatusMovie.text = MovieEntities.status
            detailContentBinding.textTagLine.text = MovieEntities.tagline
            detailContentBinding.textDescription.text = MovieEntities.description

            detailContentBinding.ratingBar.numStars = 5
            val hasRating: Float = movie.vote / 2
            detailContentBinding.ratingBar.rating = hasRating
            detailContentBinding.ratingBar.stepSize = .5f

            Glide.with(this)
                .load(UtilsConstanta.IMG_URL + MovieEntities.poster)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(detailContentBinding.imagePoster)
            Glide.with(this)
                .load(UtilsConstanta.IMG_URL + MovieEntities.backdrop)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(detailContentBinding.imageBackdrop)
            detailContentBinding.progressBar.stop()
            checkFavorite()
        })
        detailContentBinding.fabFav.setOnClickListener { FavoriteAdd() }
    }

    private fun checkFavorite() {
        if (viewModel.isFavorited(MovieEntities)) {
            detailContentBinding.fabFav.setImageResource(R.drawable.ic_tes_fav2)

        } else {
            detailContentBinding.fabFav.setImageResource(R.drawable.ic_tes_fav)
        }
    }

    private fun FavoriteAdd() {
        if (viewModel.isFavorited(MovieEntities)) {
            viewModel.deleteFavorite(MovieEntities)
            Snackbar.make(
                detailContentBinding.progressBar,
                getString(R.string.unfavorited, MovieEntities.title),
                Snackbar.LENGTH_SHORT
            ).show()
            detailContentBinding.fabFav.setImageResource(R.drawable.ic_tes_fav)
        } else {
            viewModel.insertFavorite(MovieEntities)
            Snackbar.make(
                detailContentBinding.progressBar,
                getString(R.string.favorited, MovieEntities.title),
                Snackbar.LENGTH_SHORT
            ).show()
            detailContentBinding.fabFav.setImageResource(R.drawable.ic_tes_fav2)
        }
    }


}