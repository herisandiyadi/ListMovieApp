package com.herisand.submissionjp.ui.favorite.movie

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

class MovieFavAdapter: PagedListAdapter<MovieEntity, MovieFavAdapter.ListViewHolder>(
    DIFF_CALLBACK
) {
    inner class ListViewHolder(private val binding: ItemsMovieBinding) :
    RecyclerView.ViewHolder(binding.root){
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


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(view)
     }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie !=null) holder.bind(movie)
    }
}