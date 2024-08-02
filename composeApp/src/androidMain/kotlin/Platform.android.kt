import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

@SuppressLint("StaticFieldLeak")
lateinit var mainContext: Context

fun createDataStore(context: Context): DataStore<Preferences> {
    mainContext = context
    return createDataStore(
        producePath = { context.filesDir.resolve(dataStoreFileName).absolutePath }
    )
}

actual fun shareText(text: String) {
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }

    mainContext.startActivity(Intent.createChooser(shareIntent, text))
}