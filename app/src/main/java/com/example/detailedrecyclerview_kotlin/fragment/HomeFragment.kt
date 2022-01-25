package com.example.detailedrecyclerview_kotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.detailedrecyclerview_kotlin.adapter.MoviesAdapter
import com.example.detailedrecyclerview_kotlin.databinding.FragmentHomeBinding
import com.example.detailedrecyclerview_kotlin.model.Movies


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val movies = ArrayList<Movies>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.toolbarHome.title = "Movies"
        binding.recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        setMovies()
        setAdapter()

        return binding.root
    }

    private fun setMovies() {
        val f1 = Movies(1, "Anadoluda", "anadoluda", 2008, 7.0, "Nuri Bilge Ceylan")
        val f2 = Movies(2, "Django", "django", 2009, 15.0, "Quetin Tarantino")
        val f3 = Movies(3, "Inception", "inception", 2006, 8.0, "Christoper Nolan")
        val f4 = Movies(4, "Interstellar", "interstellar", 2013, 18.0, "Christoper Nolan")
        val f5 = Movies(5, "The Hateful Eight", "thehatefuleight", 2011, 9.0, "Quetin Tarantino")
        val f6 = Movies(6, "The Pianist", "thepianist", 2000, 5.0, "Roman Polanski")
        movies.add(f1)
        movies.add(f2)
        movies.add(f3)
        movies.add(f4)
        movies.add(f5)
        movies.add(f6)
    }

    private fun setAdapter() {
        val adapter = MoviesAdapter(requireContext(), movies)
        binding.recyclerView.adapter = adapter
    }
}