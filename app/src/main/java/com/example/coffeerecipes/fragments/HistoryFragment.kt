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

class HistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_history, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val historyIds = PrefsManager.getHistory(requireContext())

        // последние сверху
        val historyRecipes = historyIds
            .mapNotNull { id -> CoffeeRepository.getById(id) }
            .reversed()

        recyclerView.adapter = RecipeAdapter(historyRecipes) {
            // по клику пока ничего
        }

        return view
    }
}
