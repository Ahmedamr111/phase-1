package com.example.recipeapp.data.local.entity

/**
 * Standard recipe categories supported across the application.
 */
enum class RecipeCategory(val displayName: String) {
    ALL("All"),
    EGYPTIAN("Egyptian"),
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    DESSERT("Dessert"),
    VEGETARIAN("Vegetarian"),
    DRINKS("Drinks");

    companion object {
        fun fromDisplayName(name: String): RecipeCategory {
            return entries.find { it.displayName.equals(name, ignoreCase = true) } ?: ALL
        }
    }
}
