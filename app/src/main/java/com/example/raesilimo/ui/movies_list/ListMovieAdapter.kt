package com.example.raesilimo.ui.movies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.raesilimo.AppClass
import com.example.raesilimo.R
import com.example.raesilimo.model.MovieResponse
import javax.inject.Inject

class ListMovieAdapter(inputMovieResponse: MovieResponse) :
    RecyclerView.Adapter<ListMovieAdapter.MovieRowViewHolder>() {

    private var movieResponse = inputMovieResponse

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRowViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_movie_item, parent, false)
        return MovieRowViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieRowViewHolder, position: Int) {

        Glide.with(holder.movieTitle.context).load(movieResponse.search.get(position).poster)
            .into(holder.movieCover)
        holder.movieTitle.setText(movieResponse.search.get(position).title)
        holder.movieGenre.setText(movieResponse.search.get(position).year)
        holder.movieCover.setOnClickListener(View.OnClickListener {
            var detailsBundle = Bundle()
            detailsBundle.putString("movieId", movieResponse.search.get(position).imdbID)
            val navController = Navigation.findNavController(holder.movieCover)
            navController!!.navigate(
                R.id.action_listMoviesFragment_to_detailsMovieFragment,
                detailsBundle
            )
        })
    }

    override fun getItemCount(): Int {
        return movieResponse.search.size
    }

    class MovieRowViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        var movieCover: ImageView = itemView.findViewById(R.id.row_movie_cover)
        var movieTitle: TextView = itemView.findViewById(R.id.row_movie_title)
        var movieGenre: TextView = itemView.findViewById(R.id.row_movie_genre)

    }
}