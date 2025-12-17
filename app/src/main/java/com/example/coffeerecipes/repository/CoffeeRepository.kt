package com.example.coffeerecipes.repository

import com.example.coffeerecipes.model.CoffeeRecipe

object CoffeeRepository {

    private val recipes: List<CoffeeRecipe> = listOf(
        CoffeeRecipe(
            id = "latte_1",
            category = "Latte",
            title = "Classic Latte",
            ingredients = "Espresso, steamed milk, milk foam",
            steps = "1. Brew espresso\n2. Steam milk\n3. Combine\n4. Add foam"
        ),
        CoffeeRecipe(
            id = "espresso_1",
            category = "Espresso",
            title = "Italian Espresso",
            ingredients = "Coffee beans, water",
            steps = "1. Grind beans\n2. Tamp\n3. Brew 25–30 sec"
        ),
        CoffeeRecipe(
            id = "cappuccino_1",
            category = "Cappuccino",
            title = "Classic Cappuccino",
            ingredients = "Espresso, steamed milk, foam",
            steps = "1. Brew espresso\n2. Add steamed milk\n3. Top with foam"
        ),
        CoffeeRecipe(
            id = "cold_1",
            category = "Cold Coffee",
            title = "Iced Latte",
            ingredients = "Espresso, cold milk, ice",
            steps = "1. Brew espresso\n2. Add ice\n3. Pour cold milk\n4. Add espresso"
        )
    )

    fun getAll(): List<CoffeeRecipe> = recipes

    fun getByCategory(category: String): List<CoffeeRecipe> =
        recipes.filter { it.category == category }

    fun getById(id: String): CoffeeRecipe? =
        recipes.find { it.id == id }
}
