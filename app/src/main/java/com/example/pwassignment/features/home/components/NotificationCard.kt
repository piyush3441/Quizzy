package com.example.pwassignment.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NotificationCard(
    color: Color,
    indicatorColor: Color,
    title: String,
    timeAgo: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color, RoundedCornerShape(10.dp))
            .padding(12.dp)
    ) {
        Box(
            modifier = Modifier
                .width(6.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(indicatorColor)
        )

        Spacer(Modifier.width(12.dp))

        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = timeAgo,
                style = MaterialTheme.typography.bodySmall.copy(Color.Gray)
            )
        }
    }
}
