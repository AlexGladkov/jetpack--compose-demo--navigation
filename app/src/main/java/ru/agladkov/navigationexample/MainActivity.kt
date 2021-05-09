package ru.agladkov.navigationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.agladkov.navigationexample.navigation.EnterAnimation
import ru.agladkov.navigationexample.navigation.Screen
import ru.agladkov.navigationexample.screens.MainScreen
import ru.agladkov.navigationexample.screens.NewMessageScreen
import ru.agladkov.navigationexample.ui.theme.NavigationExampleTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screen.Main.screenName) {
                        composable(Screen.Main.screenName) { MainScreen(navController) }
                        composable(Screen.NewMessage.screenName) {
                            EnterAnimation {
                                NewMessageScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationExampleTheme {
        Greeting("Android")
    }
}