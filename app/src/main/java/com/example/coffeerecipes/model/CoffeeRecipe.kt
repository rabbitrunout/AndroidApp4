package com.example.coffeerecipes.model

data class CoffeeRecipe(
    val id: String,
    val category: String,
    val title: String,
    val ingredients: String,
    val steps: String
)
