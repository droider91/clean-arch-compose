package com.compose.droider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.droider.sreens.dashboard.DashboardScreen
import com.compose.droider.sreens.dashboard.DashboardViewModel
import com.compose.droider.sreens.splash.SplashScreen
import com.compose.droider.sreens.todo.ToDoScreen
import com.compose.droider.sreens.todo.ToDoViewModel
import com.compose.droider.ui.theme.CleanComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val toDoViewModel by viewModels<ToDoViewModel>()

    @Composable
    fun RunSplashScreen() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "splashScreen") {
            composable(route = "splashScreen") {
                SplashScreen(navController = navController)
            }

            composable(route = "dashboardScreen") {
                val dashboardViewModel by viewModels<DashboardViewModel>()
                DashboardScreen(navController = navController, dashboardViewModel)
            }
            composable(route = "todoScreen") {
                ToDoScreen(navController = navController, toDoViewModel = toDoViewModel)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RunSplashScreen()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    CleanComposeTheme {
        Greeting("Android")
    }
}