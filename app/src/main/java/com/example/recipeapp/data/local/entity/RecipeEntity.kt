package com.example.recipeapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Room Entity representing a single recipe in the database.
 */
@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val category: String,
    val prepTimeMinutes: Int,
    val servings: Int,
    val ingredients: String,
    val instructions: String,
    val isFavorite: Boolean = false,
    val imageUri: String? = null,
    val sourceUrl: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)
