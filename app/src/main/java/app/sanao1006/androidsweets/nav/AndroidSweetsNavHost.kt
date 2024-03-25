package app.sanao1006.androidsweets.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AndroidSweetsNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(navController = rememberNavController(), startDestination = Route.HOME.name) {

    }
}
