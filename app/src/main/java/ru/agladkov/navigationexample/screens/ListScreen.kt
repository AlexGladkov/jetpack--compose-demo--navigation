package ru.agladkov.navigationexample.screens

import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import kotlinx.android.parcel.Parcelize
import ru.agladkov.navigationexample.R
import ru.agladkov.navigationexample.navigation.Router
import ru.agladkov.navigationexample.navigation.Screen
import ru.agladkov.navigationexample.navigation.navigate
import java.util.UUID

@Parcelize
data class UserModel(
    val userId: String = UUID.randomUUID().toString(),
    val username: String,
    val education: String? = null
): Parcelable {

    companion object Keys {
        const val USER = "user"
    }
}

@Composable
fun ListScreen(
    router: Router?,
    navController: NavController
) {
    val testData = listOf(
        UserModel(username = "Ivan Ivan"),
        UserModel(username = "Steve Jobs", education = "MIT"),
        UserModel(username = "Bill Gates"),
        UserModel(username = "Mark Zuckerberg", education = "Harvard"),
        UserModel(username = "Jack Wharton"),
        UserModel(username = "Roman Elizarov", education = "SPBGU")
    )

    Scaffold(
        topBar = {
            TopAppBar {
                Text(stringResource(id = Screen.List.titleResourceId))
            }
        }
    ) {
        LazyColumn {
            testData.forEach { user ->
                item {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(Screen.User.screenName, bundleOf(UserModel.USER to user))
                        }) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = user.username, fontWeight = FontWeight.Medium, color = Color.Blue)
                            user.education?.let {
                                Text(
                                    text = it,
                                    color = Color.DarkGray,
                                    modifier = Modifier.padding(top = 16.dp, end = 16.dp)
                                )
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(stringResource(id = R.string.action_message), color = Color.Blue, modifier = Modifier.clickable {
                                    router?.routeTo(Screen.NewMessage.screenName)
                                })
                            }
                        }
                    }
                }
            }
        }
    }
}