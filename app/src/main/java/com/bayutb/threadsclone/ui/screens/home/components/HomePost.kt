package com.bayutb.threadsclone.ui.screens.home.components

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bayutb.threadsclone.R
import com.bayutb.threadsclone.data.Post

@Composable
fun HomePost(modifier: Modifier = Modifier, post: Post) {

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
                        painter = painterResource(id = R.drawable.profile),
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
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.verified_blue)),
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
                } else if(post.imageUrl != null) {
                    Box(modifier = modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = R.drawable.kitchen_set),
                            contentDescription = "Image",
                            modifier = modifier.clip(
                                shape = RoundedCornerShape(8.dp)
                            ).width(IntrinsicSize.Max),
                            contentScale = ContentScale.FillBounds
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = modifier.padding(top = 16.dp)
                ) {
                    Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Like")
                    Icon(
                        painter = painterResource(id = R.drawable.comment_blank_svgrepo_com),
                        contentDescription = "Comment"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.retweet_round_svgrepo_com),
                        contentDescription = "Retweet"
                    )
                    Icon(painter = painterResource(id = R.drawable.send_svgrepo_com), contentDescription = "Send")
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