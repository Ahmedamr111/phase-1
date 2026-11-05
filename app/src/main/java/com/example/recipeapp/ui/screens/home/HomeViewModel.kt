package com.example.recipeapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.data.local.entity.RecipeCategory
import com.example.recipeapp.data.local.entity.RecipeEntity
import com.example.recipeapp.data.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class HomeUiState(
    val selectedCategory: RecipeCategory = RecipeCategory.ALL,
    val recipes: List<RecipeEntity> = emptyList(),
    val isLoading: Boolean = false
)

class HomeViewModel(private val repository: RecipeRepository) : ViewModel() {

    private val _selectedCategory = MutableStateFlow(RecipeCategory.ALL)
    val selectedCategory: StateFlow<RecipeCategory> = _selectedCategory

    val uiState: StateFlow<HomeUiState> = combine(
        _selectedCategory,
        repository.getAllRecipes()
    ) { category, allRecipes ->
        val filtered = if (category == RecipeCategory.ALL) {
            allRecipes
        } else {
            allRecipes.filter { it.category.equals(category.displayName, ignoreCase = true) }
        }
        HomeUiState(
            selectedCategory = category,
            recipes = filtered,
            isLoading = false
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HomeUiState(isLoading = true)
    )

    fun onCategorySelected(category: RecipeCategory) {
        _selectedCategory.value = category
    }

    fun toggleFavorite(recipe: RecipeEntity) {
        viewModelScope.launch {
            repository.toggleFavorite(recipe.id, !recipe.isFavorite)
        }
    }
}
