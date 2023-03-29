package com.compose.droider.sreens.todo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.compose.droider.screen_tags.Screens

@Composable
fun ToDoScreen(navController: NavController, toDoViewModel: ToDoViewModel) = Box(
    Modifier
        .fillMaxWidth()
        .fillMaxHeight()
) {
    BuildToolBar(navController, toDoViewModel)
}

@Composable
fun BuildToolBar(navController: NavController, toDoViewModel: ToDoViewModel) {
    Column() {
        TopAppBar(title = {
            Text(
                text = "Add a note", color = Color.White, modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )
        }, backgroundColor = Color.Red)
        BuildTitlePlaceHolder()
        Card(
            Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .padding(12.dp),
            elevation = 4.dp,
            backgroundColor = Color.White,
        ) {
            BuildLoginForm(navController, toDoViewModel)
        }

    }
}

@Composable
fun BuildTitlePlaceHolder() = Box(
    Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(16.dp)
) {
    Text(
        text = "This is the simple compose program to explore " + "and understanding the framework",
        Modifier.fillMaxWidth(),
        color = Color.Red,
        fontSize = 18.sp
    )
}

@Composable
fun BuildLoginForm(navController: NavController, toDoViewModel: ToDoViewModel) = Column(
    Modifier
        .fillMaxWidth()
        .height(220.dp)
        .padding(16.dp)

) {
    var text by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    TextField(
        value = text,
        placeholder = { Text(text = "Enter a note") },
        onValueChange = {
            text = it
            toDoViewModel.onTitleChange(text)
        }, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .weight(1f),
        label = {
        }
    )
    Button(
        onClick = {
            toDoViewModel.addTask()
            navController.navigate(Screens.dashboardScreen) {

            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color.Black)

            .weight(1f),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            contentColor = Color.Red
        )
    ) {
        Text(text = "Save", color = Color.Red)
    }
}