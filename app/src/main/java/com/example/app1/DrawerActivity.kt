package com.example.app1

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app1.ui.theme.App1Theme
import kotlinx.coroutines.launch

class DrawerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App1Theme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //ModalNavigationDrawerSample()
                    //PermanentNavigationDrawerSample()
                    DismissibleNavigationDrawerSample()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ModalNavigationDrawerSample() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
    val selectedItem = remember {
        mutableStateOf(items[0])
    }
    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet {
            Spacer(modifier = Modifier.height(12.dp))
            items.forEach { item ->
                NavigationDrawerItem(
                    icon = { Icon(item, "Item") },
                    label = { Text(text = item.name) },
                    selected = item == selectedItem.value,
                    onClick = {
                        scope.launch { drawerState.close() }
                        selectedItem.value = item
                    }, modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }
        }
    }, content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
            Spacer(Modifier.height(20.dp))
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text("Click to open")
            }
        }
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PermanentNavigationDrawerSample() {
    val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
    val selectedItem = remember {
        mutableStateOf(items[0])
    }

    PermanentNavigationDrawer(drawerContent = {
        PermanentDrawerSheet(Modifier.width(240.dp)) {
            Spacer(modifier = Modifier.height(12.dp))
            items.forEach { item ->
                NavigationDrawerItem(
                    icon = { Icon(imageVector = item, contentDescription = null) },
                    label = { Text(text = item.name) },
                    selected = item == selectedItem.value,
                    onClick = { selectedItem.value = item },
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            }

        }
    }, content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Application content")
        }
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DismissibleNavigationDrawerSample() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
    val selectedItem = remember{
        mutableStateOf(items[0])
    }
    BackHandler(enabled = drawerState.isOpen) {
        scope.launch {
            drawerState.close()
        }
    }

    DismissibleNavigationDrawer(drawerState = drawerState, drawerContent = {
        DismissibleDrawerSheet {
            Spacer(modifier = Modifier.height(12.dp))
            items.forEach {
                NavigationDrawerItem(
                    icon = { Icon(it, contentDescription = null) },
                    label = { Text(text = it.name) },
                    selected = it == selectedItem.value,
                    onClick = {
                        scope.launch { drawerState.close() }
                        selectedItem.value = it
                    },
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            }
        }
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = if (drawerState.isClosed) ">>>Swipe>>>" else "<<<Swipe<<<")
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text(text = "Click to Open")
            }
        }
    }
}