package com.example.coffeerecipes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeerecipes.R
import com.example.coffeerecipes.adapters.CategoryAdapter

class CategoriesFragment : Fragment() {

    private val categories = listOf(
        "Latte",
        "Espresso",
        "Cappuccino",
        "Cold Coffee"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_categories, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = CategoryAdapter(categories) { category ->
            val bundle = Bundle()
            bundle.putString("category", category)

            findNavController().navigate(
                R.id.action_categoriesFragment_to_recipesFragment,
                bundle
            )
        }

        return view
    }
}
