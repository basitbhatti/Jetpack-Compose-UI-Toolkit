package com.basitbhatti.compose.ui.library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.basitbhatti.compose.ui.library.ui.components.Alert
import com.basitbhatti.compose.ui.library.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {

                var visible by remember { mutableStateOf(false) }

                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                    Button(
                        onClick = {
                            visible = !visible
                        }
                    ) {
                        Text("Delete")
                    }

                    Alert(
                        visible = visible,
                        icon = {
                            Icon(painter = painterResource(R.drawable.delete), modifier = Modifier.size(35.dp), contentDescription =  "Delete")
                        },
                        title = {
                            Text("Delete this file?")
                        },
                        body = {
                            Text("This action cannot be undone!")
                        },
                        positiveButton = {
                            Button(onClick = {
                                visible = !visible
                            }) {
                                Text("Delete")
                            }
                        },
                        negativeButton = {
                            Button(onClick = {
                                visible = !visible
                            }) {
                                Text("Cancel")
                            }
                        },
                        neutralButton = {}

                    )


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Greeting("Android")
    }
}