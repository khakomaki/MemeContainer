package com.khakomaki.memecontainer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khakomaki.memecontainer.ui.screens.home.HomeScreen
import com.khakomaki.memecontainer.ui.screens.meme.AddMemeScreen
import com.khakomaki.memecontainer.ui.screens.meme.MemeDetailScreen
import com.khakomaki.memecontainer.ui.theme.MemeContainerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MemeContainerTheme {
                MemeContainer()
            }
        }
    }
}

@Composable
fun MemeContainer() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        MemeContainerNavHost()
    }
}

@Composable
fun MemeContainerNavHost() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onMemeClick = { memeId -> navController.navigate("detail/$memeId") },
                onAddMemeClick = { navController.navigate("add") }
            )
        }

        composable("detail/{memeId}") { backStackEntry ->
            val memeId = backStackEntry.arguments?.getString("memeId") ?: return@composable
            MemeDetailScreen(memeId)
        }

        composable("add") {
            AddMemeScreen(onMemeAdded = { navController.popBackStack() })
        }
    }
}
