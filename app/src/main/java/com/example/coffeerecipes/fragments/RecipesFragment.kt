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

class RecipesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_recipes, container, false)

        val category = arguments?.getString("category") ?: ""

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val recipes = CoffeeRepository.getByCategory(category)

        recyclerView.adapter = RecipeAdapter(recipes) { recipe ->
            // добавляем в историю при просмотре (пока просто по клику)
            PrefsManager.addToHistory(requireContext(), recipe.id)

            // позже добавим переход на detail экран
        }

        return view
    }
}
