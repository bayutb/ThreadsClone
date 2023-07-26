package com.bayutb.threadsclone.ui.screens

sealed class Screen(val route : String) {
    object Home: Screen(SCREEN_HOME)
    object Activity: Screen(SCREEN_ACTIVITY)
    object Profile: Screen(SCREEN_PROFILE)
    object Search: Screen(SCREEN_SEARCH)

    companion object {
        private const val SCREEN_HOME = "home"
        private const val SCREEN_ACTIVITY = "activity"
        private const val SCREEN_PROFILE = "profile"
        private const val SCREEN_SEARCH = "search"
    }
}