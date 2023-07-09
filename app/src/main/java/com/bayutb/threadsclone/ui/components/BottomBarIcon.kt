package com.bayutb.threadsclone.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarIcon(val vector: ImageVector) {
    object Home: BottomBarIcon(Icons.Default.Home)
    object Search: BottomBarIcon(Icons.Outlined.Search)
    object Add: BottomBarIcon(Icons.Outlined.Add)
    object Favourite: BottomBarIcon(Icons.Outlined.FavoriteBorder)
    object Profile: BottomBarIcon(Icons.Outlined.Person)

}