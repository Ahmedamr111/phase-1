package com.example.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.recipeapp.data.datastore.AppThemeMode
import com.example.recipeapp.ui.navigation.AppNavigation
import com.example.recipeapp.ui.theme.RecipeAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val app = application as RecipeApplication
        val repository = app.repository
        val preferencesRepository = app.userPreferencesRepository

        setContent {
            val themeMode by preferencesRepository.themeModeFlow.collectAsState(initial = AppThemeMode.SYSTEM)

            RecipeAppTheme(themeMode = themeMode) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigation(
                        recipeRepository = repository,
                        preferencesRepository = preferencesRepository
                    )
                }
            }
        }
    }
}
