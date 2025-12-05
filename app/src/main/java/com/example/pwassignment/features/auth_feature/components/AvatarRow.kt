package com.example.pwassignment.features.auth_feature.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset

@Composable
fun AvatarRow(
    modifier: Modifier = Modifier,
    topAvatar1: Int,
    topAvatar2: Int,
    bottomAvatar: Int,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {

            Box(
                modifier = Modifier // fixed size for perfect circle
                    .dropShadow(
                        shape = CircleShape,
                        shadow = Shadow(
                            color = Color(0xffFFD4D58F).copy(alpha = 0.53f), // Vibrant glow color
                            offset = DpOffset(x = 0.dp, y = 0.dp), // No offset for a central glow
                            radius = 20.dp,
                            spread = 20.dp // Extends the glow
                        )
                    )
                    .background(Color(0xffFFD4D5), CircleShape)
                    .size(150.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(topAvatar1),
                    contentDescription = null,
                    modifier = Modifier
                        // smaller than box so gray ring is visible
                        .clip(CircleShape),          // force circular cropping
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                modifier = Modifier // fixed size for perfect circle
                    .dropShadow(
                        shape = CircleShape,
                        shadow = Shadow(
                            color = Color(0xffFD4D58F).copy(alpha = 0.4f), // Vibrant glow color
                            offset = DpOffset(x = 0.dp, y = 0.dp), // No offset for a central glow
                            radius = 20.dp,
                            spread = 20.dp // Extends the glow
                        )
                    )
                    .background(Color(0xffDFF8FB), CircleShape)

                    .size(130.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(topAvatar2),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape),          // force circular cropping
                    contentScale = ContentScale.Crop
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier // fixed size for perfect circle
                .background(Color(0xffCDFACF), CircleShape)
                .size(130.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(bottomAvatar),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape),          // force circular cropping
                contentScale = ContentScale.Crop
            )
        }
    }
}
