package com.bayutb.threadsclone.ui.screens.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bayutb.threadsclone.R
import com.bayutb.threadsclone.data.DataDummy
import com.bayutb.threadsclone.data.Post
import com.bayutb.threadsclone.ui.screens.home.components.HomePost
import com.bayutb.threadsclone.ui.screens.profile.components.TopAppBar
import com.bayutb.threadsclone.ui.theme.ThreadsCloneTheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val user = DataDummy.user
    var tabIndex by remember {
        mutableStateOf(0)
    }
    val tabs = listOf("Threads", "Replies")
    Scaffold(
        topBar = {
            TopAppBar(modifier)
        }
    ) {
        Box(
            modifier = modifier
                .padding(it)
                .fillMaxWidth()
        ) {
            Column {
                Column(
                    modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Row {
                        Column(modifier = modifier.weight(1f)) {
                            Text(
                                text = user.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = user.userId,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Box(
                                    modifier = modifier
                                        .background(
                                            color = Color.LightGray,
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .padding(8.dp, 4.dp)
                                ) {
                                    Text(text = "threads.net", fontSize = 10.sp, color = Color.Gray)
                                }
                            }
                        }
                        Box(contentAlignment = Alignment.BottomStart) {
                            Image(
                                painter = painterResource(id = R.drawable.profile),
                                contentDescription = "Profile Picture",
                                modifier = modifier.size(65.dp)
                            )
                            if (user.isVerified) {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_verified_24),
                                    contentDescription = "Verified",
                                    modifier.background(
                                        color = Color.White,
                                        shape = CircleShape
                                    ),
                                    colorFilter = ColorFilter.tint(
                                        color = colorResource(
                                            id = R.color.verified_blue
                                        )
                                    )
                                )
                            }
                        }
                    }
                    Text(text = user.description ?: "", fontSize = 14.sp)
                    Row(
                        modifier.padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box {
                            Image(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                modifier = modifier
                                    .padding(start = 0.dp)
                                    .clip(
                                        CircleShape
                                    )
                                    .size(16.dp)
                                    .background(color = MaterialTheme.colorScheme.primaryContainer)
                            )
                            Image(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                modifier = modifier
                                    .padding(start = 8.dp)
                                    .clip(
                                        CircleShape
                                    )
                                    .size(16.dp)
                                    .background(color = MaterialTheme.colorScheme.primaryContainer)
                            )
                        }
                        Text(text = "${user.followers} followers", color = Color.Gray, fontSize = 14.sp)

                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier
                                .weight(1f)
                                .height(40.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = MaterialTheme.colorScheme.primary
                            ),
                            border = ButtonDefaults.outlinedButtonBorder,
                            shape = RoundedCornerShape(12.dp),
                        ) {
                            Text(text = "Edit profile")
                        }
                        Button(
                            onClick = { /*TODO*/ },
                            modifier
                                .weight(1f)
                                .height(40.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = MaterialTheme.colorScheme.primary
                            ),
                            border = ButtonDefaults.outlinedButtonBorder,
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(text = "Share profile")
                        }
                    }

                }
                TabRow(
                    selectedTabIndex = tabIndex,
                    contentColor = MaterialTheme.colorScheme.primary,
                    containerColor = MaterialTheme.colorScheme.surface
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            text = { Text(title) },
                            selected = tabIndex == index,
                            onClick = { tabIndex = index },
                            selectedContentColor = MaterialTheme.colorScheme.primary,
                            unselectedContentColor = MaterialTheme.colorScheme.primary
                        )
                    }
                }
                when (tabIndex) {
                    0 -> ThreadsList(posts = DataDummy.posts)
                    1 -> RepliesList()
                }
            }

        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun ThreadsList(
    modifier: Modifier = Modifier,
    posts: List<Post>
) {
    val listState = rememberLazyListState()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LazyColumn(
            state = listState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(posts) {
                HomePost(post = it)
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun RepliesList(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxWidth()) {
            Text(text = "Replies List")
        }
    }
}


@Preview(
    showBackground = true,
    device = "id:pixel_5"
)
@Composable
fun PreviewProfileScreen() {
    ThreadsCloneTheme {
        DataDummy.generate()
        ProfileScreen()
    }
}