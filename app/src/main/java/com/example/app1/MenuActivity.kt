package com.example.app1

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.app1.ui.theme.App1Theme

class MenuActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            App1Theme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MenuSample()
                }
            }
        }
    }
}

@Preview
@Composable
fun MenuSample() {


    var expanded by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .wrapContentSize(Alignment.TopStart)
    ) {
        IconButton(onClick = { expanded = true }) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {

                DropdownMenuItem(text = { Text(text = "Edit") },
                    onClick = { /*TODO*/ },
                    leadingIcon = { Icon(Icons.Outlined.Edit, contentDescription = "") })
                DropdownMenuItem(text = { Text(text = "Settings") },
                    onClick = { /*TODO*/ },
                    leadingIcon = { Icon(Icons.Outlined.Settings, contentDescription = "") })
                Divider()
                DropdownMenuItem(text = { Text(text = "Send Feedback") },
                    onClick = { /*TODO*/ },
                    leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = "") },
                    trailingIcon = {
                        Text(
                            text = "F11", textAlign = TextAlign.Center
                        )
                    })

            }


        }
    }
}

@Preview
@Composable
fun MenuWithScrollStateSample() {
    var expanded by remember {
        mutableStateOf(false)
    }
    var scrollState = rememberScrollState()
    Box(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.TopStart)){
        IconButton(onClick = {expanded=true}) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
            
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded=false }) {
            
        }
    }
}