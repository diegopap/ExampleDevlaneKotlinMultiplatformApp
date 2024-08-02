
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.map
import ui.navigation.Navigation
import ui.open_positions.OpenPositionsDetailsScreen
import ui.settings.SettingsScreen
import ui.theme.DarkColorScheme
import ui.theme.LightColorScheme


@Composable
fun App(dataStore: DataStore<Preferences>) {

    val colorThemeState = dataStore.data.map { it[intPreferencesKey("color_theme")] ?: 0 }.collectAsState(0)

    MaterialTheme(
        colorScheme = if (colorThemeState.value == 0) {
            if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme
        } else {
            if (colorThemeState.value == 2) DarkColorScheme else LightColorScheme
        }
    ) {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "navigation") {
            composable("navigation") { Navigation(
                navigateToSettings = {
                    navController.navigate("settings")
                },
                navigateToDetails = {
                    position -> navController.navigate("details/$position")
                })
            }
            composable("settings") { SettingsScreen(dataStore) {
                navController.popBackStack()
            } }
            composable("details/{position}") { backStackEntry ->
                val position = backStackEntry.arguments?.getString("position")?.toInt() ?: 0
                OpenPositionsDetailsScreen(position)  {
                    navController.popBackStack()
                }
            }
        }
    }
}