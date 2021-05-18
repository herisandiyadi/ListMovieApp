package com.herisand.submissionjp.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.herisand.submissionjp.datafile.source.local.entity.MovieData
import com.herisand.submissionjp.databinding.ItemsMovieBinding
import com.herisand.submissionjp.utils.network.ApiConfig
import com.herisand.submissionjp.utils.year


class MovieAdapter: RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    private var listMovie = ArrayList<MovieData>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setMovies(movies: List<MovieData>?) {
        if (movies.isNullOrEmpty()) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
    }

    inner class ListViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieData) {
            binding.apply {
                tvTitle.text = movie.title
                tvYear.text = movie.date.year()
                ratMovie.rating = (movie.scores.div(2)).toFloat()

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(movie.id.toString())
                }

                Glide.with(itemView.context)
                    .load(ApiConfig.IMG_URL + movie.image)
                    .apply(RequestOptions().override(220, 330))
                    .into(imgPoster)

            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemsMovieBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size

    interface OnItemClickCallback{
        fun onItemClicked(id: String)
    }
}