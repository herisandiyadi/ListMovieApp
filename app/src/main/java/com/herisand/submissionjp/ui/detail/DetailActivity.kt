package com.herisand.submissionjp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.herisand.submissionjp.R
import com.herisand.submissionjp.databinding.ActivityDetailBinding
import com.herisand.submissionjp.datafile.source.local.entity.MovieEntity
import com.herisand.submissionjp.datafile.source.local.entity.TvEntity
import com.herisand.submissionjp.resources.Status
import com.herisand.submissionjp.utils.network.ApiConfig
import com.herisand.submissionjp.utils.year
import com.herisand.submissionjp.viewmodel.DetailViewModel
import com.herisand.submissionjp.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding
    private lateinit var detailFilmViewModel: DetailViewModel

    companion object {
        const val EXTRAS_DATA = "extras_data"
        const val EXTRAS_CHOOSE = "choose"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }

        val factory = ViewModelFactory.getInstance(this)
        detailFilmViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val receivedData = intent.getIntExtra(EXTRAS_DATA, 0)
        val filmChoose = intent.getStringExtra(EXTRAS_CHOOSE)
        if (receivedData !=0 && filmChoose != null) {
            when (filmChoose) {
                "MOVIE" -> {
                    getDataMovie(receivedData)
                }
                "TV_SHOW" -> {
                    getDataTVShow(receivedData)
                }
            }
        }
        setFavorite()
    }

    private fun getDataTVShow(tvShowId: Int) {
        detailFilmViewModel.setDetailTVShow(tvShowId).observe(this, {
            when (it.status) {
                Status.LOADING -> true.progressBar()
                Status.SUCCESS -> {
                    if (it.data !=null) {
                        false.progressBar()
                        populateDetailTVShow(it.data)
                    }
                }
                Status.ERROR -> {
                    false.progressBar()
                    Toast.makeText(applicationContext, "Data gagal dimuat", Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }

    private fun populateDetailTVShow(tvEntity: TvEntity) {

        if (supportActionBar !=null) {
            title = tvEntity.title
        }

        detailBinding.apply {
            with(tvEntity) {
                tvTitleDetail.text = tvEntity.title
                tvYearDetail.text = tvEntity.date.year()
                tvDescriptionDetail.text = tvEntity.description
                ratDetail.rating = (tvEntity.scores.div(2)).toFloat()
                btnFav.setFavoriteAnimated(favorite)

                Glide.with(this@DetailActivity)
                    .load(ApiConfig.IMG_URL + tvEntity.background)
                    .centerCrop()
                    .into(detailBinding.bgImg)

                Glide.with(this@DetailActivity)
                    .load(ApiConfig.IMG_URL + tvEntity.image)
                    .transform(RoundedCorners(20))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(detailBinding.imgDetail)
            }
        }
    }

    private fun setFavorite() {
        val contentChoose = intent.getStringExtra(EXTRAS_CHOOSE)
        if (contentChoose != null) {
            detailBinding.btnFav.setOnClickListener {
                when (contentChoose) {
                    "MOVIE" -> {
                        detailFilmViewModel.setMovieFav()
                    }
                    "TV_SHOW" -> {
                        detailFilmViewModel.setTVShowFav()
                    }
                }
            }
        }
    }

    private fun getDataMovie(movieId: Int) {
        detailFilmViewModel.setDetailMovie(movieId).observe(this, {
            when (it.status) {
                Status.LOADING -> true.progressBar()
                Status.SUCCESS -> {
                    if (it.data != null) {
                        false.progressBar()
                        populateDetailMovie(it.data)
                    }
                }
                Status.ERROR -> {
                    false.progressBar()
                    Toast.makeText(applicationContext, "Data gagal dimuat", Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }

    private fun populateDetailMovie(movieEntity: MovieEntity) {

        if (supportActionBar !=null) {
            title = movieEntity.title
        }

        detailBinding.apply {
            with(movieEntity) {
                tvTitleDetail.text = movieEntity.title
                tvYearDetail.text = movieEntity.date.year()
                tvDescriptionDetail.text = movieEntity.description
                ratDetail.rating = (movieEntity.scores.div(2)).toFloat()
                btnFav.setFavoriteAnimated(favorite)

                com.bumptech.glide.Glide.with(this@DetailActivity)
                    .load(com.herisand.submissionjp.utils.network.ApiConfig.IMG_URL + movieEntity.background)
                    .centerCrop()
                    .into(detailBinding.bgImg)

                com.bumptech.glide.Glide.with(this@DetailActivity)
                    .load(com.herisand.submissionjp.utils.network.ApiConfig.IMG_URL + movieEntity.image)
                    .transform(RoundedCorners(20))
                    .apply(
                        com.bumptech.glide.request.RequestOptions.placeholderOf(com.herisand.submissionjp.R.drawable.ic_loading)
                            .error(com.herisand.submissionjp.R.drawable.ic_error)
                    )
                    .into(detailBinding.imgDetail)

            }
        }
    }

    private fun Boolean.progressBar() {
        detailBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}


