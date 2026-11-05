package com.example.recipeapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recipeapp.data.datastore.UserPreferencesRepository
import com.example.recipeapp.data.repository.RecipeRepository
import com.example.recipeapp.ui.ViewModelFactory
import com.example.recipeapp.ui.screens.addedit.AddEditRecipeScreen
import com.example.recipeapp.ui.screens.addedit.AddEditRecipeViewModel
import com.example.recipeapp.ui.screens.detail.RecipeDetailScreen
import com.example.recipeapp.ui.screens.detail.RecipeDetailViewModel
import com.example.recipeapp.ui.screens.favorites.FavoritesScreen
import com.example.recipeapp.ui.screens.favorites.FavoritesViewModel
import com.example.recipeapp.ui.screens.home.HomeScreen
import com.example.recipeapp.ui.screens.home.HomeViewModel
import com.example.recipeapp.ui.screens.search.SearchScreen
import com.example.recipeapp.ui.screens.search.SearchViewModel
import com.example.recipeapp.ui.screens.settings.SettingsScreen
import com.example.recipeapp.ui.screens.settings.SettingsViewModel

@Composable
fun AppNavigation(
    recipeRepository: RecipeRepository,
    preferencesRepository: UserPreferencesRepository,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Check whether the current screen is one of the bottom navigation tabs
    val isBottomBarVisible = bottomNavItems.any { it.route == currentRoute }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible) {
                NavigationBar {
                    bottomNavItems.forEach { item ->
                        val isSelected = currentRoute == item.route
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                if (currentRoute != item.route) {
                                    navController.navigate(item.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            },
                            label = { Text(item.title) }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Home Screen
            composable(Screen.Home.route) {
                val homeViewModel: HomeViewModel = viewModel(
                    factory = ViewModelFactory(recipeRepository, preferencesRepository)
                )
                HomeScreen(
                    viewModel = homeViewModel,
                    onRecipeClick = { recipeId ->
                        navController.navigate(Screen.RecipeDetail.createRoute(recipeId))
                    },
                    onAddRecipeClick = {
                        navController.navigate(Screen.AddEditRecipe.createRoute())
                    }
                )
            }

            // Search Screen
            composable(Screen.Search.route) {
                val searchViewModel: SearchViewModel = viewModel(
                    factory = ViewModelFactory(recipeRepository, preferencesRepository)
                )
                SearchScreen(
                    viewModel = searchViewModel,
                    onRecipeClick = { recipeId ->
                        navController.navigate(Screen.RecipeDetail.createRoute(recipeId))
                    }
                )
            }

            // Favorites Screen
            composable(Screen.Favorites.route) {
                val favoritesViewModel: FavoritesViewModel = viewModel(
                    factory = ViewModelFactory(recipeRepository, preferencesRepository)
                )
                FavoritesScreen(
                    viewModel = favoritesViewModel,
                    onRecipeClick = { recipeId ->
                        navController.navigate(Screen.RecipeDetail.createRoute(recipeId))
                    }
                )
            }

            // Settings Screen
            composable(Screen.Settings.route) {
                val settingsViewModel: SettingsViewModel = viewModel(
                    factory = ViewModelFactory(recipeRepository, preferencesRepository)
                )
                SettingsScreen(viewModel = settingsViewModel)
            }

            // Recipe Detail Screen
            composable(
                route = Screen.RecipeDetail.route,
                arguments = listOf(
                    navArgument("recipeId") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val recipeId = backStackEntry.arguments?.getInt("recipeId") ?: 0
                val detailViewModel: RecipeDetailViewModel = viewModel(
                    key = "detail_$recipeId",
                    factory = ViewModelFactory(recipeRepository, preferencesRepository, recipeId = recipeId)
                )
                RecipeDetailScreen(
                    viewModel = detailViewModel,
                    onNavigateBack = { navController.popBackStack() },
                    onEditRecipe = { id ->
                        navController.navigate(Screen.AddEditRecipe.createRoute(id))
                    }
                )
            }

            // Add / Edit Recipe Screen
            composable(
                route = Screen.AddEditRecipe.route,
                arguments = listOf(
                    navArgument("recipeId") {
                        type = NavType.IntType
                        defaultValue = -1
                    }
                )
            ) { backStackEntry ->
                val recipeId = backStackEntry.arguments?.getInt("recipeId")?.takeIf { it > 0 }
                val addEditViewModel: AddEditRecipeViewModel = viewModel(
                    key = "add_edit_${recipeId ?: 0}",
                    factory = ViewModelFactory(recipeRepository, preferencesRepository, recipeId = recipeId)
                )
                AddEditRecipeScreen(
                    viewModel = addEditViewModel,
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}
