package com.mov.moviecatalogue

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.mov.moviecatalogue.data.MovieEntity
import com.mov.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.mov.moviecatalogue.databinding.ContentDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }
    private lateinit var detailContentBinding: ContentDetailMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)
        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val person = intent.getParcelableExtra<MovieEntity>(EXTRA_TVSHOW)
        detailContentBinding.textTitle.text = person?.title
        detailContentBinding.textGenre.text =person?.genre
        detailContentBinding.textHeadline.text = person?.headline
        detailContentBinding.textDescription.text = person?.overview
        Glide.with(this)
            .load(person?.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailContentBinding.imagePoster)

    }
}