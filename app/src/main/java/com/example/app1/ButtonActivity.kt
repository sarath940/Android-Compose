package com.example.app1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app1.ui.theme.App1Theme

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App1Theme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    IconToggleButtonSample()
                }
            }
        }
    }
}

@Preview
@Composable
fun ButtonSample() {
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Button")
    }
}

@Preview
@Composable
fun ElevatedButtonSample() {
    ElevatedButton(onClick = { /*TODO*/ }) {
        Text(text = "Elevated Button")
    }
}

@Preview
@Composable
fun FilledTonalButtonSample() {
    FilledTonalButton(onClick = { /*TODO*/ }) {
        Text(text = "FilledTonalButton")
    }
}


@Preview
@Composable
fun OutlinedButtonSample() {
    OutlinedButton(onClick = { /* Do something! */ }) { Text("Outlined Button") }
}

@Preview
@Composable
fun TextButtonSample() {
    TextButton(onClick = { /* Do something! */ }) { Text("Text Button") }
}

@Preview
@Composable
fun ButtonWithIconSample() {
    Button(
        modifier = Modifier.size(100.dp, 40.dp),
        onClick = { /*TODO*/ },
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Localized description",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Like")
    }
}

@Preview
@Composable
fun IconButtonSample() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Outlined.Lock, contentDescription = "Lock")
    }
}

@Preview
@Composable
fun IconToggleButtonSample() {
    var checked by rememberSaveable {
        mutableStateOf(false)
    }
    IconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
        if (checked) {
            Icon(Icons.Filled.Lock, contentDescription = "Lock")
        } else {
            Icon(Icons.Outlined.Lock, contentDescription = "Un Lock")
        }
    }
}

@Preview
@Composable
fun FilledIconButtonSample() {
    FilledIconButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Outlined.Lock, contentDescription = "Lock")
    }
}

@Preview
@Composable
fun FilledIconToggleButtonSample() {
    var checked by rememberSaveable {
        mutableStateOf(false)
    }
    FilledIconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
        if (checked) {
            Icon(Icons.Filled.Lock, contentDescription = "Lock")
        } else {
            Icon(Icons.Outlined.Lock, contentDescription = "Un Lock")
        }
    }
}

@Preview
@Composable
fun FilledTonalIconButtonSample() {
    FilledTonalButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Outlined.Lock, contentDescription = "Lock")
    }
}

@Preview
@Composable
fun FilledTonalIconToggleButtonSample() {


    var checked by rememberSaveable {
        mutableStateOf(false)
    }
    FilledTonalIconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
        if (checked) {
            Icon(Icons.Filled.Lock, contentDescription = "Lock")
        } else {
            Icon(Icons.Outlined.Lock, contentDescription = "Un Lock")
        }
    }
}

@Preview
@Composable
fun OutlinedIconButtonSample() {
    OutlinedButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Outlined.Lock, contentDescription = "Lock")
    }
}

@Preview
@Composable
fun OutlinedToggleButtonSample() {
    var checked by rememberSaveable {
        mutableStateOf(false)
    }
    OutlinedIconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
        if (checked) {
            Icon(Icons.Filled.Lock, contentDescription = "Lock")
        } else {
            Icon(Icons.Outlined.Lock, contentDescription = "Un Lock")
        }
    }
}