package ru.agladkov.navigationexample.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import ru.agladkov.navigationexample.navigation.NavigationController
import ru.agladkov.navigationexample.navigation.Router
import ru.agladkov.navigationexample.navigation.Screen

@ExperimentalAnimationApi
@Composable
fun ListContainer(
    externalRouter: Router
) {
    NavigationController(
        startDestination = Screen.List.screenName,
        router = externalRouter,
        screens = listOf(
            Pair(Screen.List.screenName, { nav, router, _ -> ListScreen(router, nav) }),
            Pair(Screen.User.screenName, { _, _, params ->
                params?.getParcelable<UserModel>(UserModel.USER)?.let {
                    UserScreen(model = it)
                }
            })
        )
    )
}