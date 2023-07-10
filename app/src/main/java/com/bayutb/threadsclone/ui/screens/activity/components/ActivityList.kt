package com.bayutb.threadsclone.ui.screens.activity.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bayutb.threadsclone.R
import com.bayutb.threadsclone.data.User

@Composable
fun ActivityList(modifier: Modifier = Modifier, activityUser: User) {

    Box(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(contentAlignment = Alignment.BottomEnd) {
                Image(
                    painter = painterResource(id = R.drawable.profile_sample),
                    contentDescription = "Profile Picture",
                    modifier = modifier.size(50.dp)
                )
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Reference",
                    modifier = modifier.background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = CircleShape
                    )
                )
            }
            Column(modifier.weight(1f)) {
                Text(text = activityUser.userId, fontWeight = FontWeight.Bold)
                Text(text = "Followed you", color = Color.Gray)
            }

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    contentColor = Color.Gray
                ),
                border = BorderStroke(1.dp, Color.LightGray),
                modifier = modifier.width(110.dp).height(35.dp),
                shape = RoundedCornerShape(12.dp),
            ) {
                Text(text = "Following", fontWeight = FontWeight.Bold)
            }
        }
    }
}