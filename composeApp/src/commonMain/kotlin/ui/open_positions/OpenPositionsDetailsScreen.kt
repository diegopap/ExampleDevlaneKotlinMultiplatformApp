package ui.open_positions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.openPositions
import shareText
import ui.theme.Blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpenPositionsDetailsScreen(
    index: Int,
    onBack: () -> Unit
) {
    val position = openPositions[index]
    val launch = LocalUriHandler.current
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("Job Details") },
                navigationIcon = {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack, "Back",
                        modifier = Modifier.clickable {
                            onBack()
                        })
                },
                actions = {
                    Icon(Icons.Filled.Share, "Share", modifier = Modifier.clickable {
                            shareText(position.url)
                        }
                    )
                }
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth().padding(8.0.dp, 0.dp, 8.0.dp, 24.0.dp)
            ) {
                Button(
                    onClick = {
                        launch.openUri("mailto:contact@devlane.com?subject=Apply+Now")
                    },
                    colors = ButtonColors( Blue, Color.White, Blue, Color.White),
                    modifier = Modifier.weight(1f).align(CenterVertically)
                ) {
                    Text("Apply Now!", fontSize = 20.sp)
                }
                Spacer(Modifier.width(8.0.dp))
                Button(
                    onClick = {
                        launch.openUri("mailto:contact@devlane.com?subject=Refer+a+Friend")
                    },
                    colors = ButtonColors( Blue, Color.White, Blue, Color.White),
                    modifier = Modifier.weight(1f).align(CenterVertically)
                ) {
                    Text("Refer a Friend!", fontSize = 20.sp)
                }
            }
        }
    ) {
        paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).verticalScroll(rememberScrollState()).padding(8.0.dp)
        ) {
            Text("WE'RE HIRING", fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally))
            Row {
                Text("Title: ", fontWeight = FontWeight.Bold)
                Text(position.title)
            }
            Row {
                Text("Tech Stack: ", fontWeight = FontWeight.Bold)
                Text(position.stack)
            }
            Row {
                Text("Employment: ", fontWeight = FontWeight.Bold)
                Text("Full time")
            }
            Row {
                Text("Experience: ", fontWeight = FontWeight.Bold)
                Text("${position.experienceYears} years")
            }
            Row {
                Text("Client: ", fontWeight = FontWeight.Bold)
                Text(position.client.capitalize(Locale.current))
            }
            Row {
                Text("Industry: ", fontWeight = FontWeight.Bold)
                Text(position.industry)
            }
            Text("Welcome to Devlane!", fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text("""We are a dynamic software development company with a strong presence across Latin America. Currently, we specialize in offering staff augmentation services to clients worldwide, with a particular focus on North America.
Joining our team offers you the opportunity to shine and make a significant impact on the projects you work on. Many of our clients are modern small to medium-sized businesses experiencing rapid growth, and they're eager to add core members like you to their teams. This environment ensures you'll stay up-to-date with the latest technology trends.
At Devlane, our values are straightforward: we foster a collaborative environment and prioritize building long-lasting relationships where you can develop your skills as a software engineer and learn from your peers.""")
            position.description?.let {
                Text("What's the role about?", fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally))
                Text(it)
            }
            Text("What do we require from you", fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(position.requirements)
            Text("Some of our Perks", fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text("""✔ Salary in USD.
✔ 100% Remote
✔ 25 days of Paid Time Off per year.
✔ 8-hour workday, with flexible hours.
✔ Welcome kit from the brand.
✔ High-end hardware provided: laptop, mouse, & headphones.
✔ English classes, virtual library and online courses.
✔ Contribution bonuses

Ready to take the next step in your career?""")
            Text("Apply Now!", fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}