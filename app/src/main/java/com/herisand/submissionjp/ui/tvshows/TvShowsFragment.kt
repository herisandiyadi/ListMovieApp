package com.herisand.submissionjp.ui.tvshows

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.herisand.submissionjp.databinding.FragmentTvShowsBinding
import com.herisand.submissionjp.ui.detail.DetailTvActivity
import com.herisand.submissionjp.viewmodel.DetailViewModel.Companion.TV_SHOW
import com.herisand.submissionjp.viewmodel.TvShowViewModel
import com.herisand.submissionjp.viewmodel.ViewModelFactory

class TvShowsFragment : Fragment(), TvAdapter.OnItemClickCallback {

    private lateinit var fragmentTvShowsBinding: FragmentTvShowsBinding
    private lateinit var tvAdapter: TvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentTvShowsBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity !=null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            tvAdapter = TvAdapter()

            fragmentTvShowsBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTvShow().observe(viewLifecycleOwner, { tvShow ->
                Log.d("data tv", tvShow.toString())
                fragmentTvShowsBinding.progressBar.visibility = View.GONE
                tvAdapter.setTvShow(tvShow)
                tvAdapter.notifyDataSetChanged()
                tvAdapter.setOnClickCallback(this@TvShowsFragment)
            })

            with(fragmentTvShowsBinding.rvTvshows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }
    }

    override fun onItemClicked(id: String) {
        Intent(context, DetailTvActivity::class.java).also {
            it.putExtra(DetailTvActivity.EXTRA_DATA, id)
            it.putExtra(DetailTvActivity.EXTRA_TV, TV_SHOW)
            context?.startActivity(it)
        }
    }
}