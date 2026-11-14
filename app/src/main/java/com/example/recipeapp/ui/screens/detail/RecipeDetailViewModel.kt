package com.example.recipeapp.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.data.local.entity.RecipeEntity
import com.example.recipeapp.data.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed interface RecipeDetailUiState {
    data object Loading : RecipeDetailUiState
    data class Success(val recipe: RecipeEntity) : RecipeDetailUiState
    data object NotFound : RecipeDetailUiState
}

class RecipeDetailViewModel(
    private val repository: RecipeRepository,
    private val recipeId: Int
) : ViewModel() {

    private val _uiState = MutableStateFlow<RecipeDetailUiState>(RecipeDetailUiState.Loading)
    val uiState: StateFlow<RecipeDetailUiState> = _uiState

    init {
        loadRecipe()
    }

    private fun loadRecipe() {
        viewModelScope.launch {
            repository.getRecipeById(recipeId).collect { recipe ->
                _uiState.value = if (recipe != null) {
                    RecipeDetailUiState.Success(recipe)
                } else {
                    RecipeDetailUiState.NotFound
                }
            }
        }
    }

    fun toggleFavorite() {
        val currentState = _uiState.value
        if (currentState is RecipeDetailUiState.Success) {
            val recipe = currentState.recipe
            viewModelScope.launch {
                repository.toggleFavorite(recipe.id, !recipe.isFavorite)
            }
        }
    }

    fun deleteRecipe(onDeleted: () -> Unit) {
        val currentState = _uiState.value
        if (currentState is RecipeDetailUiState.Success) {
            viewModelScope.launch {
                repository.deleteRecipe(currentState.recipe)
                onDeleted()
            }
        }
    }
}
