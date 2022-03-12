package com.example.raesilimo.ui.movies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.raesilimo.R
import com.example.raesilimo.model.MovieResponse
import com.example.raesilimo.data.network.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
/**Fragment for indicating list of all movies that get a movies list from
 * provided method in it's view model*/
@AndroidEntryPoint
class ListMoviesFragment : Fragment() {

    private val viewModel: ListMoviesViewModel by viewModels()
    lateinit var mMoviesRecyclerView: RecyclerView
    lateinit var mProgressBar: ProgressBar
    lateinit var movieResponse: MovieResponse
    private lateinit var mMovieAdapter: ListMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_movies, container, false)
        findViews(view)
        setObservers()
        return view
    }

    private fun setRecyclerView() {
        mMoviesRecyclerView.apply {
            this.layoutManager = LinearLayoutManager(activity)
            this.adapter = mMovieAdapter
        }
    }

    private fun findViews(view: View) {
        mMoviesRecyclerView = view.findViewById(R.id.movies_list)
        mProgressBar = view.findViewById(R.id.details_progress_bar)
    }

    private fun setObservers() {
        viewModel.moviesListCallResult.observe(
            viewLifecycleOwner,
            Observer { movieResponseNetworkResult ->
                mMovieAdapter = ListMovieAdapter(movieResponseNetworkResult)
                setRecyclerView()
                mProgressBar.visibility = View.GONE
//                when (movieResponseNetworkResult) {
//                    is NetworkResult.Success -> {
//                        mMovieAdapter = movieResponseNetworkResult.data?.let { ListMovieAdapter(it) }!!
//                        setRecyclerView()
//                        mProgressBar.visibility = View.GONE
//                    }
//                    is NetworkResult.Error -> {
//                        // show error message
//                    }
//                    is NetworkResult.Loading -> {
//                        // show a progress bar
//                    }
//                }

            })
    }

}