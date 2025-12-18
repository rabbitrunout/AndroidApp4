package com.example.coffeerecipes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.coffeerecipes.R
import com.example.coffeerecipes.repository.CoffeeRepository
import com.example.coffeerecipes.utils.PrefsManager
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController


class RecipeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_recipe_detail, container, false)

        val backButton = view.findViewById<ImageView>(R.id.backButton)
        val titleText = view.findViewById<TextView>(R.id.headerTitle)
        val ingredientsText = view.findViewById<TextView>(R.id.ingredientsText)
        val stepsText = view.findViewById<TextView>(R.id.stepsText)
        val favoriteIcon = view.findViewById<ImageView>(R.id.favoriteIcon)

        backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        val recipeId = arguments?.getString("recipeId") ?: return view
        val recipe = CoffeeRepository.getById(recipeId) ?: return view

        titleText.text = recipe.title
        ingredientsText.text = recipe.ingredients
        stepsText.text = recipe.steps

        PrefsManager.addToHistory(requireContext(), recipe.id)

        fun updateStar() {
            val favorites = PrefsManager.getFavorites(requireContext())
            favoriteIcon.setImageResource(
                if (favorites.contains(recipe.id))
                    android.R.drawable.btn_star_big_on
                else
                    android.R.drawable.btn_star_big_off
            )
        }

        updateStar()

        favoriteIcon.setOnClickListener {
            PrefsManager.toggleFavorite(requireContext(), recipe.id)
            updateStar()
        }

        return view
    }
}
