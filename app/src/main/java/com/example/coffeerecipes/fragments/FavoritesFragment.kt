package com.example.coffeerecipes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeerecipes.R
import com.example.coffeerecipes.adapters.RecipeAdapter
import com.example.coffeerecipes.repository.CoffeeRepository
import com.example.coffeerecipes.utils.PrefsManager

class FavoritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_favorites, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val favoriteIds = PrefsManager.getFavorites(requireContext())

        val favoriteRecipes = CoffeeRepository.getAll()
            .filter { recipe -> favoriteIds.contains(recipe.id) }

        recyclerView.adapter = RecipeAdapter(favoriteRecipes) { recipe ->
            // можно сделать remove из избранного по клику, но пока не надо
        }

        return view
    }
}
