package com.example.mygame.navhost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.mygame.model.Records
import com.example.mygame.screen.LevelScreen
import com.example.mygame.screen.QuizScreen
import com.example.mygame.screen.RecordScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Level.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    )
    {
        composable("quiz/{level}") { navBackStackEntry ->
            val level = navBackStackEntry.arguments?.getString("level")
            level?.let {
                QuizScreen(navController, level)
            }
        }

        composable(NavigationItem.Level.route) {
            LevelScreen(navController)
        }

        composable<Records> { navBackStackEntry ->
            val records : Records = navBackStackEntry.toRoute()
            RecordScreen(records)

        }
    }
}

