package com.herisand.submissionjp.ui.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.herisand.submissionjp.datafile.source.local.entity.TvData
import com.herisand.submissionjp.databinding.ItemsTvshowsBinding
import com.herisand.submissionjp.utils.network.ApiConfig
import com.herisand.submissionjp.utils.year

class TvAdapter: RecyclerView.Adapter<TvAdapter.ListViewHolder>() {

    private var listTvShow = ArrayList<TvData>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setTvShow(tvShows: List<TvData>?) {
        if (tvShows.isNullOrEmpty()) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShows)
    }

    inner class ListViewHolder(private val binding: ItemsTvshowsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvData : TvData) {
            binding.apply {
                tvTitletv.text = tvData.title
                tvYeartv.text = tvData.date.year()
                ratTv.rating = (tvData.scores.div(2)).toFloat()

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(tvData.id.toString())
                }

                Glide.with(itemView.context)
                    .load(ApiConfig.IMG_URL + tvData.image)
                    .apply(RequestOptions().override(220, 330))
                    .into(imgPostertv)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemsTvshowsBinding = ItemsTvshowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemsTvshowsBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val tvshows = listTvShow[position]
        holder.bind(tvshows)
    }

    override fun getItemCount(): Int = listTvShow.size

    interface OnItemClickCallback{
        fun onItemClicked(id: String)
    }
}