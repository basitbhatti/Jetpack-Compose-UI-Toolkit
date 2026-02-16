package com.basitbhatti.compose.ui.library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.basitbhatti.compose.ui.library.ui.components.CustomIconAlert
import com.basitbhatti.compose.ui.library.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {

                var showAlert by remember { mutableStateOf(false) }

                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                    Button(
                        onClick = {
                            showAlert = !showAlert
                        }) {
                        Text("Delete")
                    }

                    CustomIconAlert(visible = showAlert, icon = {
                        Icon(
                            painter = painterResource(R.drawable.delete), contentDescription = ""
                        )
                    }, title = {
                        Text("Delete this file?")
                    }, body = {
                        Text("This action cannot be undone. The file will be permanently removed.")
                    }, positiveButton = {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFE70A0A)
                            ), onClick = {
                                showAlert = !showAlert
                            }) {
                            Text("Delete")
                        }
                    }, negativeButton = {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0x009D9D9D)
                            ), onClick = {
                                showAlert = !showAlert
                            }) {
                            Text("Cancel", color = Color.DarkGray)
                        }
                    })


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Greeting("Android")
    }
}