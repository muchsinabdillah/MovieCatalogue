package com.mov.moviecatalogue

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.mov.moviecatalogue.data.model.ContentId
import com.mov.moviecatalogue.data.model.TvShowEntity
import com.mov.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.mov.moviecatalogue.databinding.ContentDetailTvshowBinding
import com.mov.moviecatalogue.ui.ViewModelFactory
import com.mov.moviecatalogue.ui.tvshow.DetailTvShowViewModel
import com.mov.moviecatalogue.utils.UtilsConstanta
import kotlinx.android.synthetic.main.content_detail_tvshow.*
import java.text.SimpleDateFormat
import java.util.*

class DetailTvShow : AppCompatActivity() {
    companion object {
        const val EXTRA_TVSHOW  = "x"
    }
    private var tvShowId: Int = 0
    private lateinit var TvShowEntity: TvShowEntity
    private lateinit var detailContentBinding: ContentDetailTvshowBinding
    private lateinit var viewModel: DetailTvShowViewModel
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvShowId = intent.getIntExtra("tvShowId",0)
        val activityDetailTvshowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailTvshowBinding.detailContent
        setContentView(activityDetailTvshowBinding.root)
        setSupportActionBar(activityDetailTvshowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailContentBinding.tvdetilProgressBar.visibility = View.VISIBLE
        val TvId = intent.getParcelableExtra<ContentId>(EXTRA_TVSHOW)

        viewModel = obtainViewModel(this)
        viewModel.tvShowId = TvId!!.id

        viewModel.getTvShow().observe(this, Observer { tv ->
            TvShowEntity = tv
            var date: Date? = null
            var formatter = SimpleDateFormat("yyyy-MM-dd")
            date = formatter.parse(TvShowEntity.firstAirDate)
            formatter = SimpleDateFormat("dd-MM-yyyy")
            detailContentBinding.tvdetilTextTitle.text = TvShowEntity.title
            detailContentBinding.tvdetilTextReleaseMovie.text = formatter.format(date)
            detailContentBinding.tvdetilTextTagLine.text = ""
            detailContentBinding.tvdetilTextDescription.text = TvShowEntity.description
            tvdetil_ratingBar.numStars = 5
            val dividetwo : Float = tv.rating/2
            tvdetil_ratingBar.rating = dividetwo
            tvdetil_ratingBar.stepSize = .5f
            Glide.with(this)
                .load(UtilsConstanta.IMG_URL + TvShowEntity.poster)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(detailContentBinding.tvdetilImagePoster)

            Glide.with(this)
                .load(UtilsConstanta.IMG_URL + TvShowEntity.backdrop)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.tvdetilImageBackdrop)

            detailContentBinding.tvdetilProgressBar.visibility = View.INVISIBLE

        })
    }

    private fun obtainViewModel(activity: DetailTvShow): DetailTvShowViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(DetailTvShowViewModel::class.java)
    }
}