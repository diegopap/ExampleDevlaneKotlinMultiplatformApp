package ui.locations

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import exampledevlanekotlinmultiplatformapp.composeapp.generated.resources.Res
import exampledevlanekotlinmultiplatformapp.composeapp.generated.resources.blue_map
import exampledevlanekotlinmultiplatformapp.composeapp.generated.resources.trophy_logo
import org.jetbrains.compose.resources.vectorResource
import ui.theme.Blue

@Composable
fun LocationsScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(Blue)
    ) {
        var scale by remember { mutableStateOf(1.5f) }
        var translationX by remember { mutableStateOf(0f) }
        var translationY by remember { mutableStateOf(0f) }
        Image(
            imageVector = vectorResource(Res.drawable.blue_map),
            "Blue map",
            colorFilter = ColorFilter.tint(Blue, blendMode = BlendMode.Exclusion),
            modifier = Modifier
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    translationX = translationX,
                    translationY = translationY
                )
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoom, _ ->
                        scale = (scale * zoom).coerceIn(1f, 10f)
                        translationX += pan.x * scale
                        translationY += pan.y * scale
                    }
                }
        )
    }
}