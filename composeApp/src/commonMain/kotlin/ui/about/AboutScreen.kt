package ui.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import exampledevlanekotlinmultiplatformapp.composeapp.generated.resources.Res
import exampledevlanekotlinmultiplatformapp.composeapp.generated.resources.clutch_logo
import exampledevlanekotlinmultiplatformapp.composeapp.generated.resources.globe_logo
import exampledevlanekotlinmultiplatformapp.composeapp.generated.resources.latam_logo
import exampledevlanekotlinmultiplatformapp.composeapp.generated.resources.ratings_logo
import exampledevlanekotlinmultiplatformapp.composeapp.generated.resources.trophy_logo
import org.jetbrains.compose.resources.vectorResource
import ui.theme.Blue
import ui.theme.Purple40

@Composable
fun AboutScreen() {
    val launch = LocalUriHandler.current
    Column (
        modifier = Modifier.fillMaxSize().padding(8.0.dp).verticalScroll(rememberScrollState())
    ) {
        Text("Take the Smart Lane to scale your team with LatAm devs.",
            color = Purple40, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.height(8.0.dp))
        Text("Worry about goals, not hires. Partner with staff augmentation experts that provide you the right fit for your company, without the hassle of traditional nearshoring or freelancers.")
        Spacer(Modifier.height(8.0.dp))
        Text("Thriving with Companies Who Choose Us",
            color = Color.Blue, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.height(8.0.dp))
        Text("We are the preferred choice of the most forward-thinking companies for building and managing their nearshore development teams.")
        Spacer(Modifier.height(8.0.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1.0f).clickable {
                    launch.openUri("https://clutch.co/companies/devlane")
                }
            ) {
                Image(
                    imageVector = vectorResource(Res.drawable.clutch_logo),
                    "Clutch logo",
                    modifier = Modifier.height(60.dp).width(60.dp),
                    colorFilter = ColorFilter.tint(Color.Black)
                )
                Spacer(Modifier.height(8.0.dp))
                Image(
                    imageVector = vectorResource(Res.drawable.ratings_logo),
                    "Ratings logo",
                    modifier = Modifier.height(12.dp).width(60.dp),
                    colorFilter = ColorFilter.tint(Color.Black)
                )
                Spacer(Modifier.height(8.0.dp))
                Text("CLUTCH")
                Text("5.0")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1.0f).clickable {
                    launch.openUri("https://clutch.co/it-services/staff-augmentation")
                }
                ) {
                Image(
                    imageVector = vectorResource(Res.drawable.globe_logo),
                    "World logo",
                    modifier = Modifier.height(60.dp).width(60.dp),
                    colorFilter = ColorFilter.tint(Color.Black)
                )
                Spacer(Modifier.height(8.0.dp))
                Text("WORLD TOP 5")
                Text("Staff augmentation")
                Text("companies")
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1.0f).clickable {
                    launch.openUri("https://clutch.co/it-services/staff-augmentation?geona_id=40819")
                }
            ) {
                Image(
                    imageVector = vectorResource(Res.drawable.latam_logo),
                    "Latam logo",
                    modifier = Modifier.height(60.dp).width(60.dp),
                    colorFilter = ColorFilter.tint(Color.Black)
                )
                Spacer(Modifier.height(8.0.dp))
                Text("Latam TOP 3")
                Text("Staff augmentation")
                Text("companies")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1.0f).clickable {
                    launch.openUri("https://clutch.co/press-releases/Clutch-100-fastest-growing-companies-2023")
                }
            ) {
                Image(
                    imageVector = vectorResource(Res.drawable.trophy_logo),
                    "Trophy logo",
                    modifier = Modifier.height(60.dp).width(60.dp),
                    colorFilter = ColorFilter.tint(Color.Black)
                )
                Spacer(Modifier.height(8.0.dp))
                Text("2023 TOP 15")
                Text("Fastest-Growing")
                Text("companies")
            }
        }
        Button(
            onClick = {
                launch.openUri("mailto:contact@devlane.com?subject=Contact+Us")
            },
            colors = ButtonColors( Blue, Color.White, Blue, Color.White),
            modifier = Modifier.align(CenterHorizontally)
        ) {
            Text("Contact Us", fontSize = 20.sp)
        }
    }
}