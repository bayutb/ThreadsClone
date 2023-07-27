package com.bayutb.threadsclone.ui.screens.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayutb.threadsclone.data.DataDummy
import com.bayutb.threadsclone.data.UserRecommendations
import com.bayutb.threadsclone.ui.screens.search.components.RecommendationList
import com.bayutb.threadsclone.ui.screens.search.components.SearchList
import com.bayutb.threadsclone.ui.screens.search.components.TopAppBar
import com.bayutb.threadsclone.ui.theme.ThreadsCloneTheme
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun SearchScreen(modifier: Modifier = Modifier, data: List<UserRecommendations>) {
    var searchFor by remember { mutableStateOf("") }
    var focusState by remember { mutableStateOf(false) }
    Scaffold(topBar = {
        TopAppBar(modifier = modifier,
            onFocusChange = { focusState = it },
            onValueChange = { searchFor = it }
        )
    }) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            AnimatedVisibility(visible = focusState) {
                LazyColumn(content = {
                    items(5) {
                        SearchList(
                            data = UserRecommendations(
                                id = it,
                                name = searchFor,
                                userId = "$searchFor${
                                    Random.nextInt(
                                        1,
                                        100
                                    )
                                }".replace("\\s".toRegex(), "").lowercase(),
                                followers = 100,
                                mutual = 2
                            )
                        )
                    }
                })
            }
            AnimatedVisibility(visible = !focusState) {
                LazyColumn(content = {
                    items(data) {
                        RecommendationList(data = it)
                    }
                })
            }
        }
    }
}

@Preview(
    showBackground = true, device = "id:pixel_5"
)
@Composable
fun PreviewSearchScreen() {
    ThreadsCloneTheme {
        DataDummy.generate()
        SearchScreen(data = DataDummy.recommendedUser)
    }
}