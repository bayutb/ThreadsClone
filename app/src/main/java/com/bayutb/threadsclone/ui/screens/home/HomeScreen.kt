package com.bayutb.threadsclone.ui.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bayutb.threadsclone.data.DataDummy
import com.bayutb.threadsclone.data.Post
import com.bayutb.threadsclone.ui.screens.home.components.HomePost
import com.bayutb.threadsclone.ui.theme.ThreadsCloneTheme

@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    posts: List<Post>
) {
    val listState = rememberLazyListState()
    val fabVisibility by derivedStateOf {
        listState.firstVisibleItemIndex == 0
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LazyColumn(state = listState, verticalArrangement = Arrangement.spacedBy(8.dp)) {
            item {
                Header(fabVisibility = fabVisibility)
            }
            items(posts) {
                HomePost(post = it)
            }
        }
    }
}

@Composable
fun Header(fabVisibility: Boolean, modifier: Modifier = Modifier) {
    Log.d("Status", "Tes $fabVisibility")
    val density = LocalDensity.current
    AnimatedVisibility(modifier = modifier,
        visible = fabVisibility,
        enter = slideInVertically {
            with(density) { -40.dp.roundToPx() }
        } + fadeIn(),
        exit = fadeOut(
            animationSpec = keyframes {
                this.durationMillis = 120
            }
        )) {

        Text(
            text = "@",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()
        )

    }
}



@Preview(
    showBackground = true,
    device = "id:pixel_5"
)
@Composable
fun PreviewHomeScreen() {
    ThreadsCloneTheme {
        DataDummy.generate()
        HomeScreen(posts = DataDummy.posts)
    }
}