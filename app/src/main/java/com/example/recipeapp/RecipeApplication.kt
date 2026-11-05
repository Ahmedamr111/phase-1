package com.example.recipeapp

import android.app.Application
import com.example.recipeapp.data.datastore.UserPreferencesRepository
import com.example.recipeapp.data.local.database.AppDatabase
import com.example.recipeapp.data.repository.RecipeRepository
import com.example.recipeapp.data.repository.RecipeRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

/**
 * Custom Application class providing dependency container instances.
 */
class RecipeApplication : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    val database by lazy {
        AppDatabase.getDatabase(this, applicationScope)
    }

    val repository: RecipeRepository by lazy {
        RecipeRepositoryImpl(database.recipeDao())
    }

    val userPreferencesRepository by lazy {
        UserPreferencesRepository(this)
    }

    override fun onCreate() {
        super.onCreate()
        applicationScope.launch(Dispatchers.IO) {
            repository.ensureSampleDataPopulated()
        }
    }
}
