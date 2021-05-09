package ru.agladkov.navigationexample.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ru.agladkov.navigationexample.R
import ru.agladkov.navigationexample.navigation.Screen

@Composable
fun NewMessageScreen() {
    Scaffold(
        topBar = {
            TopAppBar {
                Text(text = stringResource(id = R.string.title_message))
            }
        }
    ) {
        Text("Write new message here")
    }
}