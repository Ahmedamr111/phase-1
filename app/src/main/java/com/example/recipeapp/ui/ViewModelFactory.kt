package com.example.recipeapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recipeapp.data.datastore.UserPreferencesRepository
import com.example.recipeapp.data.repository.RecipeRepository
import com.example.recipeapp.ui.screens.addedit.AddEditRecipeViewModel
import com.example.recipeapp.ui.screens.detail.RecipeDetailViewModel
import com.example.recipeapp.ui.screens.favorites.FavoritesViewModel
import com.example.recipeapp.ui.screens.home.HomeViewModel
import com.example.recipeapp.ui.screens.search.SearchViewModel
import com.example.recipeapp.ui.screens.settings.SettingsViewModel

/**
 * Custom ViewModelProvider.Factory for instantiating ViewModels with repository dependencies.
 */
class ViewModelFactory(
    private val recipeRepository: RecipeRepository,
    private val preferencesRepository: UserPreferencesRepository,
    private val recipeId: Int? = null
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(recipeRepository) as T
            }
            modelClass.isAssignableFrom(SearchViewModel::class.java) -> {
                SearchViewModel(recipeRepository) as T
            }
            modelClass.isAssignableFrom(FavoritesViewModel::class.java) -> {
                FavoritesViewModel(recipeRepository) as T
            }
            modelClass.isAssignableFrom(SettingsViewModel::class.java) -> {
                SettingsViewModel(preferencesRepository, recipeRepository) as T
            }
            modelClass.isAssignableFrom(RecipeDetailViewModel::class.java) -> {
                RecipeDetailViewModel(recipeRepository, recipeId ?: 0) as T
            }
            modelClass.isAssignableFrom(AddEditRecipeViewModel::class.java) -> {
                AddEditRecipeViewModel(recipeRepository, recipeId) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
