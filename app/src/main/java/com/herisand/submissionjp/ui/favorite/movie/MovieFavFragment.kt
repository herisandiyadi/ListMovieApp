package com.herisand.submissionjp.ui.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.herisand.submissionjp.databinding.FragmentMovieFavBinding
import com.herisand.submissionjp.viewmodel.FavoriteViewModel
import com.herisand.submissionjp.viewmodel.ViewModelFactory

class MovieFavFragment : Fragment() {

    private lateinit var movieFavBinding: FragmentMovieFavBinding
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var movieFavAdapter: MovieFavAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        movieFavBinding = FragmentMovieFavBinding.inflate(layoutInflater, container, false)
        return movieFavBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            true.progressBar()

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
            movieFavAdapter = MovieFavAdapter()
            viewModel.getFavListMovie().observe(viewLifecycleOwner, {
                false.progressBar()
                movieFavAdapter.submitList(it)
            })

            movieFavBinding.rvMovieFav.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = movieFavAdapter
            }
        }
    }
    private fun Boolean.progressBar() {
        movieFavBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }
}


