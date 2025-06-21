package com.khakomaki.memecontainer.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khakomaki.memecontainer.ui.navigation.Routes.MEME_ID
import com.khakomaki.memecontainer.ui.screens.home.HomeScreen
import com.khakomaki.memecontainer.ui.screens.meme.AddMemeScreen
import com.khakomaki.memecontainer.ui.screens.meme.MemeDetailScreen

@Composable
fun MemeContainerNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                onMemeClick = { memeId ->
                    navController.navigate(Routes.detail(memeId))
                },
                onAddMemeClick = {
                    navController.navigate(Routes.ADD)
                }
            )
        }

        composable(Routes.DETAIL) { backStackEntry ->
            val memeId = backStackEntry.arguments?.getString(MEME_ID) ?: return@composable
            MemeDetailScreen(
                memeId = memeId,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.ADD) {
            AddMemeScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}
