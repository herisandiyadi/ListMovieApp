package com.herisand.submissionjp.ui.favorite.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.herisand.submissionjp.databinding.FragmentTvShowFavBinding
import com.herisand.submissionjp.viewmodel.FavoriteViewModel
import com.herisand.submissionjp.viewmodel.ViewModelFactory

class TvShowFavFragment : Fragment() {

    private lateinit var tvShowFavBinding: FragmentTvShowFavBinding
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var tvShowFavAdapter: TvShowFavAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tvShowFavBinding = FragmentTvShowFavBinding.inflate(layoutInflater, container, false)
        return tvShowFavBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            true.progressBar()

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
            tvShowFavAdapter = TvShowFavAdapter()
            viewModel.getFavListTVShow().observe(viewLifecycleOwner, {
                false.progressBar()
                tvShowFavAdapter.submitList(it)
            })

            tvShowFavBinding.rvTvShowFav.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = tvShowFavAdapter
            }
        }
    }
    private fun Boolean.progressBar() {
        tvShowFavBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }
}