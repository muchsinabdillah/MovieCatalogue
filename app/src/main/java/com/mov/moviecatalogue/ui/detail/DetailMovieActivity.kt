package com.mov.moviecatalogue.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.mov.moviecatalogue.R
import com.mov.moviecatalogue.data.model.ContentId
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.mov.moviecatalogue.databinding.ContentDetailMovieBinding
import com.mov.moviecatalogue.ui.ViewModelFactory
import com.mov.moviecatalogue.ui.movie.DetailMovieViewModel
import com.mov.moviecatalogue.utils.UtilsConstanta
import kotlinx.android.synthetic.main.content_detail_movie.*
import java.text.SimpleDateFormat
import java.util.*

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TVSHOW  = "x"
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
        detailContentBinding = activityDetailMovieBinding.detailContent
        setContentView(activityDetailMovieBinding.root)
        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailContentBinding.progressBar.visibility = View.VISIBLE
        val mvId  = intent.getParcelableExtra<ContentId>(EXTRA_TVSHOW)

        viewModel = obtainViewModel(this)
        viewModel.movieId = mvId!!.id

        viewModel.getMovie().observe(this, Observer { movie ->
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

            ratingBar.numStars = 5
            val dividetwo : Float = movie.vote/2
            ratingBar.rating = dividetwo
            ratingBar.stepSize =  .5f

            Glide.with(this)
                .load(UtilsConstanta.IMG_URL + MovieEntities.poster)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster)
            Glide.with(this)
                .load(UtilsConstanta.IMG_URL + MovieEntities.backdrop)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imageBackdrop)
            detailContentBinding.progressBar.visibility = View.INVISIBLE
        })



    }
    private fun obtainViewModel(activity: DetailMovieActivity): DetailMovieViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(DetailMovieViewModel::class.java)
    }

}