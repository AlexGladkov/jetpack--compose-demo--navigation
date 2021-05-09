package ru.agladkov.navigationexample.navigation

import ru.agladkov.navigationexample.R
import ru.agladkov.navigationexample.screens.UserModel

/**
 * This class described screen navigation objects
 * @param screenName - deeplink screen representation
 * @param titleResourceId - resource to name tabbar or appbar navigation title
 */
sealed class Screen(val screenName: String, val titleResourceId: Int) {
    object Main: Screen("main", -1)
    object User: Screen("user", -1)
    object List: Screen("list", R.string.title_list)
    object Complex: Screen("complex", R.string.title_complex)
    object Push: Screen("push", R.string.title_push)
    object NewMessage: Screen("new_message", R.string.title_message)
}