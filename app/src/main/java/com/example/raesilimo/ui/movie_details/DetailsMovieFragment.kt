package com.example.raesilimo.ui.movie_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.raesilimo.R
import com.example.raesilimo.model.MovieDetails
import com.example.raesilimo.repository.network.NetworkResult
import com.example.raesilimo.ui.movies_list.ListMovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsMovieFragment : Fragment() {
    private val viewModel: DetailsMovieViewModel by viewModels()
    private lateinit var movieId: String
    private lateinit var mMovieCover : ImageView
    private lateinit var mMovieTitle : TextView
    private lateinit var mMovieRate : TextView
    private lateinit var mMovieGenre : TextView
    private lateinit var mMovieTime : TextView
    private lateinit var mMovieDirector : TextView
    private lateinit var mMovieDescription : TextView
    private lateinit var mProgressbar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (arguments != null) {
                movieId = it.getString("movieId").toString()
                viewModel.getMovieDetails(movieId)
            } else {
                TODO("Must back to list page")
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details_movie, container, false)
        findViews(view)

        viewModel.movieDetailsResponse.observe(viewLifecycleOwner,
            Observer { movieResponseNetworkResult ->
                when (movieResponseNetworkResult) {
                    is NetworkResult.Success -> {
                        var movieDetail : MovieDetails = movieResponseNetworkResult.data!!
                        setupView(movieDetail)
                    }
                    is NetworkResult.Error -> {
                        // show error message
                    }
                    is NetworkResult.Loading -> {
                        // show a progress bar
                    }
                }

            })

        return view
    }

    private fun findViews(view: View) {
        mMovieCover = view.findViewById(R.id.movie_cover)
        mMovieTitle = view.findViewById(R.id.movie_title)
        mMovieRate = view.findViewById(R.id.movie_rate)
        mMovieGenre = view.findViewById(R.id.movie_genre)
        mMovieTime = view.findViewById(R.id.movie_time)
        mMovieDirector = view.findViewById(R.id.movie_director)
        mMovieDescription = view.findViewById(R.id.movie_description)
        mProgressbar = view.findViewById(R.id.details_progress_bar)
    }

    private fun setupView(movieDetail: MovieDetails) {
        context?.let { Glide.with(it).load(movieDetail.poster).into(mMovieCover) }
        mMovieTitle.setText(movieDetail.title)
        mMovieGenre.setText(movieDetail.genre)
        mMovieTime.setText(movieDetail.runtime)
        mMovieRate.setText(movieDetail.imdbRating)
        mMovieDirector.setText(movieDetail.director)
        mMovieDescription.setText(movieDetail.plot)
        mProgressbar.visibility = View.GONE
    }

}