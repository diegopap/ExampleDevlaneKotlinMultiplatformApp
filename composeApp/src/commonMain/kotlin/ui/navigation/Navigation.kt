package ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import ui.about.AboutScreen
import ui.locations.LocationsScreen
import ui.open_positions.OpenPositionsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(navigateToSettings: () -> Unit, navigateToDetails: (Int) -> Unit) {
    val selected = remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    when (selected.value) {
                        0 -> Text("About")
                        1 -> Text("Open Positions")
                        2 -> Text("Locations")
                    }
                },
                actions = {
                    Icon(Icons.Filled.Settings, "Settings", modifier = Modifier.clickable {
                        navigateToSettings()
                    })
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable {
                            selected.value = 0
                        }
                    ) {
                        if (selected.value == 0) {
                            Icon(Icons.Filled.Home, "About")
                            Text("About", fontWeight = FontWeight.Bold)
                        } else {
                            Icon(Icons.Outlined.Home, "About")
                            Text("About", fontWeight = FontWeight.Normal)
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable {
                            selected.value = 1
                        }
                    ) {
                        if (selected.value == 1) {
                            Icon(Icons.Filled.Person, "Open Positions")
                            Text("Open Positions", fontWeight = FontWeight.Bold)
                        } else {
                            Icon(Icons.Outlined.Person, "Open Positions")
                            Text("Open Positions", fontWeight = FontWeight.Normal)
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable {
                            selected.value = 2
                        }
                    ) {
                        if (selected.value == 2) {
                            Icon(Icons.Filled.Place, "Locations")
                            Text("Locations", fontWeight = FontWeight.Bold)
                        } else {
                            Icon(Icons.Outlined.Place, "Locations")
                            Text("Locations", fontWeight = FontWeight.Normal)
                        }
                    }
                }
            }
        }
    ) {
        innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            when (selected.value) {
                0 -> AboutScreen()
                1 -> OpenPositionsScreen(onItemClick = navigateToDetails)
                2 -> LocationsScreen()
            }
        }
    }
}