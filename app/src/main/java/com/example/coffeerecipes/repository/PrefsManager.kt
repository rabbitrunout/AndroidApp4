package com.example.coffeerecipes.utils

import android.content.Context

object PrefsManager {

    private const val PREFS_NAME = "coffee_prefs"
    private const val KEY_FAVORITES = "favorites"
    private const val KEY_HISTORY = "history"

    fun toggleFavorite(context: Context, id: String) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val set = (prefs.getStringSet(KEY_FAVORITES, emptySet()) ?: emptySet()).toMutableSet()

        if (set.contains(id)) set.remove(id) else set.add(id)

        prefs.edit().putStringSet(KEY_FAVORITES, set).apply()
    }

    fun getFavorites(context: Context): Set<String> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getStringSet(KEY_FAVORITES, emptySet()) ?: emptySet()
    }

    fun addToHistory(context: Context, id: String) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val list = (prefs.getStringSet(KEY_HISTORY, emptySet()) ?: emptySet()).toMutableSet()

        // чтобы элемент был “последним” — удалим и добавим снова
        list.remove(id)
        list.add(id)

        prefs.edit().putStringSet(KEY_HISTORY, list).apply()
    }

    fun getHistory(context: Context): List<String> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        // Set не гарантирует порядок — но для базового задания ок.
        // Если хочешь строго “последние сверху” — позже сделаем хранение в JSON списке.
        return (prefs.getStringSet(KEY_HISTORY, emptySet()) ?: emptySet()).toList()
    }
}
