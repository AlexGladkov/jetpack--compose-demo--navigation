package ru.agladkov.navigationexample.screens

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import ru.agladkov.navigationexample.R
import ru.agladkov.navigationexample.navigation.Screen
import ru.agladkov.navigationexample.navigation.navigate

@Composable
fun MainScreen(
    globalNavigation: NavController
) {
    // Stored in memory NavHostController
    // Live through recompose and configuration changed cycle by rememberSaveable
    val navController = rememberNavController()
    val bottomItems = listOf(Screen.List, Screen.Complex, Screen.Push)

    Scaffold(
        bottomBar = {
            BottomNavigation {
                bottomItems.forEach { screen ->
                    BottomNavigationItem(
                        selected = false,
                        onClick = {
                            navController.navigate(screen.screenName) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo = navController.graph.startDestination

                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                            }
                        },
                        label = { Text(stringResource(id = screen.titleResourceId)) },
                        icon = {

                        })
                }
            }
        }
    ) {
        NavHost(navController = navController, startDestination = Screen.List.screenName) {
            composable(Screen.List.screenName) {
                ListScreen { screen, param ->
                    when (screen) {
                        Screen.NewMessage -> globalNavigation.navigate(screen.screenName)
                        else -> navController.navigate(route = screen.screenName, param = param)
                    }
                }
            }
            composable(Screen.Complex.screenName) { ComplexScreen(navController) }
            composable(Screen.Push.screenName) { PushScreen(navController) }
            composable(Screen.User.screenName) {
                navController.previousBackStackEntry?.arguments?.getParcelable<UserModel>(UserModel.USER)?.let {
                    UserScreen(navController, it)
                }
            }
        }
    }
}