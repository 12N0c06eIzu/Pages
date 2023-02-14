package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    var human: String = "Player"
                    Greeting(human)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column() {


    Text(text = "Hello $name!")
    Text("kasanaru")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Column() {

        Greeting("Android")
        BottomNavigation()
        }
    }
}

@Composable
fun BottomNavigation() {

    var selectedItem = remember { mutableStateOf(0) }
    // Navigationの表示項目
    val items = listOf("Home", "Search", "Notification", "Settings")

    // BottomNavigation横幅
    BottomNavigation {
        // Sepalater　itemsの数、右に並ぶ
        items.forEachIndexed { index, item ->
            // Iconの設定
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                label = { Text(item) },
                selected = selectedItem.value == index,
                onClick = { selectedItem.value = index }
            )
        }
    }
}