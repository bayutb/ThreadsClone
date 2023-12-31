package com.bayutb.threadsclone.ui.screens.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayutb.threadsclone.data.DataDummy
import com.bayutb.threadsclone.data.User
import com.bayutb.threadsclone.ui.screens.activity.components.ActivityList
import com.bayutb.threadsclone.ui.screens.activity.components.TopAppBar
import com.bayutb.threadsclone.ui.theme.ThreadsCloneTheme

@Composable
fun ActivityScreen(
    modifier: Modifier = Modifier,
    data: List<User>
) {
    val filter = listOf("All", "Requests", "Replies", "Mentions")
    Scaffold(
        topBar = { TopAppBar(modifier) }
    ) { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                content = {
                    items(filter) {
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.onPrimary,
                                contentColor = MaterialTheme.colorScheme.primary
                            ),
                            border = ButtonDefaults.outlinedButtonBorder,
                            modifier = modifier.width(110.dp),
                            shape = RoundedCornerShape(12.dp),
                        ) {
                            Text(text = it)
                        }
                    }
                }
            )
            LazyColumn(contentPadding = PaddingValues(16.dp, vertical = 8.dp), verticalArrangement = Arrangement.spacedBy(8.dp),content = {
                items(data) {
                    ActivityList(activityUser = it)
                }
            })
        }
    }
}

@Preview(
    showBackground = true,
    device = "id:pixel_5"
)
@Composable
fun PreviewActivityScreen() {
    ThreadsCloneTheme {
        ActivityScreen(data = DataDummy.activityUser)
    }
}