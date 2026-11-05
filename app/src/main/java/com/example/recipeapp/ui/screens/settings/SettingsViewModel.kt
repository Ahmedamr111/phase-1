package com.example.recipeapp.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.data.datastore.AppThemeMode
import com.example.recipeapp.data.datastore.UserPreferencesRepository
import com.example.recipeapp.data.local.entity.RecipeEntity
import com.example.recipeapp.data.repository.RecipeRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class SettingsUiState(
    val currentTheme: AppThemeMode = AppThemeMode.SYSTEM,
    val totalRecipesCount: Int = 0,
    val totalFavoritesCount: Int = 0
)

class SettingsViewModel(
    private val preferencesRepository: UserPreferencesRepository,
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    val themeMode: StateFlow<AppThemeMode> = preferencesRepository.themeModeFlow
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = AppThemeMode.SYSTEM
        )

    val recipes: StateFlow<List<RecipeEntity>> = recipeRepository.getAllRecipes()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun setThemeMode(mode: AppThemeMode) {
        viewModelScope.launch {
            preferencesRepository.setThemeMode(mode)
        }
    }
}
