package ui.open_positions

data class OpenPosition (
    val id: Int,
    val title: String,
    val stack: String,
    val experienceYears: Int,
    val client: String,
    val industry: String,
    val description: String?,
    val requirements: String,
    val ableTo: String?,
    val url: String,
)