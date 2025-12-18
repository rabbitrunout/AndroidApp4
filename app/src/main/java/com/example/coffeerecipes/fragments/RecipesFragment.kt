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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.findNavController
import android.widget.ImageView
import android.widget.TextView

class RecipesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_recipes, container, false)

        val category = arguments?.getString("category") ?: "Recipes"

        val backButton = view.findViewById<ImageView>(R.id.backButton)
        val titleText = view.findViewById<TextView>(R.id.titleText)

        titleText.text = category

        backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val recipes = CoffeeRepository.getByCategory(category)

        recyclerView.adapter = RecipeAdapter(recipes) { recipe ->
            val bundle = Bundle()
            bundle.putString("recipeId", recipe.id)

            findNavController().navigate(
                R.id.action_recipesFragment_to_recipeDetailFragment,
                bundle
            )
        }

        return view
    }
}


