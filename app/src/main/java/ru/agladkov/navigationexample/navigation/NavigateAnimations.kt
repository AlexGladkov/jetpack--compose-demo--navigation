package ru.agladkov.navigationexample.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@ExperimentalAnimationApi
@Composable
fun PresentModal(content: @Composable () -> Unit) {
    AnimatedVisibility(
        visible = true,
        enter = slideInVertically(initialOffsetY = { 50 }) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + fadeOut(),
        content = content,
        initiallyVisible = false
    )
}

@ExperimentalAnimationApi
@Composable
fun PresentNested(content: @Composable () -> Unit) {
    AnimatedVisibility(
        visible = true,
        enter = slideInHorizontally(initialOffsetX = { it }) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutHorizontally() + fadeOut(),
        content = content,
        initiallyVisible = false
    )
}