package com.example.detailedrecyclerview_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.PopupMenu
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.detailedrecyclerview_kotlin.R
import com.example.detailedrecyclerview_kotlin.fragment.HomeFragmentDirections
import com.example.detailedrecyclerview_kotlin.model.Movies
import com.google.android.material.snackbar.Snackbar

class MoviesAdapter(var mContext: Context, var moviesList: List<Movies>) :
    RecyclerView.Adapter<MoviesAdapter.CardViewHolder>() {

    inner class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cardViewMovie: CardView
        var imageViewMovie: ImageView
        var textViewMovieName: TextView
        var textViewMoviePrice: TextView
        var buttonBuy: Button
        var imageViewMore: ImageView

        init {
            cardViewMovie = view.findViewById(R.id.cardViewFilm)
            imageViewMovie = view.findViewById(R.id.imageViewMovie)
            textViewMovieName = view.findViewById(R.id.textViewMovieName)
            textViewMoviePrice = view.findViewById(R.id.textViewMoviePrice)
            buttonBuy = view.findViewById(R.id.buttonBuy)
            imageViewMore = view.findViewById(R.id.imageViewMore)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.row_item, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val movie = moviesList.get(position)

        holder.imageViewMovie.setImageResource(
            mContext.resources.getIdentifier(movie.movieImage, "drawable", mContext.packageName)
        )

        holder.textViewMovieName.text = movie.movieName
        holder.textViewMoviePrice.text = "${movie.moviePrice} ₺"
        holder.buttonBuy.setOnClickListener {
            Snackbar.make(it, "${movie.movieName} movie bought.", Snackbar.LENGTH_SHORT).show()
        }

        holder.cardViewMovie.setOnClickListener {
            val action = HomeFragmentDirections.detailAction(movie)
            Navigation.findNavController(it).navigate(action)
        }

        holder.imageViewMore.setOnClickListener {
            val popupMenu = PopupMenu(mContext, it)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
            popupMenu.show()

            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_let_me_know -> {
                        Snackbar.make(
                            holder.imageViewMore,
                            "${movie.movieName} movie notifications turned on.",
                            Snackbar.LENGTH_SHORT
                        ).show()
                        true
                    }
                    R.id.action_add_to_favorites -> {
                        Snackbar.make(
                            holder.imageViewMore,
                            "${movie.movieName} movie added to favourites.",
                            Snackbar.LENGTH_SHORT
                        ).show()
                        true
                    }
                    else -> false
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}