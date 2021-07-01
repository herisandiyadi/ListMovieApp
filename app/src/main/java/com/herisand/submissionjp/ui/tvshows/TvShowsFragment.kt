package com.herisand.submissionjp.ui.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.herisand.submissionjp.databinding.FragmentTvShowsBinding
import com.herisand.submissionjp.resources.Status
import com.herisand.submissionjp.viewmodel.TvShowViewModel
import com.herisand.submissionjp.viewmodel.ViewModelFactory

class TvShowsFragment : Fragment() {

    private lateinit var fragmentTvShowsBinding: FragmentTvShowsBinding
    private lateinit var tvAdapter : TvAdapter
    private lateinit var viewModel : TvShowViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        fragmentTvShowsBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity !=null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            tvAdapter = TvAdapter()

            viewModel.getTvShow().observe(viewLifecycleOwner, { tvshow ->
                if (tvshow != null) {
                    when (tvshow.status) {
                        Status.LOADING -> true.progressBar()
                        Status.SUCCESS -> {
                            false.progressBar()
                            with(tvAdapter) {
                                submitList(tvshow.data)
                            }
                        }
                        Status.ERROR -> {
                            false.progressBar()
                            Toast.makeText(context, "Data gagal dimuat",
                            Toast.LENGTH_LONG).show()
                        }
                    }
                }
            })
            setRecyclerView()
        }
    }

    private fun setRecyclerView() {
        with(fragmentTvShowsBinding.rvTvshows) {
            layoutManager = LinearLayoutManager(context)
            adapter = tvAdapter
            setHasFixedSize(true)
        }
    }

    private fun Boolean.progressBar() {
        fragmentTvShowsBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }

}