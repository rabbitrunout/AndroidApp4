package com.example.coffeerecipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeerecipes.R
import com.example.coffeerecipes.model.CoffeeRecipe

class RecipeAdapter(
    private val recipes: List<CoffeeRecipe>,
    private val onClick: (CoffeeRecipe) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val title: TextView =
            itemView.findViewById(R.id.titleText)

        private val ingredients: TextView =
            itemView.findViewById(R.id.ingredientsText)

        fun bind(recipe: CoffeeRecipe) {
            title.text = recipe.title
            ingredients.text = recipe.ingredients

            itemView.setOnClickListener {
                onClick(recipe)
            }
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
