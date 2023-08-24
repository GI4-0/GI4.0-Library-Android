package com.example.gi

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gi.ui.theme.GI40LibraryExampleTheme
import de.roteliste.gi_lib.GI40Library

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GI40LibraryExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LibraryUsageExample()
                }
            }
        }
    }
}

@Composable
private fun LibraryUsageExample() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LibraryUsageExampleDefinition.values().forEach { definition ->
            Button(
                modifier = Modifier.padding(8.dp),
                onClick = { definition.onClick(context) }) {
                Text(text = stringResource(definition.buttonTextResource))
            }
        }
    }
}

enum class LibraryUsageExampleDefinition(@StringRes val buttonTextResource: Int) {
    SEARCH(R.string.button_text_search_function),
    SCAN(R.string.button_text_scan_function),
    HISTORY(R.string.button_text_history_function),
    PRODUCT(R.string.button_text_product_function);

    fun onClick(context: android.content.Context) {
        when (this) {
            SEARCH -> GI40Library.showSearch(context)
            SCAN -> GI40Library.startScan(context)
            HISTORY -> GI40Library.showHistory(context)
            PRODUCT -> GI40Library.showProduct(context, "04324188")
        }
    }
}

@Preview(name = "Light Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LibraryUsageExamplePreview() {
    GI40LibraryExampleTheme {
        Surface {
            LibraryUsageExample()
        }
    }
}