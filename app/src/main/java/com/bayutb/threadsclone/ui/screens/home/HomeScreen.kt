package com.bayutb.threadsclone.ui.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bayutb.threadsclone.R
import com.bayutb.threadsclone.data.DataDummy
import com.bayutb.threadsclone.data.Post
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
        LazyColumn(state = listState) {
            item {
                Header(fabVisibility = fabVisibility)
            }
            items(posts) {
                ItemPost(post = it)
            }
        }
    }
}

@Composable
fun Header(fabVisibility: Boolean, modifier: Modifier = Modifier) {
    Log.d("Status", "Tes $fabVisibility")
    val density = LocalDensity.current
    AnimatedVisibility(modifier = modifier,
        visible = fabVisibility  ,
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

@Composable
fun ItemPost(modifier: Modifier = Modifier, post: Post) {

    Column(Modifier.height(IntrinsicSize.Max)) {
        Row(Modifier.fillMaxWidth()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .padding(end = 8.dp)
                    .fillMaxHeight()
            ) {
                Box(contentAlignment = Alignment.BottomEnd) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_account_circle_24),
                        contentDescription = null,
                        modifier = modifier
                            .size(48.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "add",
                        modifier = modifier
                            .size(24.dp)
                            .background(
                                MaterialTheme.colorScheme.surface, shape = CircleShape
                            )
                    )
                }
                Divider(
                    color = Color.Gray,
                    modifier = modifier
                        .width(2.dp)
                        .weight(1f)
                )
                Row(verticalAlignment = Alignment.Bottom)
                {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_account_circle_24),
                        contentDescription = null,
                        modifier = modifier
                            .size(16.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.baseline_account_circle_24),
                        contentDescription = null,
                        modifier = modifier
                            .size(24.dp)
                    )

                }
                Image(
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    contentDescription = null,
                    modifier = modifier
                        .size(12.dp)
                )
            }
            Column(
                modifier = modifier.padding(vertical = 8.dp),
            ) {
                Row(horizontalArrangement = Arrangement.Absolute.Right) {
                    Row(modifier.weight(1f)) {
                        Text(
                            text = post.user,
                            modifier.padding(end = 4.dp),
                            fontWeight = FontWeight.SemiBold
                        )

                        Image(
                            painter = painterResource(id = R.drawable.baseline_verified_24),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Color.Blue),
                        )

                    }
                    Text(text = "6m", Modifier.padding(end = 8.dp), color = Color.Gray)
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_more_horiz_24),
                        contentDescription = "More"
                    )
                }
                Text(
                    text = post.content,
                    modifier.padding(bottom = 8.dp)
                )

                if (post.embeddedContent != null) {
                    ElevatedCard(
                        modifier = modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 0.8.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface,

                            )
                    ) {
                        Column(
                            modifier.padding(16.dp, 8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = modifier.weight(1f)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.baseline_account_circle_24),
                                        contentDescription = null,
                                        modifier = modifier.size(30.dp)
                                    )
                                    post.embeddedUser?.let {
                                        Text(
                                            modifier = modifier.padding(start = 8.dp),
                                            text = it, fontWeight = FontWeight.SemiBold
                                        )
                                    }
                                }
                                Text(text = "12m", Modifier.padding(end = 8.dp), color = Color.Gray)
                            }
                            Text(text = post.embeddedContent)
                            Text(text = "${post.embeddedLikes} likes", color = Color.Gray)
                        }
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = modifier.padding(top = 16.dp)
                ) {
                    Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Like")
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_chat_bubble_outline_24),
                        contentDescription = "Comment"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_loop_24),
                        contentDescription = "Retweet"
                    )
                    Icon(imageVector = Icons.Default.Send, contentDescription = "Send")
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {

                    Text(text = "${post.replies} replies", color = Color.Gray)
                    Image(
                        painter = painterResource(id = R.drawable.baseline_brightness_1_24),
                        contentDescription = null,
                        modifier = modifier.size(4.dp),
                        colorFilter = ColorFilter.tint(Color.Gray)
                    )
                    Text(text = "${post.postLikes} likes", color = Color.Gray)
                }
            }
        }
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