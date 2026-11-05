package com.example.recipeapp.ui.screens.addedit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.data.local.entity.RecipeCategory
import com.example.recipeapp.data.local.entity.RecipeEntity
import com.example.recipeapp.data.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class AddEditRecipeUiState(
    val title: String = "",
    val description: String = "",
    val category: String = RecipeCategory.EGYPTIAN.displayName,
    val prepTimeMinutes: String = "30",
    val servings: String = "4",
    val ingredients: String = "",
    val instructions: String = "",
    val sourceUrl: String = "",
    val imageUri: String? = null,
    val isFavorite: Boolean = false,
    val titleError: String? = null,
    val prepTimeError: String? = null,
    val servingsError: String? = null,
    val isSaved: Boolean = false,
    val isEditMode: Boolean = false
)

class AddEditRecipeViewModel(
    private val repository: RecipeRepository,
    private val recipeId: Int?
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddEditRecipeUiState())
    val uiState: StateFlow<AddEditRecipeUiState> = _uiState.asStateFlow()

    init {
        if (recipeId != null && recipeId > 0) {
            loadRecipe(recipeId)
        }
    }

    private fun loadRecipe(id: Int) {
        viewModelScope.launch {
            val recipe = repository.getRecipeById(id).firstOrNull()
            if (recipe != null) {
                _uiState.update {
                    it.copy(
                        title = recipe.title,
                        description = recipe.description,
                        category = recipe.category,
                        prepTimeMinutes = recipe.prepTimeMinutes.toString(),
                        servings = recipe.servings.toString(),
                        ingredients = recipe.ingredients,
                        instructions = recipe.instructions,
                        sourceUrl = recipe.sourceUrl ?: "",
                        imageUri = recipe.imageUri,
                        isFavorite = recipe.isFavorite,
                        isEditMode = true
                    )
                }
            }
        }
    }

    fun onTitleChange(newTitle: String) {
        _uiState.update { it.copy(title = newTitle, titleError = null) }
    }

    fun onDescriptionChange(newDesc: String) {
        _uiState.update { it.copy(description = newDesc) }
    }

    fun onCategoryChange(newCategory: String) {
        _uiState.update { it.copy(category = newCategory) }
    }

    fun onPrepTimeChange(newTime: String) {
        _uiState.update { it.copy(prepTimeMinutes = newTime, prepTimeError = null) }
    }

    fun onServingsChange(newServings: String) {
        _uiState.update { it.copy(servings = newServings, servingsError = null) }
    }

    fun onIngredientsChange(newIngredients: String) {
        _uiState.update { it.copy(ingredients = newIngredients) }
    }

    fun onInstructionsChange(newInstructions: String) {
        _uiState.update { it.copy(instructions = newInstructions) }
    }

    fun onSourceUrlChange(newUrl: String) {
        _uiState.update { it.copy(sourceUrl = newUrl) }
    }

    fun onImageSelected(uri: String?) {
        _uiState.update { it.copy(imageUri = uri) }
    }

    fun saveRecipe(onSuccess: () -> Unit) {
        val currentState = _uiState.value

        var hasError = false
        var titleErr: String? = null
        var prepTimeErr: String? = null
        var servingsErr: String? = null

        if (currentState.title.isBlank()) {
            titleErr = "Recipe title cannot be empty"
            hasError = true
        }

        val prepTime = currentState.prepTimeMinutes.toIntOrNull()
        if (prepTime == null || prepTime <= 0) {
            prepTimeErr = "Enter valid positive minutes"
            hasError = true
        }

        val servings = currentState.servings.toIntOrNull()
        if (servings == null || servings <= 0) {
            servingsErr = "Enter valid positive servings"
            hasError = true
        }

        if (hasError) {
            _uiState.update {
                it.copy(
                    titleError = titleErr,
                    prepTimeError = prepTimeErr,
                    servingsError = servingsErr
                )
            }
            return
        }

        viewModelScope.launch {
            val recipe = RecipeEntity(
                id = if (recipeId != null && recipeId > 0) recipeId else 0,
                title = currentState.title.trim(),
                description = currentState.description.trim(),
                category = currentState.category,
                prepTimeMinutes = prepTime ?: 30,
                servings = servings ?: 4,
                ingredients = currentState.ingredients.trim(),
                instructions = currentState.instructions.trim(),
                sourceUrl = currentState.sourceUrl.trim().ifBlank { null },
                imageUri = currentState.imageUri,
                isFavorite = currentState.isFavorite
            )

            if (currentState.isEditMode) {
                repository.updateRecipe(recipe)
            } else {
                repository.insertRecipe(recipe)
            }

            _uiState.update { it.copy(isSaved = true) }
            onSuccess()
        }
    }
}
