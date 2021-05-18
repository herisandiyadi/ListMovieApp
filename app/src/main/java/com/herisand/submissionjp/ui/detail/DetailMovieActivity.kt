package com.herisand.submissionjp.ui.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.herisand.submissionjp.datafile.source.local.entity.DetailData
import com.herisand.submissionjp.databinding.ActivityDetailMovieBinding
import com.herisand.submissionjp.databinding.ContentDetailBinding
import com.herisand.submissionjp.utils.network.ApiConfig
import com.herisand.submissionjp.utils.year
import com.herisand.submissionjp.viewmodel.DetailViewModel
import com.herisand.submissionjp.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailBinding: ContentDetailBinding
    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailBinding = ContentDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras !=null) {
            val extrasID = extras.getString(EXTRA_DATA)
            val extrasMovies = extras.getString(EXTRA_MOVIE)

            if (extrasID!=null && extrasMovies != null) {
                true.progressBar()
                true.contentView()
                viewModel.setDetailContent(extrasID, extrasMovies)
                viewModel.getDetailContent().observe(this, { detailData ->
                    false.progressBar()
                    false.contentView()
                    populateDetailMovie(detailData)
                })
            }

        }
    }

    @SuppressLint("NewApi")
    private fun populateDetailMovie(detailData: DetailData) {
        val genre = detailData.genres.toString()
            .replace("[", "")
            .replace("]", "")

        supportActionBar?.title = detailData.title
        detailBinding.tvTitleDetail.text = detailData.title
        detailBinding.tvYearDetail.text = detailData.date.year()
        detailBinding.tvDescriptionDetail.text = detailData.description
        detailBinding.ratDetail.rating = (detailData.scores.div(2)).toFloat()
        detailBinding.tvGenreDetail.text = genre

        Glide.with(this)
            .load(ApiConfig.IMG_URL + detailData.background)
            .centerCrop()
            .into(detailBinding.bgImg)

        Glide.with(this)
            .load(ApiConfig.IMG_URL + detailData.image)
            .transform(RoundedCorners(20))
            .into(detailBinding.imgDetail)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }

    fun Boolean.progressBar() {
        detailBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }

    fun Boolean.contentView() {
        activityDetailMovieBinding.content.visibility = if (this) View.VISIBLE else View.INVISIBLE
    }

}

