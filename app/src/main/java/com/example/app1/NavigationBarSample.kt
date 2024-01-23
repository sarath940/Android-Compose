package com.example.app1

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app1.ui.theme.App1Theme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class NavigationBarSampleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            App1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationBarSampleContent()
                }
            }
        }
    }

    @Preview
    @Composable
    fun NavigationBarSampleContent() {
        var selectedItem by remember { mutableStateOf(0) }
        val items = listOf("Songs", "Artists", "Playlists")

        NavigationBar {
            items.forEachIndexed { index, s ->
                NavigationBarItem(
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = s) },
                    label = { Text(text = s) }
                )
            }
        }
    }
}
