package ru.agladkov.navigationexample.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun UserScreen(
    model: UserModel
) {
    Text("User -> ${model.username}")
}