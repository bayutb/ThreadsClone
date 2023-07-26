package com.bayutb.threadsclone

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bayutb.threadsclone.data.DataDummy
import com.bayutb.threadsclone.ui.components.BottomBarIcon
import com.bayutb.threadsclone.ui.screens.Screen
import com.bayutb.threadsclone.ui.screens.activity.ActivityScreen
import com.bayutb.threadsclone.ui.screens.home.HomeScreen
import com.bayutb.threadsclone.ui.screens.profile.ProfileScreen
import com.bayutb.threadsclone.ui.screens.search.SearchScreen
import com.bayutb.threadsclone.ui.theme.ThreadsCloneTheme

@Composable
fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        BottomBar(modifier, navController)
    }) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier.padding(
                it
            )
        ) {
            composable(Screen.Home.route) {
                HomeScreen(posts = DataDummy.posts)
            }
            composable(Screen.Activity.route) {
                ActivityScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(Screen.Search.route) {
                SearchScreen()
            }
        }
    }
}

@Composable
fun BottomBar(modifier: Modifier, navController: NavController) {
    Row(
        modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = {
            navController.navigate(Screen.Home.route)
        }) {
            Icon(imageVector = BottomBarIcon.Home.vector, contentDescription = "Home")
        }
        IconButton(onClick = {
            navController.navigate(Screen.Search.route)
        }) {
            Icon(imageVector = BottomBarIcon.Search.vector, contentDescription = "Search")
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = BottomBarIcon.Add.vector, contentDescription = "Add")
        }
        IconButton(onClick = {
            navController.navigate(Screen.Activity.route)
        }) {
            Icon(imageVector = BottomBarIcon.Favourite.vector, contentDescription = "Favourite")
        }
        IconButton(onClick = {
            navController.navigate(Screen.Profile.route)
        }) {
            Icon(imageVector = BottomBarIcon.Profile.vector, contentDescription = "Profile")
        }
    }
}

@Preview(
    showBackground = true,
    device = "id:pixel_5"
)
@Composable
fun PreviewApp() {
    ThreadsCloneTheme {
        DataDummy.generate()
        App()
    }
}

@Preview(
    showBackground = true,
    device = "id:pixel_5"
)
@Composable
fun PreviewHome() {
    ThreadsCloneTheme {
        DataDummy.generate()
        ProfileScreen()
    }
}

@Preview(
    showBackground = true,
    device = "id:pixel_5"
)
@Composable
fun PreviewProfile() {
    ThreadsCloneTheme {
        ActivityScreen()
    }
}

@Preview(
    showBackground = true,
    device = "id:pixel_5"
)
@Composable
fun PreviewSearch() {
    ThreadsCloneTheme {
        SearchScreen()
    }
}