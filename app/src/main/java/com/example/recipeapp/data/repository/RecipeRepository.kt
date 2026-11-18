package com.example.recipeapp.data.repository

import com.example.recipeapp.data.local.dao.RecipeDao
import com.example.recipeapp.data.local.database.SampleData
import com.example.recipeapp.data.local.entity.RecipeEntity
import kotlinx.coroutines.flow.Flow

/**
 * Interface defining recipe data operations.
 */
interface RecipeRepository {
    fun getAllRecipes(): Flow<List<RecipeEntity>>
    fun getFavoriteRecipes(): Flow<List<RecipeEntity>>
    fun getRecipesByCategory(category: String): Flow<List<RecipeEntity>>
    fun searchRecipes(query: String): Flow<List<RecipeEntity>>
    fun getRecipeById(id: Int): Flow<RecipeEntity?>
    suspend fun insertRecipe(recipe: RecipeEntity): Long
    suspend fun updateRecipe(recipe: RecipeEntity)
    suspend fun deleteRecipe(recipe: RecipeEntity)
    suspend fun toggleFavorite(recipeId: Int, isFavorite: Boolean)
    suspend fun ensureSampleDataPopulated()
}

/**
 * Concrete implementation of [RecipeRepository] using Room [RecipeDao].
 */
class RecipeRepositoryImpl(private val recipeDao: RecipeDao) : RecipeRepository {

    override fun getAllRecipes(): Flow<List<RecipeEntity>> = recipeDao.getAllRecipes()

    override fun getFavoriteRecipes(): Flow<List<RecipeEntity>> = recipeDao.getFavoriteRecipes()

    override fun getRecipesByCategory(category: String): Flow<List<RecipeEntity>> =
        recipeDao.getRecipesByCategory(category)

    override fun searchRecipes(query: String): Flow<List<RecipeEntity>> =
        recipeDao.searchRecipes(query)

    override fun getRecipeById(id: Int): Flow<RecipeEntity?> = recipeDao.getRecipeById(id)

    override suspend fun insertRecipe(recipe: RecipeEntity): Long = recipeDao.insertRecipe(recipe)

    override suspend fun updateRecipe(recipe: RecipeEntity) = recipeDao.updateRecipe(recipe)

    override suspend fun deleteRecipe(recipe: RecipeEntity) = recipeDao.deleteRecipe(recipe)

    override suspend fun toggleFavorite(recipeId: Int, isFavorite: Boolean) =
        recipeDao.updateFavoriteStatus(recipeId, isFavorite)

    override suspend fun ensureSampleDataPopulated() {
        if (recipeDao.getRecipeCount() == 0) {
            recipeDao.insertAll(SampleData.initialRecipes)
        }
    }
}
