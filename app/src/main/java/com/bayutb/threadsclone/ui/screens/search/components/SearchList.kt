package com.bayutb.threadsclone.ui.screens.search.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayutb.threadsclone.R
import com.bayutb.threadsclone.data.DataDummy
import com.bayutb.threadsclone.data.UserRecommendations
import com.bayutb.threadsclone.ui.theme.ThreadsCloneTheme

@Composable
fun RecommendationList(modifier: Modifier = Modifier, data : UserRecommendations) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile), contentDescription = null,
                modifier.size(50.dp)
            )
            Column(modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(modifier.weight(1f)) {
                        Text(
                            text = data.userId,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = data.name, color = Color.LightGray)
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        modifier
                            .size(100.dp, 30.dp),
                        border = ButtonDefaults.outlinedButtonBorder,
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.surface,
                            contentColor = MaterialTheme.colorScheme.onSurface
                        ),
                        contentPadding = PaddingValues(4.dp)
                    ) {
                        Text(text = "Follow")
                    }
                }
                Row(
                    modifier = modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box {
                        if (data.mutual > 1 ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                modifier
                                    .background(MaterialTheme.colorScheme.onSurface, CircleShape)
                                    .size(18.dp)
                                    .border(
                                        border = BorderStroke(
                                            2.dp,
                                            MaterialTheme.colorScheme.surface
                                        ), shape = CircleShape
                                    ),
                                tint = MaterialTheme.colorScheme.surface
                            )
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                modifier
                                    .padding(start = 12.dp, end = 8.dp)
                                    .background(MaterialTheme.colorScheme.onSurface, CircleShape)
                                    .size(18.dp)
                                    .border(
                                        border = BorderStroke(
                                            2.dp,
                                            MaterialTheme.colorScheme.surface
                                        ), shape = CircleShape
                                    ),
                                tint = MaterialTheme.colorScheme.surface
                            )
                        } else if (data.mutual == 1) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                modifier
                                    .padding(end = 8.dp)
                                    .background(MaterialTheme.colorScheme.onSurface, CircleShape)
                                    .size(18.dp)
                                    .border(
                                        border = BorderStroke(
                                            2.dp,
                                            MaterialTheme.colorScheme.surface
                                        ), shape = CircleShape
                                    ),
                                tint = MaterialTheme.colorScheme.surface
                            )
                        }
                    }
                    Text(text = "${data.followers} followers")
                }
                Divider(color = MaterialTheme.colorScheme.onSurface, thickness = 0.2.dp)
            }
        }
    }
}

@Composable
fun SearchList(modifier: Modifier = Modifier, data: UserRecommendations) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile), contentDescription = null,
                modifier.size(50.dp)
            )
            Column(modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(modifier.weight(1f)) {
                        Text(
                            text = data.userId,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = data.name, color = Color.LightGray)
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        modifier
                            .size(100.dp, 30.dp),
                        border = ButtonDefaults.outlinedButtonBorder,
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.surface,
                            contentColor = MaterialTheme.colorScheme.onSurface
                        ),
                        contentPadding = PaddingValues(4.dp)
                    ) {
                        Text(text = "Follow")
                    }
                }
                Row(
                    modifier = modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Spacer(modifier = modifier.height(8.dp))
                }
                Divider(color = MaterialTheme.colorScheme.onSurface, thickness = 0.2.dp)
            }
        }
    }
}
@Preview(
    showBackground = true, device = "id:pixel_5"
)
@Composable
fun PreviewSearchList() {
    ThreadsCloneTheme {
        DataDummy.generate()
        SearchList(data = DataDummy.recommendedUser[0])
    }
}