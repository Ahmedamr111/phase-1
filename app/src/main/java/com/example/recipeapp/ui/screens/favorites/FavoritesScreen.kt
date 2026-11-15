package com.example.recipeapp.ui.screens.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recipeapp.ui.components.EmptyStateView
import com.example.recipeapp.ui.components.RecipeCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel,
    onRecipeClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val favorites by viewModel.favoriteRecipes.collectAsState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Favorite Recipes",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (favorites.isEmpty()) {
                EmptyStateView(
                    title = "No Favorites Saved",
                    message = "Tap the heart icon on any recipe to save it to your personal favorites collection.",
                    icon = Icons.Outlined.FavoriteBorder
                )
            } else {
                BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                    val isTabletOrLandscape = maxWidth >= 600.dp

                    if (isTabletOrLandscape) {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            contentPadding = PaddingValues(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(favorites, key = { it.id }) { recipe ->
                                RecipeCard(
                                    recipe = recipe,
                                    onClick = { onRecipeClick(recipe.id) },
                                    onToggleFavorite = { viewModel.toggleFavorite(recipe) }
                                )
                            }
                        }
                    } else {
                        LazyColumn(
                            contentPadding = PaddingValues(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(favorites, key = { it.id }) { recipe ->
                                RecipeCard(
                                    recipe = recipe,
                                    onClick = { onRecipeClick(recipe.id) },
                                    onToggleFavorite = { viewModel.toggleFavorite(recipe) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
