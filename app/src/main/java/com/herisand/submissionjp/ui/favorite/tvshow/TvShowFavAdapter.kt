package com.herisand.submissionjp.ui.favorite.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.herisand.submissionjp.databinding.ItemsTvshowsBinding
import com.herisand.submissionjp.datafile.source.local.entity.TvEntity
import com.herisand.submissionjp.ui.detail.DetailActivity
import com.herisand.submissionjp.utils.network.ApiConfig
import com.herisand.submissionjp.utils.year

class TvShowFavAdapter : PagedListAdapter<TvEntity, TvShowFavAdapter.ListViewHolder>(DIFF_CALLBACK) {

    inner class ListViewHolder(private val binding: ItemsTvshowsBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(tvEntity: TvEntity) {
            binding.apply {
                tvTitletv.text = tvEntity.title
                tvYeartv.text = tvEntity.date.year()
                ratTv.rating = (tvEntity.scores.div(2)).toFloat()

                Glide.with(itemView.context)
                    .load(ApiConfig.IMG_URL + tvEntity.image)
                    .apply(RequestOptions().override(220, 330))
                    .into(imgPostertv)

                itemView.setOnClickListener {
                    Intent(itemView.context, DetailActivity::class.java).also {
                        it.putExtra(DetailActivity.EXTRAS_DATA, tvEntity.id)
                        it.putExtra(DetailActivity.EXTRAS_CHOOSE, "TV_SHOW")
                        itemView.context.startActivity(it)
                    }
                }
            }
        }
    }


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvEntity>() {
            override fun areItemsTheSame(oldItem: TvEntity, newItem: TvEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvEntity, newItem: TvEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = ItemsTvshowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow !=null) holder.bind(tvShow)
    }
}