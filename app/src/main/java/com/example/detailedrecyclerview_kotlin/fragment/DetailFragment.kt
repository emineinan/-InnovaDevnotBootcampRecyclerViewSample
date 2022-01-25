package com.example.detailedrecyclerview_kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.detailedrecyclerview_kotlin.databinding.FragmentDetailBinding
import com.google.android.material.snackbar.Snackbar

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val bundle: DetailFragmentArgs by navArgs()
        val movie = bundle.movie

        binding.toolbarDetail.title = movie.movieName
        binding.imageViewDetailMovie.setImageResource(
            resources.getIdentifier(
                movie.movieImage,
                "drawable",
                requireContext().packageName
            )
        )

        binding.textViewDetailDirector.text = movie.movieDirector
        binding.textViewDetailMovieYear.text = movie.movieYear.toString()
        binding.textViewDetailMoviePrice.text = "${movie.moviePrice} ₺"

        binding.buttonDetailBuy.setOnClickListener {
            Snackbar.make(it, "${movie.movieName} movie bought.", Snackbar.LENGTH_LONG).show()
        }

        return binding.root
    }
}