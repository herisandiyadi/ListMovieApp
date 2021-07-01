package com.herisand.submissionjp.ui.tvshows

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


class TvAdapter: PagedListAdapter<TvEntity, TvAdapter.ListViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvEntity>(){
            override fun areItemsTheSame(oldItem: TvEntity, newItem: TvEntity): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: TvEntity, newItem: TvEntity): Boolean =
                oldItem == newItem

        }
    }

    inner class ListViewHolder(private val binding: ItemsTvshowsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvData: TvEntity) {
            binding.apply {
                tvTitletv.text = tvData.title
                tvYeartv.text = tvData.date.year()
                ratTv.rating = (tvData.scores.div(2)).toFloat()

                Glide.with(itemView.context)
                    .load(ApiConfig.IMG_URL + tvData.image)
                    .apply(RequestOptions().override(220, 330))
                    .into(imgPostertv)


                itemView.setOnClickListener {
                    Intent(itemView.context, DetailActivity::class.java).also {
                        it.putExtra(DetailActivity.EXTRAS_DATA, tvData.id)
                        it.putExtra(DetailActivity.EXTRAS_CHOOSE, "TV_SHOW")
                        itemView.context.startActivity(it)
                    }
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemsTvshowsBinding =
            ItemsTvshowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemsTvshowsBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val tvshows = getItem(position)
        if (tvshows !=null) holder.bind(tvshows)
    }

}