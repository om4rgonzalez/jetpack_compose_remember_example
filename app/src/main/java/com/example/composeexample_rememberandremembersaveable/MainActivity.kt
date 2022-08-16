package com.example.composeexample_rememberandremembersaveable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeexample_rememberandremembersaveable.ui.theme.ComposeExampleRememberAndRememberSAveableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleRememberAndRememberSAveableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var nameState by remember {
        mutableStateOf("")
    }

    var name by rememberSaveable {
        mutableStateOf("")
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center) {
        Text(text = "Hello $name")

        Spacer(modifier = Modifier.height(20.dp))

        TextField(value = nameState, onValueChange = {
            nameState = it
        })

        Button(onClick = {
        name = nameState
        }) {
            Text(text = "Display")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeExampleRememberAndRememberSAveableTheme {
        Greeting("Android")
    }
}