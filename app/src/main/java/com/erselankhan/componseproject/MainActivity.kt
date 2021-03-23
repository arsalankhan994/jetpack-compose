package com.erselankhan.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.erselankhan.componseproject.component.EmailTextField
import com.erselankhan.componseproject.component.LoginView
import com.erselankhan.composeproject.component.SimpleClickableText
import com.erselankhan.composeproject.ui.theme.ComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    LoginView()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeProjectTheme {
        Greeting("Android")
    }
}