package com.herisand.submissionjp.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.herisand.submissionjp.databinding.FragmentMovieBinding
import com.herisand.submissionjp.resources.Status
import com.herisand.submissionjp.viewmodel.MovieViewModel
import com.herisand.submissionjp.viewmodel.ViewModelFactory

class MovieFragment : Fragment(){

    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var viewModel : MovieViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity !=null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            movieAdapter = MovieAdapter()

           viewModel.getMovie().observe(viewLifecycleOwner, { movie ->
               if (movie !=null) {
                   when (movie.status) {
                       Status.LOADING -> true.progressBar()
                       Status.SUCCESS -> {
                           false.progressBar()
                           with(movieAdapter) {
                               submitList(movie.data)
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
        with(fragmentMovieBinding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
            setHasFixedSize(true)
        }
    }

    private fun Boolean.progressBar() {
        fragmentMovieBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }

}


