package ui.open_positions

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.openPositions
import exampledevlanekotlinmultiplatformapp.composeapp.generated.resources.Res
import exampledevlanekotlinmultiplatformapp.composeapp.generated.resources.devlane_logo
import org.jetbrains.compose.resources.imageResource

@Composable
fun OpenPositionsScreen(
    onItemClick: (Int) -> Unit
) {
    LazyColumn {
        items(openPositions.size) { position ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.0.dp).clickable {
                    onItemClick(position)
                }
            ) {
                Image(
                    imageResource(Res.drawable.devlane_logo),
                    "Devlane Logo",
                    modifier = Modifier.width(50.dp).height(50.dp)
                )
                Spacer(Modifier.width(8.0.dp))
                Text(openPositions[position].title)
            }
        }
    }
}