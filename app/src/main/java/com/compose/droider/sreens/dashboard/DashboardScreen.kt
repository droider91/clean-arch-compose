package com.compose.droider.sreens.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.compose.droider.models.ToDoPresentation
import com.compose.droider.screen_tags.Screens

@Composable
fun DashboardScreen(
    navController: NavController,
    dashboardViewModel: DashboardViewModel = viewModel()
) = Box(
    Modifier
        .fillMaxWidth()
        .fillMaxHeight()
) {
    BuildToolBar(dashboardViewModel, navController)
}

@Composable
fun BuildToolBar(dashboardViewModel: DashboardViewModel, navController: NavController) {
    Column() {
        TopAppBar(title = {
            Text(
                text = "Events Calendar", color = Color.White, modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )
        }, backgroundColor = Color.Red, actions = {
            IconButton(onClick = {
                navController.navigate(Screens.todoScreen) {
                }
            }) {
                Icon(Icons.Default.Add, "")
            }
            IconButton(onClick = {
                dashboardViewModel.getAllToDos()
            }) {
                Icon(Icons.Default.Refresh, "")
            }
        })
        DisplayToDoList(todos = dashboardViewModel.data.map {
            ToDoPresentation(
                it.id,
                it.todo
            )
        })
    }

}

@Composable
fun DisplayToDoList(todos: List<ToDoPresentation>) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp)
    ) {
        items(todos, key = null) { item ->
            Text(text = item.todo)
            Divider()
        }
    }
}
