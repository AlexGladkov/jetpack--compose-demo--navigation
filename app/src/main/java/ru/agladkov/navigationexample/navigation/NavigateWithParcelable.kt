package ru.agladkov.navigationexample.navigation

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.navigate

fun NavHostController.navigate(route: String, param: Pair<String, Parcelable>?, builder: NavOptionsBuilder.() -> Unit = {}) {
    param?.let { this.currentBackStackEntry?.arguments?.putParcelable(param.first, param.second)  }

    navigate(route, builder)
}

fun NavHostController.navigate(route: String, params: List<Pair<String, Parcelable>>?, builder: NavOptionsBuilder.() -> Unit = {}) {
    params?.let {
        val arguments = this.currentBackStackEntry?.arguments
        params.forEach { arguments?.putParcelable(it.first, it.second) }
    }

    navigate(route, builder)
}

fun NavHostController.navigate(route: String, params: Bundle?, builder: NavOptionsBuilder.() -> Unit = {}) {
    this.currentBackStackEntry?.arguments?.putAll(params)

    navigate(route, builder)
}