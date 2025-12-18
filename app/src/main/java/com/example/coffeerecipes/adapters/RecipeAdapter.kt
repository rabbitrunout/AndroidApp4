package com.example.coffeerecipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeerecipes.R
import com.example.coffeerecipes.model.CoffeeRecipe
import com.example.coffeerecipes.utils.PrefsManager
import com.google.android.material.snackbar.Snackbar

class RecipeAdapter(
    private val recipes: List<CoffeeRecipe>,
    private val onClick: (CoffeeRecipe) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.findViewById(R.id.titleText)
        private val ingredients: TextView = itemView.findViewById(R.id.ingredientsText)
        private val favoriteIcon: ImageView = itemView.findViewById(R.id.favoriteIcon)

        fun bind(recipe: CoffeeRecipe) {
            title.text = recipe.title
            ingredients.text = recipe.ingredients

            updateStar(recipe)

            favoriteIcon.setOnClickListener {
                val context = itemView.context
                val wasFavorite =
                    PrefsManager.getFavorites(context).contains(recipe.id)

                PrefsManager.toggleFavorite(context, recipe.id)
                animateStar()
                updateStar(recipe)

                showSnackbar(wasFavorite)
            }

            itemView.setOnClickListener {
                onClick(recipe)
            }
        }

        private fun showSnackbar(wasFavorite: Boolean) {
            val message = if (wasFavorite) {
                "Removed from favorites"
            } else {
                "Added to favorites ☕"
            }

            Snackbar
                .make(itemView, message, Snackbar.LENGTH_SHORT)
                .setAnchorView(itemView)
                .show()
        }

        private fun updateStar(recipe: CoffeeRecipe) {
            val favorites = PrefsManager.getFavorites(itemView.context)
            val isFavorite = favorites.contains(recipe.id)

            favoriteIcon.setImageResource(
                if (isFavorite)
                    android.R.drawable.btn_star_big_on
                else
                    android.R.drawable.btn_star_big_off
            )

            favoriteIcon.setColorFilter(
                if (isFavorite)
                    itemView.context.getColor(R.color.caramel_gold)
                else
                    itemView.context.getColor(R.color.cocoa_gray)
            )
        }

        private fun animateStar() {
            favoriteIcon.animate()
                .scaleX(1.3f)
                .scaleY(1.3f)
                .setDuration(120)
                .withEndAction {
                    favoriteIcon.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(120)
                        .start()
                }
                .start()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount(): Int = recipes.size
}
