package com.example.app1

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.app1.ui.theme.App1Theme

class TabActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            App1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PrimaryTextTabs()
                }
            }
        }
    }
}

@Preview
@Composable
fun PrimaryTextTabs() {
    var state by remember {
        mutableStateOf(0)
    }
    val titles = listOf("Tab1", "Tab2", "Tab3 with lots of text")
    Column {
        TabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(selected = state == index,
                    onClick = {state=index},
                    text = { Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis)}
                    )
            }
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Primary tab ${state + 1} selected",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}