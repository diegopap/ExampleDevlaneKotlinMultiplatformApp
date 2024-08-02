package ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun SettingsScreen(dataStore: DataStore<Preferences>, navigate: () -> Boolean) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("Settings") },
                navigationIcon = {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back",
                        modifier = Modifier.clickable {
                            navigate()
                        })
            })
        }
    ) {
        paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues).padding(8.0.dp)
            ) {
                val themes = listOf("System Theme", "Light Theme", "Dark Theme")

                var expanded by remember { mutableStateOf(false) }
                var selectedOptionText by remember { mutableStateOf(themes[0]) }

                ExposedDropdownMenuBox(
                    modifier = Modifier.padding(16.dp),
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded },
                ) {
                    TextField(
                        readOnly = true,
                        value = selectedOptionText,
                        onValueChange = {},
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
                        modifier = Modifier.menuAnchor()
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        themes.forEach {
                            DropdownMenuItem(
                                text = { Text(it) },
                                onClick = {
                                    selectedOptionText = it
                                    expanded = false
                                    GlobalScope.launch {
                                        when (it) {
                                            themes[1] -> dataStore.edit { preferences ->
                                                preferences[intPreferencesKey("color_theme")] = 1
                                            }
                                            themes[2] -> dataStore.edit { preferences ->
                                                preferences[intPreferencesKey("color_theme")] = 2
                                            }
                                            else -> dataStore.edit { preferences ->
                                                preferences[intPreferencesKey("color_theme")] = 0
                                            }
                                        }
                                    }
                                }
                            )
                        }
                    }
                }
            }
    }

}