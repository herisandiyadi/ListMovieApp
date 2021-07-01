package com.herisand.submissionjp.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.herisand.submissionjp.databinding.ItemsMovieBinding
import com.herisand.submissionjp.datafile.source.local.entity.MovieEntity
import com.herisand.submissionjp.ui.detail.DetailActivity
import com.herisand.submissionjp.utils.network.ApiConfig
import com.herisand.submissionjp.utils.year


class MovieAdapter:  PagedListAdapter<MovieEntity, MovieAdapter.ListViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
                oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
                oldItem == newItem

        }
    }

    inner class ListViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            binding.apply {
                tvTitle.text = movie.title
                tvYear.text = movie.date.year()
                ratMovie.rating = (movie.scores.div(2)).toFloat()

                Glide.with(itemView.context)
                    .load(ApiConfig.IMG_URL + movie.image)
                    .apply(RequestOptions().override(220, 330))
                    .into(imgPoster)

                itemView.setOnClickListener {
                    Intent(itemView.context, DetailActivity::class.java).also {
                        it.putExtra(DetailActivity.EXTRAS_DATA, movie.id)
                        it.putExtra(DetailActivity.EXTRAS_CHOOSE, "MOVIE")
                        itemView.context.startActivity(it)
                    }
                }

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemsMovieBinding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) holder.bind(movie)
    }
}
