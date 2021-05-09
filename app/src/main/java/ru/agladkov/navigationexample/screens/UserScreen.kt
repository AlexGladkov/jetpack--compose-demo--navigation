package ru.agladkov.navigationexample.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun UserScreen(
    navController: NavController,
    model: UserModel
) {
    Text("User -> ${model.username}")
}