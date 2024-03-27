package app.sanao1006.androidsweets.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.sanao1006.home.HomeScreen

@Composable
fun AndroidSweetsNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.HOME.route) {
        composable(route = "home") {
            HomeScreen()
        }
    }
}
